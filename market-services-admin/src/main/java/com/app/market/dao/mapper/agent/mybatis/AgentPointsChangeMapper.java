package com.app.market.dao.mapper.agent.mybatis;

import com.app.market.dao.entity.agent.mybatis.AgentPointsChange;
import com.app.market.dao.entity.agent.mybatis.AgentPointsChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentPointsChangeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int countByExample(AgentPointsChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int deleteByExample(AgentPointsChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int insert(AgentPointsChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int insertSelective(AgentPointsChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    List<AgentPointsChange> selectByExample(AgentPointsChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    AgentPointsChange selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int updateByExampleSelective(@Param("record") AgentPointsChange record, @Param("example") AgentPointsChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int updateByExample(@Param("record") AgentPointsChange record, @Param("example") AgentPointsChangeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int updateByPrimaryKeySelective(AgentPointsChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table agent_points_change
     *
     * @mbggenerated Mon Mar 13 18:25:24 CST 2017
     */
    int updateByPrimaryKey(AgentPointsChange record);
}