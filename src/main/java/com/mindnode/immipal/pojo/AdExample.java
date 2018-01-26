package com.mindnode.immipal.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public AdExample() {
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

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(Integer value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(Integer value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(Integer value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(Integer value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<Integer> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<Integer> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(Integer value1, Integer value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdTitleIsNull() {
            addCriterion("ad_title is null");
            return (Criteria) this;
        }

        public Criteria andAdTitleIsNotNull() {
            addCriterion("ad_title is not null");
            return (Criteria) this;
        }

        public Criteria andAdTitleEqualTo(String value) {
            addCriterion("ad_title =", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotEqualTo(String value) {
            addCriterion("ad_title <>", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleGreaterThan(String value) {
            addCriterion("ad_title >", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ad_title >=", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleLessThan(String value) {
            addCriterion("ad_title <", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleLessThanOrEqualTo(String value) {
            addCriterion("ad_title <=", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleLike(String value) {
            addCriterion("ad_title like", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotLike(String value) {
            addCriterion("ad_title not like", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleIn(List<String> values) {
            addCriterion("ad_title in", values, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotIn(List<String> values) {
            addCriterion("ad_title not in", values, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleBetween(String value1, String value2) {
            addCriterion("ad_title between", value1, value2, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotBetween(String value1, String value2) {
            addCriterion("ad_title not between", value1, value2, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeIsNull() {
            addCriterion("ad_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeIsNotNull() {
            addCriterion("ad_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeEqualTo(Long value) {
            addCriterion("ad_create_time =", value, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeNotEqualTo(Long value) {
            addCriterion("ad_create_time <>", value, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeGreaterThan(Long value) {
            addCriterion("ad_create_time >", value, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ad_create_time >=", value, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeLessThan(Long value) {
            addCriterion("ad_create_time <", value, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("ad_create_time <=", value, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeIn(List<Long> values) {
            addCriterion("ad_create_time in", values, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeNotIn(List<Long> values) {
            addCriterion("ad_create_time not in", values, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeBetween(Long value1, Long value2) {
            addCriterion("ad_create_time between", value1, value2, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("ad_create_time not between", value1, value2, "adCreateTime");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlIsNull() {
            addCriterion("ad_img_url is null");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlIsNotNull() {
            addCriterion("ad_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlEqualTo(String value) {
            addCriterion("ad_img_url =", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlNotEqualTo(String value) {
            addCriterion("ad_img_url <>", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlGreaterThan(String value) {
            addCriterion("ad_img_url >", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_url >=", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlLessThan(String value) {
            addCriterion("ad_img_url <", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlLessThanOrEqualTo(String value) {
            addCriterion("ad_img_url <=", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlLike(String value) {
            addCriterion("ad_img_url like", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlNotLike(String value) {
            addCriterion("ad_img_url not like", value, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlIn(List<String> values) {
            addCriterion("ad_img_url in", values, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlNotIn(List<String> values) {
            addCriterion("ad_img_url not in", values, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlBetween(String value1, String value2) {
            addCriterion("ad_img_url between", value1, value2, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdImgUrlNotBetween(String value1, String value2) {
            addCriterion("ad_img_url not between", value1, value2, "adImgUrl");
            return (Criteria) this;
        }

        public Criteria andAdLinkIsNull() {
            addCriterion("ad_link is null");
            return (Criteria) this;
        }

        public Criteria andAdLinkIsNotNull() {
            addCriterion("ad_link is not null");
            return (Criteria) this;
        }

        public Criteria andAdLinkEqualTo(String value) {
            addCriterion("ad_link =", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotEqualTo(String value) {
            addCriterion("ad_link <>", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkGreaterThan(String value) {
            addCriterion("ad_link >", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkGreaterThanOrEqualTo(String value) {
            addCriterion("ad_link >=", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkLessThan(String value) {
            addCriterion("ad_link <", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkLessThanOrEqualTo(String value) {
            addCriterion("ad_link <=", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkLike(String value) {
            addCriterion("ad_link like", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotLike(String value) {
            addCriterion("ad_link not like", value, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkIn(List<String> values) {
            addCriterion("ad_link in", values, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotIn(List<String> values) {
            addCriterion("ad_link not in", values, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkBetween(String value1, String value2) {
            addCriterion("ad_link between", value1, value2, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLinkNotBetween(String value1, String value2) {
            addCriterion("ad_link not between", value1, value2, "adLink");
            return (Criteria) this;
        }

        public Criteria andAdLevelIsNull() {
            addCriterion("ad_level is null");
            return (Criteria) this;
        }

        public Criteria andAdLevelIsNotNull() {
            addCriterion("ad_level is not null");
            return (Criteria) this;
        }

        public Criteria andAdLevelEqualTo(Integer value) {
            addCriterion("ad_level =", value, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelNotEqualTo(Integer value) {
            addCriterion("ad_level <>", value, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelGreaterThan(Integer value) {
            addCriterion("ad_level >", value, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_level >=", value, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelLessThan(Integer value) {
            addCriterion("ad_level <", value, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelLessThanOrEqualTo(Integer value) {
            addCriterion("ad_level <=", value, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelIn(List<Integer> values) {
            addCriterion("ad_level in", values, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelNotIn(List<Integer> values) {
            addCriterion("ad_level not in", values, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelBetween(Integer value1, Integer value2) {
            addCriterion("ad_level between", value1, value2, "adLevel");
            return (Criteria) this;
        }

        public Criteria andAdLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_level not between", value1, value2, "adLevel");
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