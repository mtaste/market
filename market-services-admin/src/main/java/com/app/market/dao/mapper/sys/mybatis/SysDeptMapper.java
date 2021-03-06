package com.app.market.dao.mapper.sys.mybatis;

import com.app.market.dao.entity.sys.mybatis.SysDept;
import com.app.market.dao.entity.sys.mybatis.SysDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int countByExample(SysDeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int deleteByExample(SysDeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int insert(SysDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int insertSelective(SysDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    List<SysDept> selectByExample(SysDeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    SysDept selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int updateByPrimaryKeySelective(SysDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Thu Feb 23 10:52:26 CST 2017
     */
    int updateByPrimaryKey(SysDept record);
}