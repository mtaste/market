package com.app.market.service.user.impl;

import com.app.market.dto.user.UserInfoDTO;
import com.app.market.service.user.AuthService;
import com.app.market.support.util.Version;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = Version.NOW)
public class AuthServiceImpl implements AuthService {

	@Override
	public String authUser(UserInfoDTO p) {
		// TODO Auto-generated method stub
		return "Test";
	}

}
