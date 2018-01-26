package com.mindnode.immipal.pojo;

import java.util.ArrayList;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CategoryExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategorytitleIsNull() {
            addCriterion("categoryTitle is null");
            return (Criteria) this;
        }

        public Criteria andCategorytitleIsNotNull() {
            addCriterion("categoryTitle is not null");
            return (Criteria) this;
        }

        public Criteria andCategorytitleEqualTo(String value) {
            addCriterion("categoryTitle =", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleNotEqualTo(String value) {
            addCriterion("categoryTitle <>", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleGreaterThan(String value) {
            addCriterion("categoryTitle >", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleGreaterThanOrEqualTo(String value) {
            addCriterion("categoryTitle >=", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleLessThan(String value) {
            addCriterion("categoryTitle <", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleLessThanOrEqualTo(String value) {
            addCriterion("categoryTitle <=", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleLike(String value) {
            addCriterion("categoryTitle like", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleNotLike(String value) {
            addCriterion("categoryTitle not like", value, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleIn(List<String> values) {
            addCriterion("categoryTitle in", values, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleNotIn(List<String> values) {
            addCriterion("categoryTitle not in", values, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleBetween(String value1, String value2) {
            addCriterion("categoryTitle between", value1, value2, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategorytitleNotBetween(String value1, String value2) {
            addCriterion("categoryTitle not between", value1, value2, "categorytitle");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelIsNull() {
            addCriterion("category_level is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelIsNotNull() {
            addCriterion("category_level is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelEqualTo(Integer value) {
            addCriterion("category_level =", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelNotEqualTo(Integer value) {
            addCriterion("category_level <>", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelGreaterThan(Integer value) {
            addCriterion("category_level >", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_level >=", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelLessThan(Integer value) {
            addCriterion("category_level <", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelLessThanOrEqualTo(Integer value) {
            addCriterion("category_level <=", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelIn(List<Integer> values) {
            addCriterion("category_level in", values, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelNotIn(List<Integer> values) {
            addCriterion("category_level not in", values, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelBetween(Integer value1, Integer value2) {
            addCriterion("category_level between", value1, value2, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("category_level not between", value1, value2, "categoryLevel");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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