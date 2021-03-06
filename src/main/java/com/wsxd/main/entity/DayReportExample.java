package com.wsxd.main.entity;

import java.util.ArrayList;
import java.util.List;

public class DayReportExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public DayReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
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
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
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

        public Criteria andCheckDateIsNull() {
            addCriterion("check_date is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("check_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(String value) {
            addCriterion("check_date =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(String value) {
            addCriterion("check_date <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(String value) {
            addCriterion("check_date >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(String value) {
            addCriterion("check_date >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(String value) {
            addCriterion("check_date <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(String value) {
            addCriterion("check_date <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLike(String value) {
            addCriterion("check_date like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotLike(String value) {
            addCriterion("check_date not like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<String> values) {
            addCriterion("check_date in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<String> values) {
            addCriterion("check_date not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(String value1, String value2) {
            addCriterion("check_date between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(String value1, String value2) {
            addCriterion("check_date not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andDayCountIsNull() {
            addCriterion("day_count is null");
            return (Criteria) this;
        }

        public Criteria andDayCountIsNotNull() {
            addCriterion("day_count is not null");
            return (Criteria) this;
        }

        public Criteria andDayCountEqualTo(String value) {
            addCriterion("day_count =", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotEqualTo(String value) {
            addCriterion("day_count <>", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountGreaterThan(String value) {
            addCriterion("day_count >", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountGreaterThanOrEqualTo(String value) {
            addCriterion("day_count >=", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLessThan(String value) {
            addCriterion("day_count <", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLessThanOrEqualTo(String value) {
            addCriterion("day_count <=", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountLike(String value) {
            addCriterion("day_count like", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotLike(String value) {
            addCriterion("day_count not like", value, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountIn(List<String> values) {
            addCriterion("day_count in", values, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotIn(List<String> values) {
            addCriterion("day_count not in", values, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountBetween(String value1, String value2) {
            addCriterion("day_count between", value1, value2, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayCountNotBetween(String value1, String value2) {
            addCriterion("day_count not between", value1, value2, "dayCount");
            return (Criteria) this;
        }

        public Criteria andDayMoneyIsNull() {
            addCriterion("day_money is null");
            return (Criteria) this;
        }

        public Criteria andDayMoneyIsNotNull() {
            addCriterion("day_money is not null");
            return (Criteria) this;
        }

        public Criteria andDayMoneyEqualTo(String value) {
            addCriterion("day_money =", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyNotEqualTo(String value) {
            addCriterion("day_money <>", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyGreaterThan(String value) {
            addCriterion("day_money >", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("day_money >=", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyLessThan(String value) {
            addCriterion("day_money <", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyLessThanOrEqualTo(String value) {
            addCriterion("day_money <=", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyLike(String value) {
            addCriterion("day_money like", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyNotLike(String value) {
            addCriterion("day_money not like", value, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyIn(List<String> values) {
            addCriterion("day_money in", values, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyNotIn(List<String> values) {
            addCriterion("day_money not in", values, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyBetween(String value1, String value2) {
            addCriterion("day_money between", value1, value2, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayMoneyNotBetween(String value1, String value2) {
            addCriterion("day_money not between", value1, value2, "dayMoney");
            return (Criteria) this;
        }

        public Criteria andDayLoanIsNull() {
            addCriterion("day_loan is null");
            return (Criteria) this;
        }

        public Criteria andDayLoanIsNotNull() {
            addCriterion("day_loan is not null");
            return (Criteria) this;
        }

        public Criteria andDayLoanEqualTo(String value) {
            addCriterion("day_loan =", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanNotEqualTo(String value) {
            addCriterion("day_loan <>", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanGreaterThan(String value) {
            addCriterion("day_loan >", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanGreaterThanOrEqualTo(String value) {
            addCriterion("day_loan >=", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanLessThan(String value) {
            addCriterion("day_loan <", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanLessThanOrEqualTo(String value) {
            addCriterion("day_loan <=", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanLike(String value) {
            addCriterion("day_loan like", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanNotLike(String value) {
            addCriterion("day_loan not like", value, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanIn(List<String> values) {
            addCriterion("day_loan in", values, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanNotIn(List<String> values) {
            addCriterion("day_loan not in", values, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanBetween(String value1, String value2) {
            addCriterion("day_loan between", value1, value2, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayLoanNotBetween(String value1, String value2) {
            addCriterion("day_loan not between", value1, value2, "dayLoan");
            return (Criteria) this;
        }

        public Criteria andDayRepayIsNull() {
            addCriterion("day_repay is null");
            return (Criteria) this;
        }

        public Criteria andDayRepayIsNotNull() {
            addCriterion("day_repay is not null");
            return (Criteria) this;
        }

        public Criteria andDayRepayEqualTo(String value) {
            addCriterion("day_repay =", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayNotEqualTo(String value) {
            addCriterion("day_repay <>", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayGreaterThan(String value) {
            addCriterion("day_repay >", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayGreaterThanOrEqualTo(String value) {
            addCriterion("day_repay >=", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayLessThan(String value) {
            addCriterion("day_repay <", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayLessThanOrEqualTo(String value) {
            addCriterion("day_repay <=", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayLike(String value) {
            addCriterion("day_repay like", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayNotLike(String value) {
            addCriterion("day_repay not like", value, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayIn(List<String> values) {
            addCriterion("day_repay in", values, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayNotIn(List<String> values) {
            addCriterion("day_repay not in", values, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayBetween(String value1, String value2) {
            addCriterion("day_repay between", value1, value2, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andDayRepayNotBetween(String value1, String value2) {
            addCriterion("day_repay not between", value1, value2, "dayRepay");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceIsNull() {
            addCriterion("loan_balance is null");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceIsNotNull() {
            addCriterion("loan_balance is not null");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceEqualTo(String value) {
            addCriterion("loan_balance =", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotEqualTo(String value) {
            addCriterion("loan_balance <>", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceGreaterThan(String value) {
            addCriterion("loan_balance >", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("loan_balance >=", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceLessThan(String value) {
            addCriterion("loan_balance <", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceLessThanOrEqualTo(String value) {
            addCriterion("loan_balance <=", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceLike(String value) {
            addCriterion("loan_balance like", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotLike(String value) {
            addCriterion("loan_balance not like", value, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceIn(List<String> values) {
            addCriterion("loan_balance in", values, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotIn(List<String> values) {
            addCriterion("loan_balance not in", values, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceBetween(String value1, String value2) {
            addCriterion("loan_balance between", value1, value2, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanBalanceNotBetween(String value1, String value2) {
            addCriterion("loan_balance not between", value1, value2, "loanBalance");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNull() {
            addCriterion("loan_money is null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIsNotNull() {
            addCriterion("loan_money is not null");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyEqualTo(String value) {
            addCriterion("loan_money =", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotEqualTo(String value) {
            addCriterion("loan_money <>", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThan(String value) {
            addCriterion("loan_money >", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("loan_money >=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThan(String value) {
            addCriterion("loan_money <", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLessThanOrEqualTo(String value) {
            addCriterion("loan_money <=", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyLike(String value) {
            addCriterion("loan_money like", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotLike(String value) {
            addCriterion("loan_money not like", value, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyIn(List<String> values) {
            addCriterion("loan_money in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotIn(List<String> values) {
            addCriterion("loan_money not in", values, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyBetween(String value1, String value2) {
            addCriterion("loan_money between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanMoneyNotBetween(String value1, String value2) {
            addCriterion("loan_money not between", value1, value2, "loanMoney");
            return (Criteria) this;
        }

        public Criteria andLoanCountIsNull() {
            addCriterion("loan_count is null");
            return (Criteria) this;
        }

        public Criteria andLoanCountIsNotNull() {
            addCriterion("loan_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCountEqualTo(String value) {
            addCriterion("loan_count =", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotEqualTo(String value) {
            addCriterion("loan_count <>", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountGreaterThan(String value) {
            addCriterion("loan_count >", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountGreaterThanOrEqualTo(String value) {
            addCriterion("loan_count >=", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountLessThan(String value) {
            addCriterion("loan_count <", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountLessThanOrEqualTo(String value) {
            addCriterion("loan_count <=", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountLike(String value) {
            addCriterion("loan_count like", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotLike(String value) {
            addCriterion("loan_count not like", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountIn(List<String> values) {
            addCriterion("loan_count in", values, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotIn(List<String> values) {
            addCriterion("loan_count not in", values, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountBetween(String value1, String value2) {
            addCriterion("loan_count between", value1, value2, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotBetween(String value1, String value2) {
            addCriterion("loan_count not between", value1, value2, "loanCount");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table day_report
     *
     * @mbg.generated do_not_delete_during_merge Wed Jun 06 20:44:37 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table day_report
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
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