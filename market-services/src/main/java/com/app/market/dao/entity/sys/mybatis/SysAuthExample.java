package com.app.market.dao.entity.sys.mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysAuthExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public SysAuthExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNull() {
            addCriterion("auth_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(String value) {
            addCriterion("auth_type =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(String value) {
            addCriterion("auth_type <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(String value) {
            addCriterion("auth_type >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_type >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(String value) {
            addCriterion("auth_type <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("auth_type <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLike(String value) {
            addCriterion("auth_type like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotLike(String value) {
            addCriterion("auth_type not like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<String> values) {
            addCriterion("auth_type in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<String> values) {
            addCriterion("auth_type not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(String value1, String value2) {
            addCriterion("auth_type between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(String value1, String value2) {
            addCriterion("auth_type not between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthUrlIsNull() {
            addCriterion("auth_url is null");
            return (Criteria) this;
        }

        public Criteria andAuthUrlIsNotNull() {
            addCriterion("auth_url is not null");
            return (Criteria) this;
        }

        public Criteria andAuthUrlEqualTo(String value) {
            addCriterion("auth_url =", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotEqualTo(String value) {
            addCriterion("auth_url <>", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlGreaterThan(String value) {
            addCriterion("auth_url >", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlGreaterThanOrEqualTo(String value) {
            addCriterion("auth_url >=", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlLessThan(String value) {
            addCriterion("auth_url <", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlLessThanOrEqualTo(String value) {
            addCriterion("auth_url <=", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlLike(String value) {
            addCriterion("auth_url like", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotLike(String value) {
            addCriterion("auth_url not like", value, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlIn(List<String> values) {
            addCriterion("auth_url in", values, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotIn(List<String> values) {
            addCriterion("auth_url not in", values, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlBetween(String value1, String value2) {
            addCriterion("auth_url between", value1, value2, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthUrlNotBetween(String value1, String value2) {
            addCriterion("auth_url not between", value1, value2, "authUrl");
            return (Criteria) this;
        }

        public Criteria andAuthIconIsNull() {
            addCriterion("auth_icon is null");
            return (Criteria) this;
        }

        public Criteria andAuthIconIsNotNull() {
            addCriterion("auth_icon is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIconEqualTo(String value) {
            addCriterion("auth_icon =", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconNotEqualTo(String value) {
            addCriterion("auth_icon <>", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconGreaterThan(String value) {
            addCriterion("auth_icon >", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconGreaterThanOrEqualTo(String value) {
            addCriterion("auth_icon >=", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconLessThan(String value) {
            addCriterion("auth_icon <", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconLessThanOrEqualTo(String value) {
            addCriterion("auth_icon <=", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconLike(String value) {
            addCriterion("auth_icon like", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconNotLike(String value) {
            addCriterion("auth_icon not like", value, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconIn(List<String> values) {
            addCriterion("auth_icon in", values, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconNotIn(List<String> values) {
            addCriterion("auth_icon not in", values, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconBetween(String value1, String value2) {
            addCriterion("auth_icon between", value1, value2, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthIconNotBetween(String value1, String value2) {
            addCriterion("auth_icon not between", value1, value2, "authIcon");
            return (Criteria) this;
        }

        public Criteria andAuthValueIsNull() {
            addCriterion("auth_value is null");
            return (Criteria) this;
        }

        public Criteria andAuthValueIsNotNull() {
            addCriterion("auth_value is not null");
            return (Criteria) this;
        }

        public Criteria andAuthValueEqualTo(String value) {
            addCriterion("auth_value =", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueNotEqualTo(String value) {
            addCriterion("auth_value <>", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueGreaterThan(String value) {
            addCriterion("auth_value >", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueGreaterThanOrEqualTo(String value) {
            addCriterion("auth_value >=", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueLessThan(String value) {
            addCriterion("auth_value <", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueLessThanOrEqualTo(String value) {
            addCriterion("auth_value <=", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueLike(String value) {
            addCriterion("auth_value like", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueNotLike(String value) {
            addCriterion("auth_value not like", value, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueIn(List<String> values) {
            addCriterion("auth_value in", values, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueNotIn(List<String> values) {
            addCriterion("auth_value not in", values, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueBetween(String value1, String value2) {
            addCriterion("auth_value between", value1, value2, "authValue");
            return (Criteria) this;
        }

        public Criteria andAuthValueNotBetween(String value1, String value2) {
            addCriterion("auth_value not between", value1, value2, "authValue");
            return (Criteria) this;
        }

        public Criteria andMgTypeIsNull() {
            addCriterion("mg_type is null");
            return (Criteria) this;
        }

        public Criteria andMgTypeIsNotNull() {
            addCriterion("mg_type is not null");
            return (Criteria) this;
        }

        public Criteria andMgTypeEqualTo(String value) {
            addCriterion("mg_type =", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeNotEqualTo(String value) {
            addCriterion("mg_type <>", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeGreaterThan(String value) {
            addCriterion("mg_type >", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mg_type >=", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeLessThan(String value) {
            addCriterion("mg_type <", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeLessThanOrEqualTo(String value) {
            addCriterion("mg_type <=", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeLike(String value) {
            addCriterion("mg_type like", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeNotLike(String value) {
            addCriterion("mg_type not like", value, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeIn(List<String> values) {
            addCriterion("mg_type in", values, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeNotIn(List<String> values) {
            addCriterion("mg_type not in", values, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeBetween(String value1, String value2) {
            addCriterion("mg_type between", value1, value2, "mgType");
            return (Criteria) this;
        }

        public Criteria andMgTypeNotBetween(String value1, String value2) {
            addCriterion("mg_type not between", value1, value2, "mgType");
            return (Criteria) this;
        }

        public Criteria andIsInitIsNull() {
            addCriterion("is_init is null");
            return (Criteria) this;
        }

        public Criteria andIsInitIsNotNull() {
            addCriterion("is_init is not null");
            return (Criteria) this;
        }

        public Criteria andIsInitEqualTo(String value) {
            addCriterion("is_init =", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotEqualTo(String value) {
            addCriterion("is_init <>", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitGreaterThan(String value) {
            addCriterion("is_init >", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitGreaterThanOrEqualTo(String value) {
            addCriterion("is_init >=", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitLessThan(String value) {
            addCriterion("is_init <", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitLessThanOrEqualTo(String value) {
            addCriterion("is_init <=", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitLike(String value) {
            addCriterion("is_init like", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotLike(String value) {
            addCriterion("is_init not like", value, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitIn(List<String> values) {
            addCriterion("is_init in", values, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotIn(List<String> values) {
            addCriterion("is_init not in", values, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitBetween(String value1, String value2) {
            addCriterion("is_init between", value1, value2, "isInit");
            return (Criteria) this;
        }

        public Criteria andIsInitNotBetween(String value1, String value2) {
            addCriterion("is_init not between", value1, value2, "isInit");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCTime("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCTime("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCTime("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCTime("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCTime("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCTime("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_auth
     *
     * @mbggenerated do_not_delete_during_merge Tue Feb 21 11:50:44 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_auth
     *
     * @mbggenerated Tue Feb 21 11:50:44 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}