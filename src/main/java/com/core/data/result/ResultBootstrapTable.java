package com.core.data.result;


public class ResultBootstrapTable<T> {

	private Long total;
	private String msg;
	private T rows;

	public ResultBootstrapTable() {
		super();
	}

	public ResultBootstrapTable(Long total, String msg, T rows) {
		this.total = total;
		this.msg = msg;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getRows() {
		return rows;
	}

	public void setRows(T rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Result{" + "total=" + total + ", msg='" + msg + '\'' + ", rows=" + rows + '}';
	}

}
