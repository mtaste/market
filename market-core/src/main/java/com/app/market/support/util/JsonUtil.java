package com.app.market.support.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import jodd.util.StringUtil;

public class JsonUtil {
	/**
	 * 数组转换
	 * 
	 * @param <T>
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public static <T> List<T> parseList(String json, Class<T> type) {
		if (StringUtil.isBlank(json)) {
			return null;
		}
		try {
			List<T> list = JSONArray.parseArray(json, type);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * String转换Class
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public static <T> T parse(String json, Class<T> type) {
		if (StringUtil.isBlank(json)) {
			return null;
		}
		return JSON.parseObject(json, type);
	}

	/**
	 * Object to JSON String
	 * 
	 * @param ret
	 * @return
	 */
	public static String toJson(Object ret) {
		return JSON.toJSONString(ret);
	}
}
