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

package jp.sf.fess.db.cbean.bs;

import jp.sf.fess.db.allcommon.DBFluteConfig;
import jp.sf.fess.db.allcommon.DBMetaInstanceHandler;
import jp.sf.fess.db.allcommon.ImplementedInvokerAssistant;
import jp.sf.fess.db.allcommon.ImplementedSqlClauseCreator;
import jp.sf.fess.db.cbean.LabelTypeCB;
import jp.sf.fess.db.cbean.LabelTypeToRoleTypeMappingCB;
import jp.sf.fess.db.cbean.RoleTypeCB;
import jp.sf.fess.db.cbean.cq.LabelTypeCQ;
import jp.sf.fess.db.cbean.cq.LabelTypeToRoleTypeMappingCQ;
import jp.sf.fess.db.cbean.cq.RoleTypeCQ;
import jp.sf.fess.db.cbean.nss.LabelTypeNss;
import jp.sf.fess.db.cbean.nss.RoleTypeNss;

import org.seasar.dbflute.cbean.AbstractConditionBean;
import org.seasar.dbflute.cbean.AndQuery;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.chelper.HpAbstractSpecification;
import org.seasar.dbflute.cbean.chelper.HpCBPurpose;
import org.seasar.dbflute.cbean.chelper.HpCalculator;
import org.seasar.dbflute.cbean.chelper.HpColQyHandler;
import org.seasar.dbflute.cbean.chelper.HpColQyOperand;
import org.seasar.dbflute.cbean.chelper.HpColumnSpHandler;
import org.seasar.dbflute.cbean.chelper.HpSDRFunction;
import org.seasar.dbflute.cbean.chelper.HpSDRSetupper;
import org.seasar.dbflute.cbean.chelper.HpSpQyCall;
import org.seasar.dbflute.cbean.chelper.HpSpecifiedColumn;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.cbean.sqlclause.SqlClauseCreator;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import org.seasar.dbflute.twowaysql.factory.SqlAnalyzerFactory;

/**
 * The base condition-bean of LABEL_TYPE_TO_ROLE_TYPE_MAPPING.
 * @author DBFlute(AutoGenerator)
 */
