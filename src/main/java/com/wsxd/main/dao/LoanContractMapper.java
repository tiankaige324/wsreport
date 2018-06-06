package com.wsxd.main.dao;

import com.wsxd.main.entity.LoanContract;
import com.wsxd.main.entity.LoanContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanContractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    long countByExample(LoanContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int deleteByExample(LoanContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int deleteByPrimaryKey(String contractNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int insert(LoanContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int insertSelective(LoanContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    List<LoanContract> selectByExample(LoanContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    LoanContract selectByPrimaryKey(String contractNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int updateByExampleSelective(@Param("record") LoanContract record, @Param("example") LoanContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int updateByExample(@Param("record") LoanContract record, @Param("example") LoanContractExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int updateByPrimaryKeySelective(LoanContract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table loan_contract
     *
     * @mbg.generated Wed Jun 06 20:44:37 CST 2018
     */
    int updateByPrimaryKey(LoanContract record);
}