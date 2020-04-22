package com.core.data.result;

/***
 * 
 * @author dechun.yuan
 *
 */
public class ResultBootstrapTableUtil {

	/** 成功且带数据 **/
	public static ResultBootstrapTable success(Long total,Object object) {
		ResultBootstrapTable result = new ResultBootstrapTable();
		result.setMsg(ResultStatusCode.Success.getMsg());
		result.setTotal(total);
		result.setRows(object);
		return result;
	}

	/** 成功但不带数据 **/
	public static ResultBootstrapTable success() {
		return success(null,null);
	}

	/** 失败 **/
	public static ResultBootstrapTable error(Integer code, String msg) {
		ResultBootstrapTable result = new ResultBootstrapTable();
		result.setMsg(msg);
		return result;
	}

}
