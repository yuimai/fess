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

package jp.sf.fess.form.admin;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.sf.fess.Constants;
import jp.sf.fess.crud.form.admin.BsWebCrawlingConfigForm;

import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.util.StringUtil;

public class WebCrawlingConfigForm extends BsWebCrawlingConfigForm implements
        Serializable {

    private static final long serialVersionUID = 1L;

    public String[] browserTypeIds;

    public String[] roleTypeIds;

    public String[] labelTypeIds;

    @Override
    public void initialize() {
        super.initialize();
        sortOrder = "0";
        userAgent = SingletonS2Container.getComponent("userAgentName");
        if (StringUtil.isBlank(userAgent)) {
            userAgent = "Fess Robot/1.0";
        }
        numOfThread = Integer.toString(Constants.DEFAULT_NUM_OF_THREAD_FOR_WEB);
        intervalTime = Integer
                .toString(Constants.DEFAULT_INTERVAL_TIME_FOR_WEB);
        // Temporary data
        createdBy = "system";
        final SimpleDateFormat sdf = new SimpleDateFormat(
                Constants.DEFAULT_DATETIME_FORMAT);
        createdTime = sdf.format(new Date());

    }
}
