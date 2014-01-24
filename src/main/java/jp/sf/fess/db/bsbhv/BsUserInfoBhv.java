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

package jp.sf.fess.db.bsbhv;

import java.util.List;

import jp.sf.fess.db.bsentity.dbmeta.UserInfoDbm;
import jp.sf.fess.db.cbean.FavoriteLogCB;
import jp.sf.fess.db.cbean.SearchLogCB;
import jp.sf.fess.db.cbean.UserInfoCB;
import jp.sf.fess.db.exbhv.FavoriteLogBhv;
import jp.sf.fess.db.exbhv.SearchLogBhv;
import jp.sf.fess.db.exbhv.UserInfoBhv;
import jp.sf.fess.db.exentity.FavoriteLog;
import jp.sf.fess.db.exentity.SearchLog;
import jp.sf.fess.db.exentity.UserInfo;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.AbstractBehaviorWritable;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.DeleteOption;
import org.seasar.dbflute.bhv.InsertOption;
import org.seasar.dbflute.bhv.LoadReferrerOption;
import org.seasar.dbflute.bhv.QueryInsertSetupper;
import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.OutsideSqlBasicExecutor;

/**
 * The behavior of USER_INFO as TABLE. <br />
 * <pre>
 * [primary key]
 *     ID
 * 
 * [column]
 *     ID, CODE, CREATED_TIME, UPDATED_TIME
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
 *     
 * 
 * [referrer table]
 *     FAVORITE_LOG, SEARCH_LOG
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     favoriteLogList, searchLogList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsUserInfoBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    @Override
    public String getTableDbName() {
        return "USER_INFO";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    @Override
    public DBMeta getDBMeta() {
        return UserInfoDbm.getInstance();
    }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public UserInfoDbm getMyDBMeta() {
        return UserInfoDbm.getInstance();
    }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    @Override
    public Entity newEntity() {
        return newMyEntity();
    }

    /** {@inheritDoc} */
    @Override
    public ConditionBean newConditionBean() {
        return newMyConditionBean();
    }

    /** @return The instance of new entity as my table type. (NotNull) */
    public UserInfo newMyEntity() {
        return new UserInfo();
    }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public UserInfoCB newMyConditionBean() {
        return new UserInfoCB();
    }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * int count = userInfoBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(final UserInfoCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(final UserInfoCB cb) { // called by selectCount(cb) 
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(final UserInfoCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(final ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * UserInfo userInfo = userInfoBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (userInfo != null) {
     *     ... = userInfo.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public UserInfo selectEntity(final UserInfoCB cb) {
        return doSelectEntity(cb, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> ENTITY doSelectEntity(
            final UserInfoCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType,
                new InternalSelectEntityCallback<ENTITY, UserInfoCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(final UserInfoCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected Entity doReadEntity(final ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * UserInfo userInfo = userInfoBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = userInfo.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public UserInfo selectEntityWithDeletedCheck(final UserInfoCB cb) {
        return doSelectEntityWithDeletedCheck(cb, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> ENTITY doSelectEntityWithDeletedCheck(
            final UserInfoCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(
                cb,
                entityType,
                new InternalSelectEntityWithDeletedCheckCallback<ENTITY, UserInfoCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(final UserInfoCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(final ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param id The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public UserInfo selectByPKValue(final Long id) {
        return doSelectByPKValue(id, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> ENTITY doSelectByPKValue(final Long id,
            final Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(id), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param id The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public UserInfo selectByPKValueWithDeletedCheck(final Long id) {
        return doSelectByPKValueWithDeletedCheck(id, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> ENTITY doSelectByPKValueWithDeletedCheck(
            final Long id, final Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(id), entityType);
    }

    private UserInfoCB buildPKCB(final Long id) {
        assertObjectNotNull("id", id);
        final UserInfoCB cb = newMyConditionBean();
        cb.query().setId_Equal(id);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;UserInfo&gt; userInfoList = userInfoBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (UserInfo userInfo : userInfoList) {
     *     ... = userInfo.get...();
     * }
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<UserInfo> selectList(final UserInfoCB cb) {
        return doSelectList(cb, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> ListResultBean<ENTITY> doSelectList(
            final UserInfoCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType,
                new InternalSelectListCallback<ENTITY, UserInfoCB>() {
                    @Override
                    public List<ENTITY> callbackSelectList(final UserInfoCB cb,
                            final Class<ENTITY> entityType) {
                        return delegateSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(final ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;UserInfo&gt; page = userInfoBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (UserInfo userInfo : page) {
     *     ... = userInfo.get...();
     * }
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<UserInfo> selectPage(final UserInfoCB cb) {
        return doSelectPage(cb, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> PagingResultBean<ENTITY> doSelectPage(
            final UserInfoCB cb, final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType,
                new InternalSelectPageCallback<ENTITY, UserInfoCB>() {
                    @Override
                    public int callbackSelectCount(final UserInfoCB cb) {
                        return doSelectCountPlainly(cb);
                    }

                    @Override
                    public List<ENTITY> callbackSelectList(final UserInfoCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(
            final ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * userInfoBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;UserInfo&gt;() {
     *     public void handle(UserInfo entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @param entityRowHandler The handler of entity row of UserInfo. (NotNull)
     */
    public void selectCursor(final UserInfoCB cb,
            final EntityRowHandler<UserInfo> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, UserInfo.class);
    }

    protected <ENTITY extends UserInfo> void doSelectCursor(
            final UserInfoCB cb,
            final EntityRowHandler<ENTITY> entityRowHandler,
            final Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        assertObjectNotNull("entityRowHandler<UserInfo>", entityRowHandler);
        assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType,
                new InternalSelectCursorCallback<ENTITY, UserInfoCB>() {
                    @Override
                    public void callbackSelectCursor(final UserInfoCB cb,
                            final EntityRowHandler<ENTITY> entityRowHandler,
                            final Class<ENTITY> entityType) {
                        delegateSelectCursor(cb, entityRowHandler, entityType);
                    }

                    @Override
                    public List<ENTITY> callbackSelectList(final UserInfoCB cb,
                            final Class<ENTITY> entityType) {
                        return doSelectList(cb, entityType);
                    }
                });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * userInfoBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(UserInfoCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<UserInfoCB, RESULT> scalarSelect(
            final Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends UserInfoCB> SLFunction<CB, RESULT> doScalarSelect(
            final Class<RESULT> resultType, final CB cb) {
        assertObjectNotNull("resultType", resultType);
        assertCBStateValid(cb);
        cb.xsetupForScalarSelect();
        cb.getSqlClause().disableSelectIndex(); // for when you use union
        return new SLFunction<CB, RESULT>(cb, resultType);
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        final String msg = "This table is NOT related to sequence: "
                + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param userInfo The entity of userInfo. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadFavoriteLogList(final UserInfo userInfo,
            final ConditionBeanSetupper<FavoriteLogCB> conditionBeanSetupper) {
        xassLRArg(userInfo, conditionBeanSetupper);
        loadFavoriteLogList(xnewLRLs(userInfo), conditionBeanSetupper);
    }

    /**
     * Load referrer of favoriteLogList with the set-upper for condition-bean of referrer. <br />
     * FAVORITE_LOG by USER_ID, named 'favoriteLogList'.
     * <pre>
     * userInfoBhv.<span style="color: #FD4747">loadFavoriteLogList</span>(userInfoList, new ConditionBeanSetupper&lt;FavoriteLogCB&gt;() {
     *     public void setup(FavoriteLogCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (UserInfo userInfo : userInfoList) {
     *     ... = userInfo.<span style="color: #FD4747">getFavoriteLogList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setUserId_InScope(pkList);
     * cb.query().addOrderBy_UserId_Asc();
     * </pre>
     * @param userInfoList The entity list of userInfo. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadFavoriteLogList(final List<UserInfo> userInfoList,
            final ConditionBeanSetupper<FavoriteLogCB> conditionBeanSetupper) {
        xassLRArg(userInfoList, conditionBeanSetupper);
        loadFavoriteLogList(userInfoList,
                new LoadReferrerOption<FavoriteLogCB, FavoriteLog>()
                        .xinit(conditionBeanSetupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param userInfo The entity of userInfo. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadFavoriteLogList(
            final UserInfo userInfo,
            final LoadReferrerOption<FavoriteLogCB, FavoriteLog> loadReferrerOption) {
        xassLRArg(userInfo, loadReferrerOption);
        loadFavoriteLogList(xnewLRLs(userInfo), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param userInfoList The entity list of userInfo. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadFavoriteLogList(
            final List<UserInfo> userInfoList,
            final LoadReferrerOption<FavoriteLogCB, FavoriteLog> loadReferrerOption) {
        xassLRArg(userInfoList, loadReferrerOption);
        if (userInfoList.isEmpty()) {
            return;
        }
        final FavoriteLogBhv referrerBhv = xgetBSFLR().select(
                FavoriteLogBhv.class);
        helpLoadReferrerInternally(
                userInfoList,
                loadReferrerOption,
                new InternalLoadReferrerCallback<UserInfo, Long, FavoriteLogCB, FavoriteLog>() {
                    @Override
                    public Long getPKVal(final UserInfo e) {
                        return e.getId();
                    }

                    @Override
                    public void setRfLs(final UserInfo e,
                            final List<FavoriteLog> ls) {
                        e.setFavoriteLogList(ls);
                    }

                    @Override
                    public FavoriteLogCB newMyCB() {
                        return referrerBhv.newMyConditionBean();
                    }

                    @Override
                    public void qyFKIn(final FavoriteLogCB cb,
                            final List<Long> ls) {
                        cb.query().setUserId_InScope(ls);
                    }

                    @Override
                    public void qyOdFKAsc(final FavoriteLogCB cb) {
                        cb.query().addOrderBy_UserId_Asc();
                    }

                    @Override
                    public void spFKCol(final FavoriteLogCB cb) {
                        cb.specify().columnUserId();
                    }

                    @Override
                    public List<FavoriteLog> selRfLs(final FavoriteLogCB cb) {
                        return referrerBhv.selectList(cb);
                    }

                    @Override
                    public Long getFKVal(final FavoriteLog e) {
                        return e.getUserId();
                    }

                    @Override
                    public void setlcEt(final FavoriteLog re, final UserInfo le) {
                        re.setUserInfo(le);
                    }

                    @Override
                    public String getRfPrNm() {
                        return "favoriteLogList";
                    }
                });
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param userInfo The entity of userInfo. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadSearchLogList(final UserInfo userInfo,
            final ConditionBeanSetupper<SearchLogCB> conditionBeanSetupper) {
        xassLRArg(userInfo, conditionBeanSetupper);
        loadSearchLogList(xnewLRLs(userInfo), conditionBeanSetupper);
    }

    /**
     * Load referrer of searchLogList with the set-upper for condition-bean of referrer. <br />
     * SEARCH_LOG by USER_ID, named 'searchLogList'.
     * <pre>
     * userInfoBhv.<span style="color: #FD4747">loadSearchLogList</span>(userInfoList, new ConditionBeanSetupper&lt;SearchLogCB&gt;() {
     *     public void setup(SearchLogCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (UserInfo userInfo : userInfoList) {
     *     ... = userInfo.<span style="color: #FD4747">getSearchLogList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setUserId_InScope(pkList);
     * cb.query().addOrderBy_UserId_Asc();
     * </pre>
     * @param userInfoList The entity list of userInfo. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadSearchLogList(final List<UserInfo> userInfoList,
            final ConditionBeanSetupper<SearchLogCB> conditionBeanSetupper) {
        xassLRArg(userInfoList, conditionBeanSetupper);
        loadSearchLogList(userInfoList,
                new LoadReferrerOption<SearchLogCB, SearchLog>()
                        .xinit(conditionBeanSetupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param userInfo The entity of userInfo. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadSearchLogList(final UserInfo userInfo,
            final LoadReferrerOption<SearchLogCB, SearchLog> loadReferrerOption) {
        xassLRArg(userInfo, loadReferrerOption);
        loadSearchLogList(xnewLRLs(userInfo), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param userInfoList The entity list of userInfo. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadSearchLogList(final List<UserInfo> userInfoList,
            final LoadReferrerOption<SearchLogCB, SearchLog> loadReferrerOption) {
        xassLRArg(userInfoList, loadReferrerOption);
        if (userInfoList.isEmpty()) {
            return;
        }
        final SearchLogBhv referrerBhv = xgetBSFLR().select(SearchLogBhv.class);
        helpLoadReferrerInternally(
                userInfoList,
                loadReferrerOption,
                new InternalLoadReferrerCallback<UserInfo, Long, SearchLogCB, SearchLog>() {
                    @Override
                    public Long getPKVal(final UserInfo e) {
                        return e.getId();
                    }

                    @Override
                    public void setRfLs(final UserInfo e,
                            final List<SearchLog> ls) {
                        e.setSearchLogList(ls);
                    }

                    @Override
                    public SearchLogCB newMyCB() {
                        return referrerBhv.newMyConditionBean();
                    }

                    @Override
                    public void qyFKIn(final SearchLogCB cb, final List<Long> ls) {
                        cb.query().setUserId_InScope(ls);
                    }

                    @Override
                    public void qyOdFKAsc(final SearchLogCB cb) {
                        cb.query().addOrderBy_UserId_Asc();
                    }

                    @Override
                    public void spFKCol(final SearchLogCB cb) {
                        cb.specify().columnUserId();
                    }

                    @Override
                    public List<SearchLog> selRfLs(final SearchLogCB cb) {
                        return referrerBhv.selectList(cb);
                    }

                    @Override
                    public Long getFKVal(final SearchLog e) {
                        return e.getUserId();
                    }

                    @Override
                    public void setlcEt(final SearchLog re, final UserInfo le) {
                        re.setUserInfo(le);
                    }

                    @Override
                    public String getRfPrNm() {
                        return "searchLogList";
                    }
                });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key id.
     * @param userInfoList The list of userInfo. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractIdList(final List<UserInfo> userInfoList) {
        return helpExtractListInternally(userInfoList,
                new InternalExtractCallback<UserInfo, Long>() {
                    @Override
                    public Long getCV(final UserInfo e) {
                        return e.getId();
                    }
                });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity. (DefaultConstraintsEnabled)
     * <pre>
     * UserInfo userInfo = new UserInfo();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * userInfo.setFoo...(value);
     * userInfo.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//userInfo.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//userInfo.set...;</span>
     * userInfoBhv.<span style="color: #FD4747">insert</span>(userInfo);
     * ... = userInfo.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param userInfo The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(final UserInfo userInfo) {
        doInsert(userInfo, null);
    }

    protected void doInsert(final UserInfo userInfo,
            final InsertOption<UserInfoCB> option) {
        assertObjectNotNull("userInfo", userInfo);
        prepareInsertOption(option);
        delegateInsert(userInfo, option);
    }

    protected void prepareInsertOption(final InsertOption<UserInfoCB> option) {
        if (option == null) {
            return;
        }
        assertInsertOptionStatus(option);
    }

    @Override
    protected void doCreate(final Entity entity,
            final InsertOption<? extends ConditionBean> option) {
        if (option == null) {
            insert(downcast(entity));
        } else {
            varyingInsert(downcast(entity), downcast(option));
        }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * UserInfo userInfo = new UserInfo();
     * userInfo.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * userInfo.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//userInfo.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//userInfo.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * userInfo.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     userInfoBhv.<span style="color: #FD4747">update</span>(userInfo);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param userInfo The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final UserInfo userInfo) {
        doUpdate(userInfo, null);
    }

    protected void doUpdate(final UserInfo userInfo,
            final UpdateOption<UserInfoCB> option) {
        assertObjectNotNull("userInfo", userInfo);
        prepareUpdateOption(option);
        helpUpdateInternally(userInfo, new InternalUpdateCallback<UserInfo>() {
            @Override
            public int callbackDelegateUpdate(final UserInfo entity) {
                return delegateUpdate(entity, option);
            }
        });
    }

    protected void prepareUpdateOption(final UpdateOption<UserInfoCB> option) {
        if (option == null) {
            return;
        }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected UserInfoCB createCBForVaryingUpdate() {
        final UserInfoCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected UserInfoCB createCBForSpecifiedUpdate() {
        final UserInfoCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(final Entity entity,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            update(downcast(entity));
        } else {
            varyingUpdate(downcast(entity), downcast(option));
        }
    }

    @Override
    protected void doModifyNonstrict(final Entity entity,
            final UpdateOption<? extends ConditionBean> option) {
        doModify(entity, option);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param userInfo The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(final UserInfo userInfo) {
        doInesrtOrUpdate(userInfo, null, null);
    }

    protected void doInesrtOrUpdate(final UserInfo userInfo,
            final InsertOption<UserInfoCB> insertOption,
            final UpdateOption<UserInfoCB> updateOption) {
        helpInsertOrUpdateInternally(userInfo,
                new InternalInsertOrUpdateCallback<UserInfo, UserInfoCB>() {
                    @Override
                    public void callbackInsert(final UserInfo entity) {
                        doInsert(entity, insertOption);
                    }

                    @Override
                    public void callbackUpdate(final UserInfo entity) {
                        doUpdate(entity, updateOption);
                    }

                    @Override
                    public UserInfoCB callbackNewMyConditionBean() {
                        return newMyConditionBean();
                    }

                    @Override
                    public int callbackSelectCount(final UserInfoCB cb) {
                        return selectCount(cb);
                    }
                });
    }

    @Override
    protected void doCreateOrModify(final Entity entity,
            InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) {
            insertOrUpdate(downcast(entity));
        } else {
            insertOption = insertOption == null ? new InsertOption<UserInfoCB>()
                    : insertOption;
            updateOption = updateOption == null ? new UpdateOption<UserInfoCB>()
                    : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption),
                    downcast(updateOption));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(final Entity entity,
            final InsertOption<? extends ConditionBean> insertOption,
            final UpdateOption<? extends ConditionBean> updateOption) {
        doCreateOrModify(entity, insertOption, updateOption);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * UserInfo userInfo = new UserInfo();
     * userInfo.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * userInfo.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     userInfoBhv.<span style="color: #FD4747">delete</span>(userInfo);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param userInfo The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(final UserInfo userInfo) {
        doDelete(userInfo, null);
    }

    protected void doDelete(final UserInfo userInfo,
            final DeleteOption<UserInfoCB> option) {
        assertObjectNotNull("userInfo", userInfo);
        prepareDeleteOption(option);
        helpDeleteInternally(userInfo, new InternalDeleteCallback<UserInfo>() {
            @Override
            public int callbackDelegateDelete(final UserInfo entity) {
                return delegateDelete(entity, option);
            }
        });
    }

    protected void prepareDeleteOption(final DeleteOption<UserInfoCB> option) {
        if (option == null) {
            return;
        }
        assertDeleteOptionStatus(option);
    }

    @Override
    protected void doRemove(final Entity entity,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            delete(downcast(entity));
        } else {
            varyingDelete(downcast(entity), downcast(option));
        }
    }

    @Override
    protected void doRemoveNonstrict(final Entity entity,
            final DeleteOption<? extends ConditionBean> option) {
        doRemove(entity, option);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list. (DefaultConstraintsDisabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <p><span style="color: #FD4747; font-size: 120%">Attention, all columns are insert target. (so default constraints are not available)</span></p>
     * And if the table has an identity, entities after the process don't have incremented values.
     * When you use the (normal) insert(), an entity after the process has an incremented value.
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(final List<UserInfo> userInfoList) {
        return doBatchInsert(userInfoList, null);
    }

    protected int[] doBatchInsert(final List<UserInfo> userInfoList,
            final InsertOption<UserInfoCB> option) {
        assertObjectNotNull("userInfoList", userInfoList);
        prepareInsertOption(option);
        return delegateBatchInsert(userInfoList, option);
    }

    @Override
    protected int[] doLumpCreate(final List<Entity> ls,
            final InsertOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchInsert(downcast(ls));
        } else {
            return varyingBatchInsert(downcast(ls), downcast(option));
        }
    }

    /**
     * Batch-update the entity list. (AllColumnsUpdated, NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">Attention, all columns are update target. {NOT modified only}</span> <br />
     * So you should the other batchUpdate() (overload) method for performace,
     * which you can specify update columns like this:
     * <pre>
     * userInfoBhv.<span style="color: #FD4747">batchUpdate</span>(userInfoList, new SpecifyQuery<UserInfoCB>() {
     *     public void specify(UserInfoCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>;
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>;
     *     }
     * });
     * </pre>
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(final List<UserInfo> userInfoList) {
        return doBatchUpdate(userInfoList, null);
    }

    protected int[] doBatchUpdate(final List<UserInfo> userInfoList,
            final UpdateOption<UserInfoCB> option) {
        assertObjectNotNull("userInfoList", userInfoList);
        prepareBatchUpdateOption(userInfoList, option);
        return delegateBatchUpdate(userInfoList, option);
    }

    protected void prepareBatchUpdateOption(final List<UserInfo> userInfoList,
            final UpdateOption<UserInfoCB> option) {
        if (option == null) {
            return;
        }
        prepareUpdateOption(option);
        // under review
        //if (option.hasSpecifiedUpdateColumn()) {
        //    option.xgatherUpdateColumnModifiedProperties(userInfoList);
        //}
    }

    @Override
    protected int[] doLumpModify(final List<Entity> ls,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchUpdate(downcast(ls));
        } else {
            return varyingBatchUpdate(downcast(ls), downcast(option));
        }
    }

    /**
     * Batch-update the entity list. (SpecifiedColumnsUpdated, NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * userInfoBhv.<span style="color: #FD4747">batchUpdate</span>(userInfoList, new SpecifyQuery<UserInfoCB>() {
     *     public void specify(UserInfoCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * userInfoBhv.<span style="color: #FD4747">batchUpdate</span>(userInfoList, new SpecifyQuery<UserInfoCB>() {
     *     public void specify(UserInfoCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(final List<UserInfo> userInfoList,
            final SpecifyQuery<UserInfoCB> updateColumnSpec) {
        return doBatchUpdate(userInfoList,
                createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(final List<Entity> ls,
            final UpdateOption<? extends ConditionBean> option) {
        return doLumpModify(ls, option);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(final List<UserInfo> userInfoList) {
        return doBatchDelete(userInfoList, null);
    }

    protected int[] doBatchDelete(final List<UserInfo> userInfoList,
            final DeleteOption<UserInfoCB> option) {
        assertObjectNotNull("userInfoList", userInfoList);
        prepareDeleteOption(option);
        return delegateBatchDelete(userInfoList, option);
    }

    @Override
    protected int[] doLumpRemove(final List<Entity> ls,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            return batchDelete(downcast(ls));
        } else {
            return varyingBatchDelete(downcast(ls), downcast(option));
        }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(final List<Entity> ls,
            final DeleteOption<? extends ConditionBean> option) {
        return doLumpRemove(ls, option);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * userInfoBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;UserInfo, UserInfoCB&gt;() {
     *     public ConditionBean setup(userInfo entity, UserInfoCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     * 
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * 
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(
            final QueryInsertSetupper<UserInfo, UserInfoCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(
            final QueryInsertSetupper<UserInfo, UserInfoCB> setupper,
            final InsertOption<UserInfoCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        final UserInfo entity = new UserInfo();
        final UserInfoCB intoCB = createCBForQueryInsert();
        final ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected UserInfoCB createCBForQueryInsert() {
        final UserInfoCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(
            final QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper,
            final InsertOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryInsert(downcast(setupper));
        } else {
            return varyingQueryInsert(downcast(setupper), downcast(option));
        }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * UserInfo userInfo = new UserInfo();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//userInfo.setPK...(value);</span>
     * userInfo.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//userInfo.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//userInfo.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//userInfo.setVersionNo(value);</span>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * userInfoBhv.<span style="color: #FD4747">queryUpdate</span>(userInfo, cb);
     * </pre>
     * @param userInfo The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(final UserInfo userInfo, final UserInfoCB cb) {
        return doQueryUpdate(userInfo, cb, null);
    }

    protected int doQueryUpdate(final UserInfo userInfo, final UserInfoCB cb,
            final UpdateOption<UserInfoCB> option) {
        assertObjectNotNull("userInfo", userInfo);
        assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(
                userInfo, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(final Entity entity, final ConditionBean cb,
            final UpdateOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryUpdate(downcast(entity), (UserInfoCB) cb);
        } else {
            return varyingQueryUpdate(downcast(entity), (UserInfoCB) cb,
                    downcast(option));
        }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * userInfoBhv.<span style="color: #FD4747">queryDelete</span>(userInfo, cb);
     * </pre>
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(final UserInfoCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(final UserInfoCB cb,
            final DeleteOption<UserInfoCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb,
                option) : 0;
    }

    @Override
    protected int doRangeRemove(final ConditionBean cb,
            final DeleteOption<? extends ConditionBean> option) {
        if (option == null) {
            return queryDelete((UserInfoCB) cb);
        } else {
            return varyingQueryDelete((UserInfoCB) cb, downcast(option));
        }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * UserInfo userInfo = new UserInfo();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * userInfo.setFoo...(value);
     * userInfo.setBar...(value);
     * InsertOption<UserInfoCB> option = new InsertOption<UserInfoCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * userInfoBhv.<span style="color: #FD4747">varyingInsert</span>(userInfo, option);
     * ... = userInfo.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param userInfo The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(final UserInfo userInfo,
            final InsertOption<UserInfoCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(userInfo, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * UserInfo userInfo = new UserInfo();
     * userInfo.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * userInfo.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * userInfo.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;UserInfoCB&gt; option = new UpdateOption&lt;UserInfoCB&gt;();
     *     option.self(new SpecifyQuery&lt;UserInfoCB&gt;() {
     *         public void specify(UserInfoCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     userInfoBhv.<span style="color: #FD4747">varyingUpdate</span>(userInfo, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param userInfo The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(final UserInfo userInfo,
            final UpdateOption<UserInfoCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(userInfo, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param userInfo The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(final UserInfo userInfo,
            final InsertOption<UserInfoCB> insertOption,
            final UpdateOption<UserInfoCB> updateOption) {
        assertInsertOptionNotNull(insertOption);
        assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(userInfo, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param userInfo The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(final UserInfo userInfo,
            final DeleteOption<UserInfoCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(userInfo, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(final List<UserInfo> userInfoList,
            final InsertOption<UserInfoCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(userInfoList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(final List<UserInfo> userInfoList,
            final UpdateOption<UserInfoCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(userInfoList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param userInfoList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(final List<UserInfo> userInfoList,
            final DeleteOption<UserInfoCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(userInfoList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper). 
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(
            final QueryInsertSetupper<UserInfo, UserInfoCB> setupper,
            final InsertOption<UserInfoCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb). 
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * UserInfo userInfo = new UserInfo();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//userInfo.setPK...(value);</span>
     * userInfo.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//userInfo.setVersionNo(value);</span>
     * UserInfoCB cb = new UserInfoCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;UserInfoCB&gt; option = new UpdateOption&lt;UserInfoCB&gt;();
     * option.self(new SpecifyQuery&lt;UserInfoCB&gt;() {
     *     public void specify(UserInfoCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * userInfoBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(userInfo, cb, option);
     * </pre>
     * @param userInfo The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(final UserInfo userInfo, final UserInfoCB cb,
            final UpdateOption<UserInfoCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(userInfo, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of UserInfo. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(final UserInfoCB cb,
            final DeleteOption<UserInfoCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     * 
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     * 
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     * 
     * {Cursor}
     *   o cursorHandling().selectCursor()
     * 
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull) 
     */
    public OutsideSqlBasicExecutor<UserInfoBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(final UserInfoCB cb) {
        return invoke(createSelectCountCBCommand(cb, true));
    }

    protected int delegateSelectCountPlainly(final UserInfoCB cb) {
        return invoke(createSelectCountCBCommand(cb, false));
    }

    protected <ENTITY extends UserInfo> void delegateSelectCursor(
            final UserInfoCB cb, final EntityRowHandler<ENTITY> erh,
            final Class<ENTITY> et) {
        invoke(createSelectCursorCBCommand(cb, erh, et));
    }

    protected <ENTITY extends UserInfo> List<ENTITY> delegateSelectList(
            final UserInfoCB cb, final Class<ENTITY> et) {
        return invoke(createSelectListCBCommand(cb, et));
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(final UserInfo e,
            final InsertOption<UserInfoCB> op) {
        if (!processBeforeInsert(e, op)) {
            return 0;
        }
        return invoke(createInsertEntityCommand(e, op));
    }

    protected int delegateUpdate(final UserInfo e,
            final UpdateOption<UserInfoCB> op) {
        if (!processBeforeUpdate(e, op)) {
            return 0;
        }
        return delegateUpdateNonstrict(e, op);
    }

    protected int delegateUpdateNonstrict(final UserInfo e,
            final UpdateOption<UserInfoCB> op) {
        if (!processBeforeUpdate(e, op)) {
            return 0;
        }
        return invoke(createUpdateNonstrictEntityCommand(e, op));
    }

    protected int delegateDelete(final UserInfo e,
            final DeleteOption<UserInfoCB> op) {
        if (!processBeforeDelete(e, op)) {
            return 0;
        }
        return delegateDeleteNonstrict(e, op);
    }

    protected int delegateDeleteNonstrict(final UserInfo e,
            final DeleteOption<UserInfoCB> op) {
        if (!processBeforeDelete(e, op)) {
            return 0;
        }
        return invoke(createDeleteNonstrictEntityCommand(e, op));
    }

    protected int[] delegateBatchInsert(final List<UserInfo> ls,
            final InsertOption<UserInfoCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchInsertCommand(processBatchInternally(ls, op),
                op));
    }

    protected int[] delegateBatchUpdate(final List<UserInfo> ls,
            final UpdateOption<UserInfoCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return delegateBatchUpdateNonstrict(ls, op);
    }

    protected int[] delegateBatchUpdateNonstrict(final List<UserInfo> ls,
            final UpdateOption<UserInfoCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchUpdateNonstrictCommand(
                processBatchInternally(ls, op, true), op));
    }

    protected int[] delegateBatchDelete(final List<UserInfo> ls,
            final DeleteOption<UserInfoCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return delegateBatchDeleteNonstrict(ls, op);
    }

    protected int[] delegateBatchDeleteNonstrict(final List<UserInfo> ls,
            final DeleteOption<UserInfoCB> op) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchDeleteNonstrictCommand(
                processBatchInternally(ls, op, true), op));
    }

    protected int delegateQueryInsert(final UserInfo e, final UserInfoCB inCB,
            final ConditionBean resCB, final InsertOption<UserInfoCB> op) {
        if (!processBeforeQueryInsert(e, inCB, resCB, op)) {
            return 0;
        }
        return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));
    }

    protected int delegateQueryUpdate(final UserInfo e, final UserInfoCB cb,
            final UpdateOption<UserInfoCB> op) {
        if (!processBeforeQueryUpdate(e, cb, op)) {
            return 0;
        }
        return invoke(createQueryUpdateCBCommand(e, cb, op));
    }

    protected int delegateQueryDelete(final UserInfoCB cb,
            final DeleteOption<UserInfoCB> op) {
        if (!processBeforeQueryDelete(cb, op)) {
            return 0;
        }
        return invoke(createQueryDeleteCBCommand(cb, op));
    }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(final Entity entity) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(final Entity entity) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected UserInfo downcast(final Entity entity) {
        return helpEntityDowncastInternally(entity, UserInfo.class);
    }

    protected UserInfoCB downcast(final ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, UserInfoCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<UserInfo> downcast(final List<? extends Entity> entityList) {
        return (List<UserInfo>) entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<UserInfoCB> downcast(
            final InsertOption<? extends ConditionBean> option) {
        return (InsertOption<UserInfoCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<UserInfoCB> downcast(
            final UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<UserInfoCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<UserInfoCB> downcast(
            final DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<UserInfoCB>) option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<UserInfo, UserInfoCB> downcast(
            final QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<UserInfo, UserInfoCB>) option;
    }
}
