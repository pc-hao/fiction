package com.fiction.example;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeIsNull() {
            addCriterion("restrict_first_type is null");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeIsNotNull() {
            addCriterion("restrict_first_type is not null");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeEqualTo(Integer value) {
            addCriterion("restrict_first_type =", value, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeNotEqualTo(Integer value) {
            addCriterion("restrict_first_type <>", value, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeGreaterThan(Integer value) {
            addCriterion("restrict_first_type >", value, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("restrict_first_type >=", value, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeLessThan(Integer value) {
            addCriterion("restrict_first_type <", value, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeLessThanOrEqualTo(Integer value) {
            addCriterion("restrict_first_type <=", value, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeIn(List<Integer> values) {
            addCriterion("restrict_first_type in", values, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeNotIn(List<Integer> values) {
            addCriterion("restrict_first_type not in", values, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeBetween(Integer value1, Integer value2) {
            addCriterion("restrict_first_type between", value1, value2, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictFirstTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("restrict_first_type not between", value1, value2, "restrictFirstType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeIsNull() {
            addCriterion("restrict_second_type is null");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeIsNotNull() {
            addCriterion("restrict_second_type is not null");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeEqualTo(Integer value) {
            addCriterion("restrict_second_type =", value, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeNotEqualTo(Integer value) {
            addCriterion("restrict_second_type <>", value, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeGreaterThan(Integer value) {
            addCriterion("restrict_second_type >", value, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("restrict_second_type >=", value, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeLessThan(Integer value) {
            addCriterion("restrict_second_type <", value, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeLessThanOrEqualTo(Integer value) {
            addCriterion("restrict_second_type <=", value, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeIn(List<Integer> values) {
            addCriterion("restrict_second_type in", values, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeNotIn(List<Integer> values) {
            addCriterion("restrict_second_type not in", values, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeBetween(Integer value1, Integer value2) {
            addCriterion("restrict_second_type between", value1, value2, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andRestrictSecondTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("restrict_second_type not between", value1, value2, "restrictSecondType");
            return (Criteria) this;
        }

        public Criteria andFinishIsNull() {
            addCriterion("finish is null");
            return (Criteria) this;
        }

        public Criteria andFinishIsNotNull() {
            addCriterion("finish is not null");
            return (Criteria) this;
        }

        public Criteria andFinishEqualTo(Integer value) {
            addCriterion("finish =", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotEqualTo(Integer value) {
            addCriterion("finish <>", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThan(Integer value) {
            addCriterion("finish >", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("finish >=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThan(Integer value) {
            addCriterion("finish <", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThanOrEqualTo(Integer value) {
            addCriterion("finish <=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishIn(List<Integer> values) {
            addCriterion("finish in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotIn(List<Integer> values) {
            addCriterion("finish not in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishBetween(Integer value1, Integer value2) {
            addCriterion("finish between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("finish not between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andBookabstractIsNull() {
            addCriterion("bookAbstract is null");
            return (Criteria) this;
        }

        public Criteria andBookabstractIsNotNull() {
            addCriterion("bookAbstract is not null");
            return (Criteria) this;
        }

        public Criteria andBookabstractEqualTo(String value) {
            addCriterion("bookAbstract =", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractNotEqualTo(String value) {
            addCriterion("bookAbstract <>", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractGreaterThan(String value) {
            addCriterion("bookAbstract >", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractGreaterThanOrEqualTo(String value) {
            addCriterion("bookAbstract >=", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractLessThan(String value) {
            addCriterion("bookAbstract <", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractLessThanOrEqualTo(String value) {
            addCriterion("bookAbstract <=", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractLike(String value) {
            addCriterion("bookAbstract like", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractNotLike(String value) {
            addCriterion("bookAbstract not like", value, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractIn(List<String> values) {
            addCriterion("bookAbstract in", values, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractNotIn(List<String> values) {
            addCriterion("bookAbstract not in", values, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractBetween(String value1, String value2) {
            addCriterion("bookAbstract between", value1, value2, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andBookabstractNotBetween(String value1, String value2) {
            addCriterion("bookAbstract not between", value1, value2, "bookabstract");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updateTime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updateTime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(String value) {
            addCriterion("startDate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(String value) {
            addCriterion("startDate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(String value) {
            addCriterion("startDate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(String value) {
            addCriterion("startDate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(String value) {
            addCriterion("startDate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(String value) {
            addCriterion("startDate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLike(String value) {
            addCriterion("startDate like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotLike(String value) {
            addCriterion("startDate not like", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<String> values) {
            addCriterion("startDate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<String> values) {
            addCriterion("startDate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(String value1, String value2) {
            addCriterion("startDate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(String value1, String value2) {
            addCriterion("startDate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andPicloadIsNull() {
            addCriterion("picLoad is null");
            return (Criteria) this;
        }

        public Criteria andPicloadIsNotNull() {
            addCriterion("picLoad is not null");
            return (Criteria) this;
        }

        public Criteria andPicloadEqualTo(String value) {
            addCriterion("picLoad =", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadNotEqualTo(String value) {
            addCriterion("picLoad <>", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadGreaterThan(String value) {
            addCriterion("picLoad >", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadGreaterThanOrEqualTo(String value) {
            addCriterion("picLoad >=", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadLessThan(String value) {
            addCriterion("picLoad <", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadLessThanOrEqualTo(String value) {
            addCriterion("picLoad <=", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadLike(String value) {
            addCriterion("picLoad like", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadNotLike(String value) {
            addCriterion("picLoad not like", value, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadIn(List<String> values) {
            addCriterion("picLoad in", values, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadNotIn(List<String> values) {
            addCriterion("picLoad not in", values, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadBetween(String value1, String value2) {
            addCriterion("picLoad between", value1, value2, "picload");
            return (Criteria) this;
        }

        public Criteria andPicloadNotBetween(String value1, String value2) {
            addCriterion("picLoad not between", value1, value2, "picload");
            return (Criteria) this;
        }
    }

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