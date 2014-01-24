/*
 * Copyright 2009-2014 the CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package jp.sf.fess.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.sf.fess.Constants;
import jp.sf.fess.FessSystemException;
import jp.sf.fess.crypto.FessCipher;
import jp.sf.fess.entity.LoginInfo;
import jp.sf.fess.form.LoginForm;
import jp.sf.fess.helper.SystemHelper;

import org.apache.struts.Globals;
import org.seasar.framework.util.StringUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginAction implements Serializable {
    private static final Logger logger = LoggerFactory
            .getLogger(LoginAction.class);

    private static final long serialVersionUID = 1L;

    @ActionForm
    @Resource
    protected LoginForm loginForm;

    @Resource
    protected SystemHelper systemHelper;

    @Execute(validator = false, input = "../index")
    public String index() {
        final HttpServletRequest request = RequestUtil.getRequest();
        final HttpSession session = request.getSession();
        // check login session
        final Object obj = session.getAttribute(Constants.LOGIN_INFO);
        if (obj instanceof LoginInfo) {
            final LoginInfo loginInfo = (LoginInfo) obj;
            if (loginInfo.isAdministrator()) {
                redirect(getAdminRootPath());
                return null;
            } else {
                return "logout.jsp";
            }
        }

        if ("logout".equals(loginForm.type)) {
            if (logger.isInfoEnabled()) {
                logger.info("Invalidated session. The username is "
                        + request.getRemoteUser());
            }
            session.invalidate();
        }

        String returnPath;
        if (StringUtil.isNotBlank(loginForm.returnPath)) {
            final FessCipher fessCipher = FessCipher.class.cast(RequestUtil
                    .getRequest().getAttribute(Constants.AUTH_CIPHER));
            if (fessCipher == null) {
                throw new FessSystemException(
                        "A cipher for authentication is null. Please check a filter setting.");
            }
            final String value = fessCipher.decryptoText(loginForm.returnPath);
            final int idx = value.indexOf('|');
            if (idx >= 0) {
                returnPath = value.substring(idx + 1);
                RequestUtil.getRequest().getSession()
                        .setAttribute(Constants.RETURN_PATH, returnPath);
            } else {
                // invalid returnPath
                RequestUtil.getRequest().getSession()
                        .removeAttribute(Constants.RETURN_PATH);
            }
        } else {
            RequestUtil.getRequest().getSession()
                    .removeAttribute(Constants.RETURN_PATH);
        }

        return "login?redirect=true";
    }

    @Execute(validator = false, input = "../index")
    public String login() {
        final HttpServletRequest request = RequestUtil.getRequest();
        final HttpSession oldSession = request.getSession();

        final Map<String, Object> sessionObjMap = new HashMap<String, Object>();
        final Enumeration<String> e = oldSession.getAttributeNames();
        while (e.hasMoreElements()) {
            final String name = e.nextElement();
            sessionObjMap.put(name, oldSession.getAttribute(name));
        }
        oldSession.invalidate();

        sessionObjMap.remove(Globals.MESSAGE_KEY);

        final HttpSession session = request.getSession();
        for (final Map.Entry<String, Object> entry : sessionObjMap.entrySet()) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }

        // create user info
        final LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUsername(request.getRemoteUser());
        session.setAttribute(Constants.LOGIN_INFO, loginInfo);

        String returnPath;
        final List<String> authenticatedRoleList = systemHelper
                .getAuthenticatedRoleList();
        if (request.isUserInRole(systemHelper.getAdminRole())) {
            if (logger.isInfoEnabled()) {
                logger.info("[LOGIN] ADMIN: " + "The usename is "
                        + request.getRemoteUser());
            }
            loginInfo.setAdministrator(true);

            if (authenticatedRoleList != null) {
                for (final String role : authenticatedRoleList) {
                    if (request.isUserInRole(role)) {
                        loginInfo.addRole(role);
                    }
                }
            }

            returnPath = (String) session.getAttribute(Constants.RETURN_PATH);
            if (returnPath != null) {
                session.removeAttribute(Constants.RETURN_PATH);
            } else {
                // admin page
                returnPath = getAdminRootPath();
            }
        } else {
            if (authenticatedRoleList != null) {
                boolean authenticated = false;
                for (final String role : authenticatedRoleList) {
                    if (request.isUserInRole(role)) {
                        loginInfo.addRole(role);
                        authenticated = true;
                    }
                }
                if (authenticated) {
                    if (logger.isInfoEnabled()) {
                        logger.info("[LOGIN] USER: " + "The usename is "
                                + request.getRemoteUser());
                    }
                    loginInfo.setAdministrator(false);
                } else {
                    if (logger.isWarnEnabled()) {
                        logger.warn("Login Failure: " + request.getRemoteUser()
                                + " does not have authenticated roles.");
                    }
                    // logout
                    session.invalidate();
                }
            }
            returnPath = RequestUtil.getRequest().getContextPath();
        }

        redirect(returnPath);

        return null;
    }

    private void redirect(final String returnPath) {
        final HttpServletResponse response = ResponseUtil.getResponse();
        try {
            response.sendRedirect(response.encodeURL(returnPath));
        } catch (final IOException e) {
            throw new FessSystemException(
                    "Failed to redirect to " + returnPath, e);
        }
    }

    private String getAdminRootPath() {
        String returnPath = RequestUtil.getRequest().getContextPath();
        if (StringUtil.isEmpty(returnPath) || "/".equals(returnPath)) {
            returnPath = "/admin";
        } else {
            returnPath = returnPath + "/admin";
        }
        return returnPath;
    }

    @Execute(validator = false, input = "../index")
    public String logout() {
        final HttpServletRequest request = RequestUtil.getRequest();
        if (logger.isInfoEnabled()) {
            logger.info("[LOGOUT] " + "The usename is "
                    + request.getRemoteUser());
        }
        final HttpSession session = request.getSession();
        session.invalidate();

        return "login?redirect=true";
    }
}