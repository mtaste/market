package com.app.market.support.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONException;

public class CheckUtil {
	public final static String sign_key = "c2t_private";

	/**
	 * 加密参数
	 * 
	 * @author Administrator
	 * 
	 */
	public static class SignParam {
		/**
		 * 
		 * @param timestamp
		 * @param nonce
		 * @param signature
		 * @param tradeSource
		 * @param data
		 *            ;
		 */
		public SignParam(String t, String s, String d) {
			this.timestamp = t;
			this.signature = s;
			this.data = d;
		}

		public String timestamp;
		public String signature;
		public String data;
	}

	/**
	 * 校验系统请求参数
	 * 
	 * @throws JSONException
	 */
	public static String ReqSignaturesVerify(SignParam param, String secretKey) {
		StringBuffer msg = new StringBuffer();
		// 校验参数是否为空
		if (StringUtils.isBlank(param.data) || StringUtils.isBlank(param.timestamp)
				|| StringUtils.isBlank(param.signature)) {
			msg.append("调用接口失败，错误原因：缺少参数！timestamp=");
			msg.append(param.timestamp);
			msg.append("&signature=");
			msg.append(param.signature);
			msg.append("&data=");
			msg.append(param.data);
			return msg.toString();
		}
		// 获取系统加密私钥
		// 系统配置的KEY规则：系统来源大写_KEY。如：MPS_KEY
		// 对比签名
		// 生成密钥:MD5(key+timestamp+nonce+tradeSource+data).uppper
		String create_sign = createSign(secretKey, param);
		// 签名认证
		if (!param.signature.equals(create_sign)) {
			msg.append("调用接口失败，错误原因：签名认证失败！传入signature:");
			msg.append(param.signature);
			msg.append("，验证signature:");
			msg.append(create_sign);
			return msg.toString();
		}
		return "";
	}

	/**
	 * 创建系统答名
	 * 
	 * @param sign_key
	 * @param param
	 * @return
	 */
	public static String createSign(String sign_key, SignParam param) {
		StringBuffer tempSign = new StringBuffer();
		tempSign.append(sign_key);
		tempSign.append(param.timestamp);
		tempSign.append(param.data);
		String temp = MD5.Md5_32(tempSign.toString()).toUpperCase();
		return temp;
	}
}
