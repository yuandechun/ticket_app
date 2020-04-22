package com.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatcherUtils {

	/****
	 * 
	 * @param （6-16位数字和字母和特殊字符的组合）
	 * @return
	 */
	public static boolean isValidPassword(String password) {
		if (null == password || "".equals(password)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)(?![@$#]+$)[0-9A-Za-z@$#]{6,16}$");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/****
	 * tel 11位,1开头，第二位(3,4,5,7,8)
	 * @param tel
	 * @return
	 */
	public static boolean isValidTel(String tel) {
		if (null == tel || "".equals(tel)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		//Pattern pattern = Pattern.compile("^1[0-9]{10}$");
		Matcher matcher = pattern.matcher(tel);
		return matcher.matches();
	}


}
