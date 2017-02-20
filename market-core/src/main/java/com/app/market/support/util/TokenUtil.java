package com.app.market.support.util;

import java.util.Date;
import java.util.Map;

import jodd.util.Base64;

@SuppressWarnings("unused")
public class TokenUtil {
	private static String prex = ",@,";

	/**
	 * 获取token
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String encryptToken(String str) throws Exception {
		String result = str;
		// 先加密
		result = DESUtil.encrypt(result, DESUtil.key);
		// 转换为64
		result = Base64.encodeToString(result);
		// 增加时间
		StringBuffer temp = new StringBuffer(result);
		temp.append(prex);
		temp.append(new Date().getTime());
		// 转换为64
		result = Base64.encodeToString(temp.toString());
		// result = Base64.decodeToString(result);
		// 加密
		return result;
	}

	/**
	 * 解token
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String decryptToken(String str) throws Exception {
		String result = str;
		result = Base64.decodeToString(result);
		result = result.split(prex)[0];
		result = Base64.decodeToString(result);// 加密
		result = DESUtil.decrypt(result, DESUtil.key);
		return result;
	}

	public static void main(String[] args) throws Exception {
		String data = "13902601727";
		String token = TokenUtil.encryptToken(data);
		System.out.println(token);
		System.out.println(TokenUtil.decryptToken(token));
	}
}
