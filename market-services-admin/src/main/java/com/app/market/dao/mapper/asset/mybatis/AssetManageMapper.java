package com.app.market.dao.mapper.asset.mybatis;

import com.app.market.dao.entity.asset.mybatis.AssetManage;
import com.app.market.dao.entity.asset.mybatis.AssetManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetManageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int countByExample(AssetManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int deleteByExample(AssetManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int insert(AssetManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int insertSelective(AssetManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    List<AssetManage> selectByExample(AssetManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    AssetManage selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int updateByExampleSelective(@Param("record") AssetManage record, @Param("example") AssetManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int updateByExample(@Param("record") AssetManage record, @Param("example") AssetManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int updateByPrimaryKeySelective(AssetManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset_manage
     *
     * @mbggenerated Wed Mar 29 10:55:53 CST 2017
     */
    int updateByPrimaryKey(AssetManage record);
}