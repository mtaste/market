package com.app.market.support.util;

import java.util.Random;

public class RandomNumber {

	public static Integer serNO = 0;

	public static String getRandNumByLength(int numLength) {
		synchronized (serNO) {
			serNO = serNO + 1;
			String randNum = "";
			if (numLength < 0)
				return "000000000";
			if (numLength > 9) {
				int i = numLength / 9;
				int j = numLength % 9;
				for (int t = 0; t < i; t++) {
					String randDate = "000000000" + serNO.toString();
					randNum += randDate.substring(randDate.length() - 9, randDate.length());
				}
				if (j > 0) {
					String randDate = "000000000" + serNO.toString();
					randNum += randDate.substring(randDate.length() - j, randDate.length());
				}
				return randNum;
			} else {
				String randDate = "000000000" + serNO.toString();
				// System.out.println(randDate);
				randNum = randDate.substring(randDate.length() - numLength, randDate.length());
			}
			return randNum;
		}
	}

	/**
	 * 获取num（最好大于14位,若小于14位，此方法退化为随机数的生成）位流水号（要求不重复）
	 * 
	 * @param num
	 *            流水号的位数
	 * @return
	 */
	public static synchronized String getSerialNumber(int num) {
		String currentTime = System.nanoTime() + "";
		if (num < currentTime.length())
			return currentTime.substring(currentTime.length() - num, currentTime.length());
		return currentTime + getRandNumByLength(num - currentTime.length());
	}

	/**
	 * 随机数的生成
	 * 
	 * @param nRandomCount
	 *            随机数的位数
	 * @param isNumber
	 *            ---true随机数的全为数字;false随机数为数字字母混编
	 * @return
	 */
	public static synchronized String getRandomString(int nRandomCount, boolean isNumber) {
		char[] a = null;
		if (isNumber) {
			a = new char[10];
			for (int i = 48, j = 0; i <= 57; i++, j++) {
				a[j] = (char) i;
			}
		} else {
			// ASCII 48~57, String 0~9;
			// ASCII 65~90, String A-Z;
			// ASCII 97~122,String a-z;
			a = new char[62];
			for (int i = 48, j = 0; i <= 122; i++) {
				if ((i > 57 && i < 65) || (i > 90 && i < 97)) {
					continue;
				} else {
					a[j] = (char) i;
					j++;
				}
			}
		}
		String strRand = "";
		int LengthOfRandom = a.length;
		Random random = new Random();
		for (int i = 0; i < nRandomCount; i++) {
			int nRand = random.nextInt(LengthOfRandom);
			strRand += a[nRand];
		}
		return strRand;
	}

}