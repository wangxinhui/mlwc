package com.mlwc.upms.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MlwcUserPersissionExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public MlwcUserPersissionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andUserPersissionIdIsNull() {
            addCriterion("user_persission_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdIsNotNull() {
            addCriterion("user_persission_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdEqualTo(Integer value) {
            addCriterion("user_persission_id =", value, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdNotEqualTo(Integer value) {
            addCriterion("user_persission_id <>", value, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdGreaterThan(Integer value) {
            addCriterion("user_persission_id >", value, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_persission_id >=", value, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdLessThan(Integer value) {
            addCriterion("user_persission_id <", value, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_persission_id <=", value, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdIn(List<Integer> values) {
            addCriterion("user_persission_id in", values, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdNotIn(List<Integer> values) {
            addCriterion("user_persission_id not in", values, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdBetween(Integer value1, Integer value2) {
            addCriterion("user_persission_id between", value1, value2, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserPersissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_persission_id not between", value1, value2, "userPersissionId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdIsNull() {
            addCriterion("permisision_id is null");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdIsNotNull() {
            addCriterion("permisision_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdEqualTo(Integer value) {
            addCriterion("permisision_id =", value, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdNotEqualTo(Integer value) {
            addCriterion("permisision_id <>", value, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdGreaterThan(Integer value) {
            addCriterion("permisision_id >", value, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("permisision_id >=", value, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdLessThan(Integer value) {
            addCriterion("permisision_id <", value, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdLessThanOrEqualTo(Integer value) {
            addCriterion("permisision_id <=", value, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdIn(List<Integer> values) {
            addCriterion("permisision_id in", values, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdNotIn(List<Integer> values) {
            addCriterion("permisision_id not in", values, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdBetween(Integer value1, Integer value2) {
            addCriterion("permisision_id between", value1, value2, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andPermisisionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("permisision_id not between", value1, value2, "permisisionId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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