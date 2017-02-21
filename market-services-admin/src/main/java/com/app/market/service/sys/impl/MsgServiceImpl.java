package com.app.market.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.market.dao.entity.sys.mybatis.SysDic;
import com.app.market.dao.entity.sys.mybatis.SysDicExample;
import com.app.market.dao.mapper.sys.mybatis.SysDicMapper;
import com.app.market.service.sys.MsgService;
import com.app.market.support.util.Version;

@Service(version = Version.NOW)
public class MsgServiceImpl implements MsgService {
	@Autowired
	SysDicMapper sysDicMapper;

	/**
	 * 获取msg_type的信息，可以做缓存。
	 */
	@Override
	public String getMsg(String code) {
		if (code.length() >= 500) {
			return "";
		}
		SysDicExample example = new SysDicExample();
		example.createCriteria().andDicTypeEqualTo("msg").andValEqualTo(code);
		List<SysDic> list = sysDicMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0).getName();
		}
		return "";
	}

}