public class BsLabelTypeToRoleTypeMappingCB extends AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected LabelTypeToRoleTypeMappingCQ _conditionQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsLabelTypeToRoleTypeMappingCB() {
        if (DBFluteConfig.getInstance().isPagingCountLater()) {
            enablePagingCountLater();
        }
        if (DBFluteConfig.getInstance().isPagingCountLeastJoin()) {
            enablePagingCountLeastJoin();
        }
        if (DBFluteConfig.getInstance().isCheckCountBeforeQueryUpdate()) {
            enableCheckCountBeforeQueryUpdate();
        }
    }

    // ===================================================================================
    //                                                                           SqlClause
    //                                                                           =========
    @Override
    protected SqlClause createSqlClause() {
        final SqlClauseCreator creator = DBFluteConfig.getInstance()
                .getSqlClauseCreator();
        if (creator != null) {
            return creator.createSqlClause(this);
        }
        return new ImplementedSqlClauseCreator().createSqlClause(this); // as default
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider getDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider(); // as default
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    @Override
    public String getTableDbName() {
        return "LABEL_TYPE_TO_ROLE_TYPE_MAPPING";
    }

    // ===================================================================================
    //                                                                 PrimaryKey Handling
    //                                                                 ===================
    public void acceptPrimaryKey(final Long id) {
        assertObjectNotNull("id", id);
        final BsLabelTypeToRoleTypeMappingCB cb = this;
        cb.query().setId_Equal(id);
    }

    @Override
    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_Id_Asc();
        return this;
    }

    @Override
    public ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_Id_Desc();
        return this;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Prepare for various queries. <br />
     * Examples of main functions are following:
     * <pre>
     * <span style="color: #3F7E5E">// Basic Queries</span>
     * cb.query().setMemberId_Equal(value);        <span style="color: #3F7E5E">// =</span>
     * cb.query().setMemberId_NotEqual(value);     <span style="color: #3F7E5E">// !=</span>
     * cb.query().setMemberId_GreaterThan(value);  <span style="color: #3F7E5E">// &gt;</span>
     * cb.query().setMemberId_LessThan(value);     <span style="color: #3F7E5E">// &lt;</span>
     * cb.query().setMemberId_GreaterEqual(value); <span style="color: #3F7E5E">// &gt;=</span>
     * cb.query().setMemberId_LessEqual(value);    <span style="color: #3F7E5E">// &lt;=</span>
     * cb.query().setMemberName_InScope(valueList);    <span style="color: #3F7E5E">// in ('a', 'b')</span>
     * cb.query().setMemberName_NotInScope(valueList); <span style="color: #3F7E5E">// not in ('a', 'b')</span>
     * cb.query().setMemberName_PrefixSearch(value);   <span style="color: #3F7E5E">// like 'a%' escape '|'</span>
     * <span style="color: #3F7E5E">// LikeSearch with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {like ... [options]}</span>
     * cb.query().setMemberName_LikeSearch(value, option);
     * cb.query().setMemberName_NotLikeSearch(value, option); <span style="color: #3F7E5E">// not like ...</span>
     * <span style="color: #3F7E5E">// FromTo with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {(default) fromDatetime &lt;= BIRTHDATE &lt;= toDatetime}</span>
     * cb.query().setBirthdate_FromTo(fromDatetime, toDatetime, option);
     * <span style="color: #3F7E5E">// DateFromTo: (Date means yyyy/MM/dd)</span>
     * <span style="color: #3F7E5E">// {fromDate &lt;= BIRTHDATE &lt; toDate + 1 day}</span>
     * cb.query().setBirthdate_DateFromTo(fromDate, toDate);
     * cb.query().setBirthdate_IsNull();    <span style="color: #3F7E5E">// is null</span>
     * cb.query().setBirthdate_IsNotNull(); <span style="color: #3F7E5E">// is not null</span>
     * 
     * <span style="color: #3F7E5E">// ExistsReferrer: (co-related sub-query)</span>
     * <span style="color: #3F7E5E">// {where exists (select PURCHASE_ID from PURCHASE where ...)}</span>
     * cb.query().existsPurchaseList(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     *     }
     * });
     * cb.query().notExistsPurchaseList...
     * 
     * <span style="color: #3F7E5E">// InScopeRelation: (sub-query)</span>
     * <span style="color: #3F7E5E">// {where MEMBER_STATUS_CODE in (select MEMBER_STATUS_CODE from MEMBER_STATUS where ...)}</span>
     * cb.query().inScopeMemberStatus(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// relation sub-query condition</span>
     *     }
     * });
     * cb.query().notInScopeMemberStatus...
     * 
     * <span style="color: #3F7E5E">// (Query)DerivedReferrer: (co-related sub-query)</span>
     * cb.query().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchasePrice(); <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     *     }
     * }).greaterEqual(value);
     * 
     * <span style="color: #3F7E5E">// ScalarCondition: (self-table sub-query)</span>
     * cb.query().scalar_Equal().max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().columnBirthdate(); <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// scalar sub-query condition</span>
     *     }
     * });
     * 
     * <span style="color: #3F7E5E">// OrderBy</span>
     * cb.query().addOrderBy_MemberName_Asc();
     * cb.query().addOrderBy_MemberName_Desc().withManualOrder(valueList);
     * cb.query().addOrderBy_MemberName_Desc().withNullsFirst();
     * cb.query().addOrderBy_MemberName_Desc().withNullsLast();
     * cb.query().addSpecifiedDerivedOrderBy_Desc(aliasName);
     * 
     * <span style="color: #3F7E5E">// Query(Relation)</span>
     * cb.query().queryMemberStatus()...;
     * cb.query().queryMemberAddressAsValid(targetDate)...;
     * </pre>
     * @return The instance of condition-query for base-point table to set up query. (NotNull)
     */
    public LabelTypeToRoleTypeMappingCQ query() {
        assertQueryPurpose(); // assert only when user-public query 
        return getConditionQuery();
    }

    public LabelTypeToRoleTypeMappingCQ getConditionQuery() { // public for parameter comment and internal
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected LabelTypeToRoleTypeMappingCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause()
                .getBasePointAliasName(), 0);
    }

    protected LabelTypeToRoleTypeMappingCQ xcreateCQ(
            final ConditionQuery childQuery, final SqlClause sqlClause,
            final String aliasName, final int nestLevel) {
        final LabelTypeToRoleTypeMappingCQ cq = xnewCQ(childQuery, sqlClause,
                aliasName, nestLevel);
        cq.xsetBaseCB(this);
        return cq;
    }

    protected LabelTypeToRoleTypeMappingCQ xnewCQ(
            final ConditionQuery childQuery, final SqlClause sqlClause,
            final String aliasName, final int nestLevel) {
        return new LabelTypeToRoleTypeMappingCQ(childQuery, sqlClause,
                aliasName, nestLevel);
    }

    @Override
    public ConditionQuery localCQ() {
        return getConditionQuery();
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Set up 'union' for base-point table. <br />
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #FD4747">union</span>(new UnionQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *     public void query(LabelTypeToRoleTypeMappingCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(final UnionQuery<LabelTypeToRoleTypeMappingCB> unionQuery) {
        final LabelTypeToRoleTypeMappingCB cb = new LabelTypeToRoleTypeMappingCB();
        cb.xsetupForUnion(this);
        xsyncUQ(cb);
        unionQuery.query(cb);
        xsaveUCB(cb);
        final LabelTypeToRoleTypeMappingCQ cq = cb.query();
        query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all' for base-point table. <br />
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #FD4747">unionAll</span>(new UnionQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *     public void query(LabelTypeToRoleTypeMappingCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union all'. (NotNull)
     */
    public void unionAll(
            final UnionQuery<LabelTypeToRoleTypeMappingCB> unionQuery) {
        final LabelTypeToRoleTypeMappingCB cb = new LabelTypeToRoleTypeMappingCB();
        cb.xsetupForUnion(this);
        xsyncUQ(cb);
        unionQuery.query(cb);
        xsaveUCB(cb);
        final LabelTypeToRoleTypeMappingCQ cq = cb.query();
        query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    protected LabelTypeNss _nssLabelType;

    public LabelTypeNss getNssLabelType() {
        if (_nssLabelType == null) {
            _nssLabelType = new LabelTypeNss(null);
        }
        return _nssLabelType;
    }

    /**
     * Set up relation columns to select clause. <br />
     * LABEL_TYPE by my LABEL_TYPE_ID, named 'labelType'.
     * <pre>
     * LabelTypeToRoleTypeMappingCB cb = new LabelTypeToRoleTypeMappingCB();
     * cb.<span style="color: #FD4747">setupSelect_LabelType()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * LabelTypeToRoleTypeMapping labelTypeToRoleTypeMapping = labelTypeToRoleTypeMappingBhv.selectEntityWithDeletedCheck(cb);
     * ... = labelTypeToRoleTypeMapping.<span style="color: #FD4747">getLabelType()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public LabelTypeNss setupSelect_LabelType() {
        if (hasSpecifiedColumn()) { // if reverse call
            specify().columnLabelTypeId();
        }
        doSetupSelect(new SsCall() {
            @Override
            public ConditionQuery qf() {
                return query().queryLabelType();
            }
        });
        if (_nssLabelType == null || !_nssLabelType.hasConditionQuery()) {
            _nssLabelType = new LabelTypeNss(query().queryLabelType());
        }
        return _nssLabelType;
    }

    protected RoleTypeNss _nssRoleType;

    public RoleTypeNss getNssRoleType() {
        if (_nssRoleType == null) {
            _nssRoleType = new RoleTypeNss(null);
        }
        return _nssRoleType;
    }

    /**
     * Set up relation columns to select clause. <br />
     * ROLE_TYPE by my ROLE_TYPE_ID, named 'roleType'.
     * <pre>
     * LabelTypeToRoleTypeMappingCB cb = new LabelTypeToRoleTypeMappingCB();
     * cb.<span style="color: #FD4747">setupSelect_RoleType()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * LabelTypeToRoleTypeMapping labelTypeToRoleTypeMapping = labelTypeToRoleTypeMappingBhv.selectEntityWithDeletedCheck(cb);
     * ... = labelTypeToRoleTypeMapping.<span style="color: #FD4747">getRoleType()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public RoleTypeNss setupSelect_RoleType() {
        if (hasSpecifiedColumn()) { // if reverse call
            specify().columnRoleTypeId();
        }
        doSetupSelect(new SsCall() {
            @Override
            public ConditionQuery qf() {
                return query().queryRoleType();
            }
        });
        if (_nssRoleType == null || !_nssRoleType.hasConditionQuery()) {
            _nssRoleType = new RoleTypeNss(query().queryRoleType());
        }
        return _nssRoleType;
    }

    // [DBFlute-0.7.4]
    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    protected HpSpecification _specification;

    /**
     * Prepare for SpecifyColumn, (Specify)DerivedReferrer. <br />
     * This method should be called after SetupSelect.
     * <pre>
     * cb.setupSelect_MemberStatus(); <span style="color: #3F7E5E">// should be called before specify()</span>
     * cb.specify().columnMemberName();
     * cb.specify().specifyMemberStatus().columnMemberStatusName();
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *         subCB.query().set...
     *     }
     * }, aliasName);
     * </pre>
     * @return The instance of specification. (NotNull)
     */
    public HpSpecification specify() {
        assertSpecifyPurpose();
        if (_specification == null) {
            _specification = new HpSpecification(this,
                    new HpSpQyCall<LabelTypeToRoleTypeMappingCQ>() {
                        @Override
                        public boolean has() {
                            return true;
                        }

                        @Override
                        public LabelTypeToRoleTypeMappingCQ qy() {
                            return getConditionQuery();
                        }
                    }, _purpose, getDBMetaProvider());
        }
        return _specification;
    }

    @Override
    public HpColumnSpHandler localSp() {
        return specify();
    }

    @Override
    public boolean hasSpecifiedColumn() {
        return _specification != null
                && _specification.isAlreadySpecifiedRequiredColumn();
    }

    public static class HpSpecification extends
            HpAbstractSpecification<LabelTypeToRoleTypeMappingCQ> {
        protected LabelTypeCB.HpSpecification _labelType;

        protected RoleTypeCB.HpSpecification _roleType;

        public HpSpecification(final ConditionBean baseCB,
                final HpSpQyCall<LabelTypeToRoleTypeMappingCQ> qyCall,
                final HpCBPurpose purpose, final DBMetaProvider dbmetaProvider) {
            super(baseCB, qyCall, purpose, dbmetaProvider);
        }

        /**
         * ID: {PK, ID, NotNull, BIGINT(19)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnId() {
            return doColumn("ID");
        }

        /**
         * LABEL_TYPE_ID: {IX, NotNull, BIGINT(19), FK to LABEL_TYPE}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnLabelTypeId() {
            return doColumn("LABEL_TYPE_ID");
        }

        /**
         * ROLE_TYPE_ID: {IX, NotNull, BIGINT(19), FK to ROLE_TYPE}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnRoleTypeId() {
            return doColumn("ROLE_TYPE_ID");
        }

        @Override
        public void everyColumn() {
            doEveryColumn();
        }

        @Override
        public void exceptRecordMetaColumn() {
            doExceptRecordMetaColumn();
        }

        @Override
        protected void doSpecifyRequiredColumn() {
            columnId(); // PK
            if (qyCall().qy().hasConditionQueryLabelType()
                    || qyCall().qy().xgetReferrerQuery() instanceof LabelTypeCQ) {
                columnLabelTypeId(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryRoleType()
                    || qyCall().qy().xgetReferrerQuery() instanceof RoleTypeCQ) {
                columnRoleTypeId(); // FK or one-to-one referrer
            }
        }

        @Override
        protected String getTableDbName() {
            return "LABEL_TYPE_TO_ROLE_TYPE_MAPPING";
        }

        /**
         * Prepare to specify functions about relation table. <br />
         * LABEL_TYPE by my LABEL_TYPE_ID, named 'labelType'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public LabelTypeCB.HpSpecification specifyLabelType() {
            assertRelation("labelType");
            if (_labelType == null) {
                _labelType = new LabelTypeCB.HpSpecification(_baseCB,
                        new HpSpQyCall<LabelTypeCQ>() {
                            @Override
                            public boolean has() {
                                return _qyCall.has()
                                        && _qyCall.qy()
                                                .hasConditionQueryLabelType();
                            }

                            @Override
                            public LabelTypeCQ qy() {
                                return _qyCall.qy().queryLabelType();
                            }
                        }, _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _labelType.xsetSyncQyCall(new HpSpQyCall<LabelTypeCQ>() {
                        @Override
                        public boolean has() {
                            return xsyncQyCall().has()
                                    && xsyncQyCall().qy()
                                            .hasConditionQueryLabelType();
                        }

                        @Override
                        public LabelTypeCQ qy() {
                            return xsyncQyCall().qy().queryLabelType();
                        }
                    });
                }
            }
            return _labelType;
        }

        /**
         * Prepare to specify functions about relation table. <br />
         * ROLE_TYPE by my ROLE_TYPE_ID, named 'roleType'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public RoleTypeCB.HpSpecification specifyRoleType() {
            assertRelation("roleType");
            if (_roleType == null) {
                _roleType = new RoleTypeCB.HpSpecification(_baseCB,
                        new HpSpQyCall<RoleTypeCQ>() {
                            @Override
                            public boolean has() {
                                return _qyCall.has()
                                        && _qyCall.qy()
                                                .hasConditionQueryRoleType();
                            }

                            @Override
                            public RoleTypeCQ qy() {
                                return _qyCall.qy().queryRoleType();
                            }
                        }, _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _roleType.xsetSyncQyCall(new HpSpQyCall<RoleTypeCQ>() {
                        @Override
                        public boolean has() {
                            return xsyncQyCall().has()
                                    && xsyncQyCall().qy()
                                            .hasConditionQueryRoleType();
                        }

                        @Override
                        public RoleTypeCQ qy() {
                            return xsyncQyCall().qy().queryRoleType();
                        }
                    });
                }
            }
            return _roleType;
        }

        /**
         * Prepare for (Specify)MyselfDerived (SubQuery).
         * @return The object to set up a function for myself table. (NotNull)
         */
        public HpSDRFunction<LabelTypeToRoleTypeMappingCB, LabelTypeToRoleTypeMappingCQ> myselfDerived() {
            assertDerived("myselfDerived");
            if (xhasSyncQyCall()) {
                xsyncQyCall().qy();
            } // for sync (for example, this in ColumnQuery)
            return new HpSDRFunction<LabelTypeToRoleTypeMappingCB, LabelTypeToRoleTypeMappingCQ>(
                    _baseCB,
                    _qyCall.qy(),
                    new HpSDRSetupper<LabelTypeToRoleTypeMappingCB, LabelTypeToRoleTypeMappingCQ>() {
                        @Override
                        public void setup(
                                final String function,
                                final SubQuery<LabelTypeToRoleTypeMappingCB> subQuery,
                                final LabelTypeToRoleTypeMappingCQ cq,
                                final String aliasName,
                                final DerivedReferrerOption option) {
                            cq.xsmyselfDerive(function, subQuery, aliasName,
                                    option);
                        }
                    }, _dbmetaProvider);
        }
    }

    // [DBFlute-0.9.5.3]
    // ===================================================================================
    //                                                                         ColumnQuery
    //                                                                         ===========
    /**
     * Set up column-query. {column1 = column2}
     * <pre>
     * <span style="color: #3F7E5E">// where FOO &lt; BAR</span>
     * cb.<span style="color: #FD4747">columnQuery</span>(new SpecifyQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *     public void query(LabelTypeToRoleTypeMappingCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFoo()</span>; <span style="color: #3F7E5E">// left column</span>
     *     }
     * }).lessThan(new SpecifyQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *     public void query(LabelTypeToRoleTypeMappingCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnBar()</span>; <span style="color: #3F7E5E">// right column</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can calculate for right column like '}).plus(3);'</span>
     * </pre>
     * @param leftSpecifyQuery The specify-query for left column. (NotNull)
     * @return The object for setting up operand and right column. (NotNull)
     */
    public HpColQyOperand<LabelTypeToRoleTypeMappingCB> columnQuery(
            final SpecifyQuery<LabelTypeToRoleTypeMappingCB> leftSpecifyQuery) {
        return new HpColQyOperand<LabelTypeToRoleTypeMappingCB>(
                new HpColQyHandler<LabelTypeToRoleTypeMappingCB>() {
                    @Override
                    public HpCalculator handle(
                            final SpecifyQuery<LabelTypeToRoleTypeMappingCB> rightSp,
                            final String operand) {
                        return xcolqy(xcreateColumnQueryCB(),
                                xcreateColumnQueryCB(), leftSpecifyQuery,
                                rightSp, operand);
                    }
                });
    }

    protected LabelTypeToRoleTypeMappingCB xcreateColumnQueryCB() {
        final LabelTypeToRoleTypeMappingCB cb = new LabelTypeToRoleTypeMappingCB();
        cb.xsetupForColumnQuery(this);
        return cb;
    }

    // ===================================================================================
    //                                                                        Dream Cruise
    //                                                                        ============
    /**
     * Welcome to the Dream Cruise for condition-bean deep world. <br />
     * This is very specialty so you can get the frontier spirit. Bon voyage!
     * @return The condition-bean for dream cruise, which is linked to main condition-bean.
     */
    public LabelTypeToRoleTypeMappingCB dreamCruiseCB() {
        final LabelTypeToRoleTypeMappingCB cb = new LabelTypeToRoleTypeMappingCB();
        cb.xsetupForDreamCruise(this);
        return cb;
    }

    @Override
    protected ConditionBean xdoCreateDreamCruiseCB() {
        return dreamCruiseCB();
    }

    // [DBFlute-0.9.6.3]
    // ===================================================================================
    //                                                                        OrScopeQuery
    //                                                                        ============
    /**
     * Set up the query for or-scope. <br />
     * (Same-column-and-same-condition-key conditions are allowed in or-scope)
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or BAR = '...')</span>
     * cb.<span style="color: #FD4747">orScopeQuery</span>(new OrQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *     public void query(LabelTypeToRoleTypeMappingCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.query().setBAR_Equal...
     *     }
     * });
     * </pre>
     * @param orQuery The query for or-condition. (NotNull)
     */
    public void orScopeQuery(final OrQuery<LabelTypeToRoleTypeMappingCB> orQuery) {
        xorSQ((LabelTypeToRoleTypeMappingCB) this, orQuery);
    }

    /**
     * Set up the and-part of or-scope. <br />
     * (However nested or-scope query and as-or-split of like-search in and-part are unsupported)
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or (BAR = '...' and QUX = '...'))</span>
     * cb.<span style="color: #FD4747">orScopeQuery</span>(new OrQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *     public void query(LabelTypeToRoleTypeMappingCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.<span style="color: #FD4747">orScopeQueryAndPart</span>(new AndQuery&lt;LabelTypeToRoleTypeMappingCB&gt;() {
     *             public void query(LabelTypeToRoleTypeMappingCB andCB) {
     *                 andCB.query().setBar_...
     *                 andCB.query().setQux_...
     *             }
     *         });
     *     }
     * });
     * </pre>
     * @param andQuery The query for and-condition. (NotNull)
     */
    public void orScopeQueryAndPart(
            final AndQuery<LabelTypeToRoleTypeMappingCB> andQuery) {
        xorSQAP((LabelTypeToRoleTypeMappingCB) this, andQuery);
    }

    // ===================================================================================
    //                                                                          DisplaySQL
    //                                                                          ==========
    @Override
    protected SqlAnalyzerFactory getSqlAnalyzerFactory() {
        return new ImplementedInvokerAssistant().assistSqlAnalyzerFactory();
    }

    @Override
    protected String getLogDateFormat() {
        return DBFluteConfig.getInstance().getLogDateFormat();
    }

    @Override
    protected String getLogTimestampFormat() {
        return DBFluteConfig.getInstance().getLogTimestampFormat();
    }

    // ===================================================================================
    //                                                                       Meta Handling
    //                                                                       =============
    @Override
    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    //                                                                        Purpose Type
    //                                                                        ============
    @Override
    protected void xprepareSyncQyCall(final ConditionBean mainCB) {
        final LabelTypeToRoleTypeMappingCB cb;
        if (mainCB != null) {
            cb = (LabelTypeToRoleTypeMappingCB) mainCB;
        } else {
            cb = new LabelTypeToRoleTypeMappingCB();
        }
        specify().xsetSyncQyCall(
                new HpSpQyCall<LabelTypeToRoleTypeMappingCQ>() {
                    @Override
                    public boolean has() {
                        return true;
                    }

                    @Override
                    public LabelTypeToRoleTypeMappingCQ qy() {
                        return cb.query();
                    }
                });
    }

    // ===================================================================================
    //                                                                            Internal
    //                                                                            ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() {
        return LabelTypeToRoleTypeMappingCB.class.getName();
    }

    protected String getConditionQueryClassNameInternally() {
        return LabelTypeToRoleTypeMappingCQ.class.getName();
    }

    protected String getSubQueryClassNameInternally() {
        return SubQuery.class.getName();
    }

    protected String getConditionOptionClassNameInternally() {
        return ConditionOption.class.getName();
    }
}
