package com.app.market.dao.mapper.sys.mybatis;

import com.app.market.dao.entity.sys.mybatis.SysUser;
import com.app.market.dao.entity.sys.mybatis.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int countByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int deleteByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    List<SysUser> selectByExample(SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Tue Feb 21 09:08:00 CST 2017
     */
    int updateByPrimaryKey(SysUser record);
}