package com.wsxd.main.entity;

import java.util.ArrayList;
import java.util.List;

public class ContractLossExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public ContractLossExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
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
     * This method corresponds to the database table contract_loss
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
     * This method corresponds to the database table contract_loss
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_loss
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
     * This class corresponds to the database table contract_loss
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

        public Criteria andContractNumberIsNull() {
            addCriterion("contract_number is null");
            return (Criteria) this;
        }

        public Criteria andContractNumberIsNotNull() {
            addCriterion("contract_number is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumberEqualTo(String value) {
            addCriterion("contract_number =", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotEqualTo(String value) {
            addCriterion("contract_number <>", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThan(String value) {
            addCriterion("contract_number >", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contract_number >=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThan(String value) {
            addCriterion("contract_number <", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLessThanOrEqualTo(String value) {
            addCriterion("contract_number <=", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberLike(String value) {
            addCriterion("contract_number like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotLike(String value) {
            addCriterion("contract_number not like", value, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberIn(List<String> values) {
            addCriterion("contract_number in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotIn(List<String> values) {
            addCriterion("contract_number not in", values, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberBetween(String value1, String value2) {
            addCriterion("contract_number between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andContractNumberNotBetween(String value1, String value2) {
            addCriterion("contract_number not between", value1, value2, "contractNumber");
            return (Criteria) this;
        }

        public Criteria andBadMoneyIsNull() {
            addCriterion("bad_money is null");
            return (Criteria) this;
        }

        public Criteria andBadMoneyIsNotNull() {
            addCriterion("bad_money is not null");
            return (Criteria) this;
        }

        public Criteria andBadMoneyEqualTo(String value) {
            addCriterion("bad_money =", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyNotEqualTo(String value) {
            addCriterion("bad_money <>", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyGreaterThan(String value) {
            addCriterion("bad_money >", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("bad_money >=", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyLessThan(String value) {
            addCriterion("bad_money <", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyLessThanOrEqualTo(String value) {
            addCriterion("bad_money <=", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyLike(String value) {
            addCriterion("bad_money like", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyNotLike(String value) {
            addCriterion("bad_money not like", value, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyIn(List<String> values) {
            addCriterion("bad_money in", values, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyNotIn(List<String> values) {
            addCriterion("bad_money not in", values, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyBetween(String value1, String value2) {
            addCriterion("bad_money between", value1, value2, "badMoney");
            return (Criteria) this;
        }

        public Criteria andBadMoneyNotBetween(String value1, String value2) {
            addCriterion("bad_money not between", value1, value2, "badMoney");
            return (Criteria) this;
        }

        public Criteria andLossDateIsNull() {
            addCriterion("loss_date is null");
            return (Criteria) this;
        }

        public Criteria andLossDateIsNotNull() {
            addCriterion("loss_date is not null");
            return (Criteria) this;
        }

        public Criteria andLossDateEqualTo(String value) {
            addCriterion("loss_date =", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateNotEqualTo(String value) {
            addCriterion("loss_date <>", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateGreaterThan(String value) {
            addCriterion("loss_date >", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateGreaterThanOrEqualTo(String value) {
            addCriterion("loss_date >=", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateLessThan(String value) {
            addCriterion("loss_date <", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateLessThanOrEqualTo(String value) {
            addCriterion("loss_date <=", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateLike(String value) {
            addCriterion("loss_date like", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateNotLike(String value) {
            addCriterion("loss_date not like", value, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateIn(List<String> values) {
            addCriterion("loss_date in", values, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateNotIn(List<String> values) {
            addCriterion("loss_date not in", values, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateBetween(String value1, String value2) {
            addCriterion("loss_date between", value1, value2, "lossDate");
            return (Criteria) this;
        }

        public Criteria andLossDateNotBetween(String value1, String value2) {
            addCriterion("loss_date not between", value1, value2, "lossDate");
            return (Criteria) this;
        }

        public Criteria andBadTypeIsNull() {
            addCriterion("bad_type is null");
            return (Criteria) this;
        }

        public Criteria andBadTypeIsNotNull() {
            addCriterion("bad_type is not null");
            return (Criteria) this;
        }

        public Criteria andBadTypeEqualTo(String value) {
            addCriterion("bad_type =", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeNotEqualTo(String value) {
            addCriterion("bad_type <>", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeGreaterThan(String value) {
            addCriterion("bad_type >", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bad_type >=", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeLessThan(String value) {
            addCriterion("bad_type <", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeLessThanOrEqualTo(String value) {
            addCriterion("bad_type <=", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeLike(String value) {
            addCriterion("bad_type like", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeNotLike(String value) {
            addCriterion("bad_type not like", value, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeIn(List<String> values) {
            addCriterion("bad_type in", values, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeNotIn(List<String> values) {
            addCriterion("bad_type not in", values, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeBetween(String value1, String value2) {
            addCriterion("bad_type between", value1, value2, "badType");
            return (Criteria) this;
        }

        public Criteria andBadTypeNotBetween(String value1, String value2) {
            addCriterion("bad_type not between", value1, value2, "badType");
            return (Criteria) this;
        }

        public Criteria andFollowUpIsNull() {
            addCriterion("follow_up is null");
            return (Criteria) this;
        }

        public Criteria andFollowUpIsNotNull() {
            addCriterion("follow_up is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUpEqualTo(String value) {
            addCriterion("follow_up =", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpNotEqualTo(String value) {
            addCriterion("follow_up <>", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpGreaterThan(String value) {
            addCriterion("follow_up >", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpGreaterThanOrEqualTo(String value) {
            addCriterion("follow_up >=", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpLessThan(String value) {
            addCriterion("follow_up <", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpLessThanOrEqualTo(String value) {
            addCriterion("follow_up <=", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpLike(String value) {
            addCriterion("follow_up like", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpNotLike(String value) {
            addCriterion("follow_up not like", value, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpIn(List<String> values) {
            addCriterion("follow_up in", values, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpNotIn(List<String> values) {
            addCriterion("follow_up not in", values, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpBetween(String value1, String value2) {
            addCriterion("follow_up between", value1, value2, "followUp");
            return (Criteria) this;
        }

        public Criteria andFollowUpNotBetween(String value1, String value2) {
            addCriterion("follow_up not between", value1, value2, "followUp");
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
     * This class corresponds to the database table contract_loss
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
     * This class corresponds to the database table contract_loss
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