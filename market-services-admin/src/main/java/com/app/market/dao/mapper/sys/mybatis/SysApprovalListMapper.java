package com.app.market.dao.mapper.sys.mybatis;

import com.app.market.dao.entity.sys.mybatis.SysApprovalList;
import com.app.market.dao.entity.sys.mybatis.SysApprovalListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysApprovalListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int countByExample(SysApprovalListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int deleteByExample(SysApprovalListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int insert(SysApprovalList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int insertSelective(SysApprovalList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    List<SysApprovalList> selectByExample(SysApprovalListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    SysApprovalList selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysApprovalList record, @Param("example") SysApprovalListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int updateByExample(@Param("record") SysApprovalList record, @Param("example") SysApprovalListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int updateByPrimaryKeySelective(SysApprovalList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_approval_list
     *
     * @mbggenerated Mon Feb 27 15:23:30 CST 2017
     */
    int updateByPrimaryKey(SysApprovalList record);
}