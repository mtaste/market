package com.app.market.support.util;

import com.esotericsoftware.reflectasm.MethodAccess;

public class ReflectUtil {
	/**
	 * 检查是否存在方法
	 * 
	 * @param obj
	 * @param name
	 * @return
	 */
	public static boolean checkMethod(Object obj, String name) {
		MethodAccess access = MethodAccess.get(obj.getClass());
		Integer index = access.getIndex(name);
		if (index >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取object的值
	 * 
	 * @param obj
	 * @param name
	 * @return
	 */
	public static Object getValue(Object obj, String name) {
		MethodAccess access = MethodAccess.get(obj.getClass());
		Object ret = access.invoke(obj, name);
		if (ret != null) {
			return ret;
		} else {
			return "";
		}
	}

	/**
	 * 设置属性
	 * 
	 * @param obj
	 * @param name
	 * @param value
	 */
	public static void setValue(Object obj, String name, Object value) {
		MethodAccess access = MethodAccess.get(obj.getClass());
		access.invoke(obj, name, value);
	}

	/**
	 * 运行方法
	 * 
	 * @param obj
	 * @param name
	 * @param args
	 * @return
	 */
	public static Object runMethod(Object obj, String name, Object... args) {
		MethodAccess access = MethodAccess.get(obj.getClass());
		return access.invoke(obj, name, args);
	}
}
