package com.core.data.result;

/***
 * 
 * @author dechun.yuan
 *
 */

@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class ResultUtil {

	/** 成功且带数据 **/
	public static Result success(Object object) {
		Result result = new Result();
		result.setCode(ResultStatusCode.Success.getCode());
		result.setMsg(ResultStatusCode.Success.getMsg());
		result.setData(object);
		return result;
	}

	/** 成功但不带数据 **/
	public static Result success() {
		return success(null);
	}

	/** 失败 **/
	public static Result error(String code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}

}
