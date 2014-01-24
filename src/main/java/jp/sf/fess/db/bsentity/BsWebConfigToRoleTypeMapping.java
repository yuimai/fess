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

package jp.sf.fess.db.bsentity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jp.sf.fess.db.allcommon.DBMetaInstanceHandler;
import jp.sf.fess.db.exentity.RoleType;
import jp.sf.fess.db.exentity.WebConfigToRoleTypeMapping;
import jp.sf.fess.db.exentity.WebCrawlingConfig;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;

/**
 * The entity of WEB_CONFIG_TO_ROLE_TYPE_MAPPING as TABLE. <br />
 * <pre>
 * [primary-key]
 *     ID
 * 
 * [column]
 *     ID, WEB_CONFIG_ID, ROLE_TYPE_ID
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     ID
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     WEB_CRAWLING_CONFIG, ROLE_TYPE
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     webCrawlingConfig, roleType
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long id = entity.getId();
 * Long webConfigId = entity.getWebConfigId();
 * Long roleTypeId = entity.getRoleTypeId();
 * entity.setId(id);
 * entity.setWebConfigId(webConfigId);
 * entity.setRoleTypeId(roleTypeId);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsWebConfigToRoleTypeMapping implements Entity,
        Serializable, Cloneable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _id;

    /** WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG} */
    protected Long _webConfigId;

    /** ROLE_TYPE_ID: {IX, NotNull, BIGINT(19), FK to ROLE_TYPE} */
    protected Long _roleTypeId;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    @Override
    public String getTableDbName() {
        return "WEB_CONFIG_TO_ROLE_TYPE_MAPPING";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTablePropertyName() { // according to Java Beans rule
        return "webConfigToRoleTypeMapping";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    @Override
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasPrimaryKeyValue() {
        if (getId() == null) {
            return false;
        }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'. */
    protected WebCrawlingConfig _webCrawlingConfig;

    /**
     * WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'.
     * @return The entity of foreign property 'webCrawlingConfig'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public WebCrawlingConfig getWebCrawlingConfig() {
        return _webCrawlingConfig;
    }

    /**
     * WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'.
     * @param webCrawlingConfig The entity of foreign property 'webCrawlingConfig'. (NullAllowed)
     */
    public void setWebCrawlingConfig(final WebCrawlingConfig webCrawlingConfig) {
        _webCrawlingConfig = webCrawlingConfig;
    }

    /** ROLE_TYPE by my ROLE_TYPE_ID, named 'roleType'. */
    protected RoleType _roleType;

    /**
     * ROLE_TYPE by my ROLE_TYPE_ID, named 'roleType'.
     * @return The entity of foreign property 'roleType'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public RoleType getRoleType() {
        return _roleType;
    }

    /**
     * ROLE_TYPE by my ROLE_TYPE_ID, named 'roleType'.
     * @param roleType The entity of foreign property 'roleType'. (NullAllowed)
     */
    public void setRoleType(final RoleType roleType) {
        _roleType = roleType;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param other The other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof BsWebConfigToRoleTypeMapping)) {
            return false;
        }
        final BsWebConfigToRoleTypeMapping otherEntity = (BsWebConfigToRoleTypeMapping) other;
        if (!xSV(getId(), otherEntity.getId())) {
            return false;
        }
        return true;
    }

    protected boolean xSV(final Object value1, final Object value2) { // isSameValue()
        return InternalUtil.isSameValue(value1, value2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = xCH(result, getTableDbName());
        result = xCH(result, getId());
        return result;
    }

    protected int xCH(final int result, final Object value) { // calculateHashcode()
        return InternalUtil.calculateHashcode(result, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    @Override
    public String toString() {
        return buildDisplayString(InternalUtil.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toStringWithRelation() {
        final StringBuilder sb = new StringBuilder();
        sb.append(toString());
        final String l = "\n  ";
        if (_webCrawlingConfig != null) {
            sb.append(l).append(xbRDS(_webCrawlingConfig, "webCrawlingConfig"));
        }
        if (_roleType != null) {
            sb.append(l).append(xbRDS(_roleType, "roleType"));
        }
        return sb.toString();
    }

    protected String xbRDS(final Entity e, final String name) { // buildRelationDisplayString()
        return e.buildDisplayString(name, true, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String buildDisplayString(final String name, final boolean column,
            final boolean relation) {
        final StringBuilder sb = new StringBuilder();
        if (name != null) {
            sb.append(name).append(column || relation ? ":" : "");
        }
        if (column) {
            sb.append(buildColumnString());
        }
        if (relation) {
            sb.append(buildRelationString());
        }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }

    protected String buildColumnString() {
        final StringBuilder sb = new StringBuilder();
        final String delimiter = ", ";
        sb.append(delimiter).append(getId());
        sb.append(delimiter).append(getWebConfigId());
        sb.append(delimiter).append(getRoleTypeId());
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    protected String buildRelationString() {
        final StringBuilder sb = new StringBuilder();
        final String c = ",";
        if (_webCrawlingConfig != null) {
            sb.append(c).append("webCrawlingConfig");
        }
        if (_roleType != null) {
            sb.append(c).append("roleType");
        }
        if (sb.length() > c.length()) {
            sb.delete(0, c.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    @Override
    public WebConfigToRoleTypeMapping clone() {
        try {
            return (WebConfigToRoleTypeMapping) super.clone();
        } catch (final CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: "
                    + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getId() {
        return _id;
    }

    /**
     * [set] ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param id The value of the column 'ID'. (basically NotNull if update: for the constraint)
     */
    public void setId(final Long id) {
        __modifiedProperties.addPropertyName("id");
        _id = id;
    }

    /**
     * [get] WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG} <br />
     * @return The value of the column 'WEB_CONFIG_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getWebConfigId() {
        return _webConfigId;
    }

    /**
     * [set] WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG} <br />
     * @param webConfigId The value of the column 'WEB_CONFIG_ID'. (basically NotNull if update: for the constraint)
     */
    public void setWebConfigId(final Long webConfigId) {
        __modifiedProperties.addPropertyName("webConfigId");
        _webConfigId = webConfigId;
    }

    /**
     * [get] ROLE_TYPE_ID: {IX, NotNull, BIGINT(19), FK to ROLE_TYPE} <br />
     * @return The value of the column 'ROLE_TYPE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getRoleTypeId() {
        return _roleTypeId;
    }

    /**
     * [set] ROLE_TYPE_ID: {IX, NotNull, BIGINT(19), FK to ROLE_TYPE} <br />
     * @param roleTypeId The value of the column 'ROLE_TYPE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setRoleTypeId(final Long roleTypeId) {
        __modifiedProperties.addPropertyName("roleTypeId");
        _roleTypeId = roleTypeId;
    }
}
