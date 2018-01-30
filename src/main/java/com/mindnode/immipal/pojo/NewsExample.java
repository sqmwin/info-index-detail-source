package com.mindnode.immipal.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public NewsExample() {
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

        public Criteria andNewsIdIsNull() {
            addCriterion("news_id is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("news_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(Integer value) {
            addCriterion("news_id =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(Integer value) {
            addCriterion("news_id <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(Integer value) {
            addCriterion("news_id >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_id >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(Integer value) {
            addCriterion("news_id <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(Integer value) {
            addCriterion("news_id <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<Integer> values) {
            addCriterion("news_id in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<Integer> values) {
            addCriterion("news_id not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(Integer value1, Integer value2) {
            addCriterion("news_id between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("news_id not between", value1, value2, "newsId");
            return (Criteria) this;
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

        public Criteria andNewsTitleIsNull() {
            addCriterion("news_title is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("news_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("news_title =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("news_title <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("news_title >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("news_title >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("news_title <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("news_title <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("news_title like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("news_title not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("news_title in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("news_title not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("news_title between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("news_title not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNull() {
            addCriterion("news_author is null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNotNull() {
            addCriterion("news_author is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorEqualTo(String value) {
            addCriterion("news_author =", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotEqualTo(String value) {
            addCriterion("news_author <>", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThan(String value) {
            addCriterion("news_author >", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("news_author >=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThan(String value) {
            addCriterion("news_author <", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThanOrEqualTo(String value) {
            addCriterion("news_author <=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLike(String value) {
            addCriterion("news_author like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotLike(String value) {
            addCriterion("news_author not like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIn(List<String> values) {
            addCriterion("news_author in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotIn(List<String> values) {
            addCriterion("news_author not in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorBetween(String value1, String value2) {
            addCriterion("news_author between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotBetween(String value1, String value2) {
            addCriterion("news_author not between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorIsNull() {
            addCriterion("news_translator is null");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorIsNotNull() {
            addCriterion("news_translator is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorEqualTo(String value) {
            addCriterion("news_translator =", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorNotEqualTo(String value) {
            addCriterion("news_translator <>", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorGreaterThan(String value) {
            addCriterion("news_translator >", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorGreaterThanOrEqualTo(String value) {
            addCriterion("news_translator >=", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorLessThan(String value) {
            addCriterion("news_translator <", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorLessThanOrEqualTo(String value) {
            addCriterion("news_translator <=", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorLike(String value) {
            addCriterion("news_translator like", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorNotLike(String value) {
            addCriterion("news_translator not like", value, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorIn(List<String> values) {
            addCriterion("news_translator in", values, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorNotIn(List<String> values) {
            addCriterion("news_translator not in", values, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorBetween(String value1, String value2) {
            addCriterion("news_translator between", value1, value2, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsTranslatorNotBetween(String value1, String value2) {
            addCriterion("news_translator not between", value1, value2, "newsTranslator");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeIsNull() {
            addCriterion("news_create_time is null");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeIsNotNull() {
            addCriterion("news_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeEqualTo(Long value) {
            addCriterion("news_create_time =", value, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeNotEqualTo(Long value) {
            addCriterion("news_create_time <>", value, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeGreaterThan(Long value) {
            addCriterion("news_create_time >", value, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("news_create_time >=", value, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeLessThan(Long value) {
            addCriterion("news_create_time <", value, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("news_create_time <=", value, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeIn(List<Long> values) {
            addCriterion("news_create_time in", values, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeNotIn(List<Long> values) {
            addCriterion("news_create_time not in", values, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeBetween(Long value1, Long value2) {
            addCriterion("news_create_time between", value1, value2, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andNewsCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("news_create_time not between", value1, value2, "newsCreateTime");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsIsNull() {
            addCriterion("show_img_urls is null");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsIsNotNull() {
            addCriterion("show_img_urls is not null");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsEqualTo(String value) {
            addCriterion("show_img_urls =", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsNotEqualTo(String value) {
            addCriterion("show_img_urls <>", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsGreaterThan(String value) {
            addCriterion("show_img_urls >", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("show_img_urls >=", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsLessThan(String value) {
            addCriterion("show_img_urls <", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsLessThanOrEqualTo(String value) {
            addCriterion("show_img_urls <=", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsLike(String value) {
            addCriterion("show_img_urls like", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsNotLike(String value) {
            addCriterion("show_img_urls not like", value, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsIn(List<String> values) {
            addCriterion("show_img_urls in", values, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsNotIn(List<String> values) {
            addCriterion("show_img_urls not in", values, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsBetween(String value1, String value2) {
            addCriterion("show_img_urls between", value1, value2, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgUrlsNotBetween(String value1, String value2) {
            addCriterion("show_img_urls not between", value1, value2, "showImgUrls");
            return (Criteria) this;
        }

        public Criteria andShowImgCountIsNull() {
            addCriterion("show_img_count is null");
            return (Criteria) this;
        }

        public Criteria andShowImgCountIsNotNull() {
            addCriterion("show_img_count is not null");
            return (Criteria) this;
        }

        public Criteria andShowImgCountEqualTo(Integer value) {
            addCriterion("show_img_count =", value, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountNotEqualTo(Integer value) {
            addCriterion("show_img_count <>", value, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountGreaterThan(Integer value) {
            addCriterion("show_img_count >", value, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_img_count >=", value, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountLessThan(Integer value) {
            addCriterion("show_img_count <", value, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountLessThanOrEqualTo(Integer value) {
            addCriterion("show_img_count <=", value, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountIn(List<Integer> values) {
            addCriterion("show_img_count in", values, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountNotIn(List<Integer> values) {
            addCriterion("show_img_count not in", values, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountBetween(Integer value1, Integer value2) {
            addCriterion("show_img_count between", value1, value2, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andShowImgCountNotBetween(Integer value1, Integer value2) {
            addCriterion("show_img_count not between", value1, value2, "showImgCount");
            return (Criteria) this;
        }

        public Criteria andNewsTopIsNull() {
            addCriterion("news_top is null");
            return (Criteria) this;
        }

        public Criteria andNewsTopIsNotNull() {
            addCriterion("news_top is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTopEqualTo(Boolean value) {
            addCriterion("news_top =", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotEqualTo(Boolean value) {
            addCriterion("news_top <>", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopGreaterThan(Boolean value) {
            addCriterion("news_top >", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("news_top >=", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopLessThan(Boolean value) {
            addCriterion("news_top <", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopLessThanOrEqualTo(Boolean value) {
            addCriterion("news_top <=", value, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopIn(List<Boolean> values) {
            addCriterion("news_top in", values, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotIn(List<Boolean> values) {
            addCriterion("news_top not in", values, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopBetween(Boolean value1, Boolean value2) {
            addCriterion("news_top between", value1, value2, "newsTop");
            return (Criteria) this;
        }

        public Criteria andNewsTopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("news_top not between", value1, value2, "newsTop");
            return (Criteria) this;
        }

        public Criteria andHasVideoIsNull() {
            addCriterion("has_video is null");
            return (Criteria) this;
        }

        public Criteria andHasVideoIsNotNull() {
            addCriterion("has_video is not null");
            return (Criteria) this;
        }

        public Criteria andHasVideoEqualTo(Boolean value) {
            addCriterion("has_video =", value, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoNotEqualTo(Boolean value) {
            addCriterion("has_video <>", value, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoGreaterThan(Boolean value) {
            addCriterion("has_video >", value, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_video >=", value, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoLessThan(Boolean value) {
            addCriterion("has_video <", value, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoLessThanOrEqualTo(Boolean value) {
            addCriterion("has_video <=", value, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoIn(List<Boolean> values) {
            addCriterion("has_video in", values, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoNotIn(List<Boolean> values) {
            addCriterion("has_video not in", values, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoBetween(Boolean value1, Boolean value2) {
            addCriterion("has_video between", value1, value2, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andHasVideoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_video not between", value1, value2, "hasVideo");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Boolean value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Boolean value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Boolean value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Boolean value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Boolean> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Boolean> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleIsNull() {
            addCriterion("category_title is null");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleIsNotNull() {
            addCriterion("category_title is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleEqualTo(String value) {
            addCriterion("category_title =", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotEqualTo(String value) {
            addCriterion("category_title <>", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleGreaterThan(String value) {
            addCriterion("category_title >", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleGreaterThanOrEqualTo(String value) {
            addCriterion("category_title >=", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleLessThan(String value) {
            addCriterion("category_title <", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleLessThanOrEqualTo(String value) {
            addCriterion("category_title <=", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleLike(String value) {
            addCriterion("category_title like", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotLike(String value) {
            addCriterion("category_title not like", value, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleIn(List<String> values) {
            addCriterion("category_title in", values, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotIn(List<String> values) {
            addCriterion("category_title not in", values, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleBetween(String value1, String value2) {
            addCriterion("category_title between", value1, value2, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryTitleNotBetween(String value1, String value2) {
            addCriterion("category_title not between", value1, value2, "categoryTitle");
            return (Criteria) this;
        }

        public Criteria andNewsDateIsNull() {
            addCriterion("news_date is null");
            return (Criteria) this;
        }

        public Criteria andNewsDateIsNotNull() {
            addCriterion("news_date is not null");
            return (Criteria) this;
        }

        public Criteria andNewsDateEqualTo(Date value) {
            addCriterion("news_date =", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotEqualTo(Date value) {
            addCriterion("news_date <>", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateGreaterThan(Date value) {
            addCriterion("news_date >", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("news_date >=", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateLessThan(Date value) {
            addCriterion("news_date <", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateLessThanOrEqualTo(Date value) {
            addCriterion("news_date <=", value, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateIn(List<Date> values) {
            addCriterion("news_date in", values, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotIn(List<Date> values) {
            addCriterion("news_date not in", values, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateBetween(Date value1, Date value2) {
            addCriterion("news_date between", value1, value2, "newsDate");
            return (Criteria) this;
        }

        public Criteria andNewsDateNotBetween(Date value1, Date value2) {
            addCriterion("news_date not between", value1, value2, "newsDate");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopIsNull() {
            addCriterion("news_recommend_top is null");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopIsNotNull() {
            addCriterion("news_recommend_top is not null");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopEqualTo(Boolean value) {
            addCriterion("news_recommend_top =", value, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopNotEqualTo(Boolean value) {
            addCriterion("news_recommend_top <>", value, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopGreaterThan(Boolean value) {
            addCriterion("news_recommend_top >", value, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopGreaterThanOrEqualTo(Boolean value) {
            addCriterion("news_recommend_top >=", value, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopLessThan(Boolean value) {
            addCriterion("news_recommend_top <", value, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopLessThanOrEqualTo(Boolean value) {
            addCriterion("news_recommend_top <=", value, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopIn(List<Boolean> values) {
            addCriterion("news_recommend_top in", values, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopNotIn(List<Boolean> values) {
            addCriterion("news_recommend_top not in", values, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopBetween(Boolean value1, Boolean value2) {
            addCriterion("news_recommend_top between", value1, value2, "newsRecommendTop");
            return (Criteria) this;
        }

        public Criteria andNewsRecommendTopNotBetween(Boolean value1, Boolean value2) {
            addCriterion("news_recommend_top not between", value1, value2, "newsRecommendTop");
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