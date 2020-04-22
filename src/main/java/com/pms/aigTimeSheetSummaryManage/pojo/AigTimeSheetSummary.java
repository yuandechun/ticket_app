package com.pms.aigTimeSheetSummaryManage.pojo;

import java.io.Serializable;

/****
 * 
 * @author dechun.yuan
 *
 */
public class AigTimeSheetSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_name;
	private String year;
	private String month;
	private String ticket_count;
	private String total_timesheet;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTicket_count() {
		return ticket_count;
	}

	public void setTicket_count(String ticket_count) {
		this.ticket_count = ticket_count;
	}

	public String getTotal_timesheet() {
		return total_timesheet;
	}

	public void setTotal_timesheet(String total_timesheet) {
		this.total_timesheet = total_timesheet;
	}

}
