package com.app.market.support.util;

public class SQLUtil {
	/**
	 * 获取 %p%类的参数
	 * 
	 * @param param
	 * @return
	 */
	public static String centerLike(String param) {
		StringBuffer temp = new StringBuffer("%");
		temp.append(param).append("%");
		return temp.toString();
	}

	/**
	 * 获取 %p%类的参数
	 * 
	 * @param param
	 * @return
	 */
	public static String rightLike(String param) {
		StringBuffer temp = new StringBuffer();
		temp.append(param).append("%");
		return temp.toString();
	}

	/**
	 * 获取 %p%类的参数
	 * 
	 * @param param
	 * @return
	 */
	public static String leftLike(String param) {
		StringBuffer temp = new StringBuffer("%");
		temp.append(param);
		return temp.toString();
	}

}
