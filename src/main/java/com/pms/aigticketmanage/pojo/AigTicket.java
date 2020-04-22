package com.pms.aigticketmanage.pojo;

import java.io.Serializable;
import java.util.Date;

public class AigTicket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String application;
	private String application_no;
	private String profit_center;
	private String issue_description;
	private String applicant_name;
	private String lOB;
	private String change_type;
	private String code_change;
	private String branch;
	private String department;
	private Date submission_date;
	private String pending_MthOrYr;
	private String request_type;
	private String sub_type;
	private String priority;
	private int severity;
	private String team_in_charge;
	private Date assign_dev_team_date;
	private String ba_in_charge;
	private String data_owner_id;
	private String developer;
	private Date send_dev_team_for_estimation_time;
	private Date send_estimation_to_BA_team_time;
	private double estimated_effort;
	private double actual_effort;
	private String test_results;
	private Date target_delivery_date;
	private String status;
	private Date close_date;
	private String build_no;
	private Date build_release_date;
	private String build_status;
	private String pot_review;
	private String pss_for_uat;
	private Date uat_date;
	private String uat_status;
	private String pss_for_prod;
	private Date production_date;
	private String production_status;
	private String solution;
	private String comments;
	private Date supervisor_approved_time;
	private Date it_manager_approved_time;
	private Date data_owner_approved_time;
	private Date dev_resolved_time;
	private Date send_user_uat_confirm_time;
	private Date user_uat_confirmed_time;
	private Date ba_resolved_time;
	private Date send_user_prod_confirm_time;
	private Date ba_send_acknowledge_time;
	private Date dev_send_acknowledge_time;
	private String survey_results;
	private String survey_remarks;
	private String edit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getApplication_no() {
		return application_no;
	}

	public void setApplication_no(String application_no) {
		this.application_no = application_no;
	}

	public String getProfit_center() {
		return profit_center;
	}

	public void setProfit_center(String profit_center) {
		this.profit_center = profit_center;
	}

	public String getIssue_description() {
		return issue_description;
	}

	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getlOB() {
		return lOB;
	}

	public void setlOB(String lOB) {
		this.lOB = lOB;
	}

	public String getChange_type() {
		return change_type;
	}

	public void setChange_type(String change_type) {
		this.change_type = change_type;
	}

	public String getCode_change() {
		return code_change;
	}

	public void setCode_change(String code_change) {
		this.code_change = code_change;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}

	public String getPending_MthOrYr() {
		return pending_MthOrYr;
	}

	public void setPending_MthOrYr(String pending_MthOrYr) {
		this.pending_MthOrYr = pending_MthOrYr;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public String getTeam_in_charge() {
		return team_in_charge;
	}

	public void setTeam_in_charge(String team_in_charge) {
		this.team_in_charge = team_in_charge;
	}

	public Date getAssign_dev_team_date() {
		return assign_dev_team_date;
	}

	public void setAssign_dev_team_date(Date assign_dev_team_date) {
		this.assign_dev_team_date = assign_dev_team_date;
	}

	public String getBa_in_charge() {
		return ba_in_charge;
	}

	public void setBa_in_charge(String ba_in_charge) {
		this.ba_in_charge = ba_in_charge;
	}

	public String getData_owner_id() {
		return data_owner_id;
	}

	public void setData_owner_id(String data_owner_id) {
		this.data_owner_id = data_owner_id;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Date getSend_dev_team_for__estimation_time() {
		return send_dev_team_for_estimation_time;
	}

	public void setSend_dev_team_for__estimation_time(Date send_dev_team_for__estimation_time) {
		this.send_dev_team_for_estimation_time = send_dev_team_for__estimation_time;
	}

	public Date getSend_estimation_to_BA_team_time() {
		return send_estimation_to_BA_team_time;
	}

	public void setSend_estimation_to_BA_team_time(Date send_estimation_to_BA_team_time) {
		this.send_estimation_to_BA_team_time = send_estimation_to_BA_team_time;
	}

	public double getEstimated_effort() {
		return estimated_effort;
	}

	public void setEstimated_effort(double estimated_effort) {
		this.estimated_effort = estimated_effort;
	}

	public double getActual_effort() {
		return actual_effort;
	}

	public void setActual_effort(double actual_effort) {
		this.actual_effort = actual_effort;
	}

	public String getTest_results() {
		return test_results;
	}

	public void setTest_results(String test_results) {
		this.test_results = test_results;
	}

	public Date getTarget_delivery_date() {
		return target_delivery_date;
	}

	public void setTarget_delivery_date(Date target_delivery_date) {
		this.target_delivery_date = target_delivery_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	public String getBuild_no() {
		return build_no;
	}

	public void setBuild_no(String build_no) {
		this.build_no = build_no;
	}

	public Date getBuild_release_date() {
		return build_release_date;
	}

	public void setBuild_release_date(Date build_release_date) {
		this.build_release_date = build_release_date;
	}

	public String getBuild_status() {
		return build_status;
	}

	public void setBuild_status(String build_status) {
		this.build_status = build_status;
	}

	public String getPot_review() {
		return pot_review;
	}

	public void setPot_review(String pot_review) {
		this.pot_review = pot_review;
	}

	public String getPss_for_uat() {
		return pss_for_uat;
	}

	public void setPss_for_uat(String pss_for_uat) {
		this.pss_for_uat = pss_for_uat;
	}

	public Date getUat_date() {
		return uat_date;
	}

	public void setUat_date(Date uat_date) {
		this.uat_date = uat_date;
	}

	public String getUat_status() {
		return uat_status;
	}

	public void setUat_status(String uat_status) {
		this.uat_status = uat_status;
	}

	public String getPss_for_prod() {
		return pss_for_prod;
	}

	public void setPss_for_prod(String pss_for_prod) {
		this.pss_for_prod = pss_for_prod;
	}

	public Date getProduction_date() {
		return production_date;
	}

	public void setProduction_date(Date production_date) {
		this.production_date = production_date;
	}

	public String getProduction_status() {
		return production_status;
	}

	public void setProduction_status(String production_status) {
		this.production_status = production_status;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getSupervisor_approved_time() {
		return supervisor_approved_time;
	}

	public void setSupervisor_approved_time(Date supervisor_approved_time) {
		this.supervisor_approved_time = supervisor_approved_time;
	}

	public Date getIt_manager_approved_time() {
		return it_manager_approved_time;
	}

	public void setIt_manager_approved_time(Date it_manager_approved_time) {
		this.it_manager_approved_time = it_manager_approved_time;
	}

	public Date getData_owner_approved_time() {
		return data_owner_approved_time;
	}

	public void setData_owner_approved_time(Date data_owner_approved_time) {
		this.data_owner_approved_time = data_owner_approved_time;
	}

	public Date getDev_resolved_time() {
		return dev_resolved_time;
	}

	public void setDev_resolved_time(Date dev_resolved_time) {
		this.dev_resolved_time = dev_resolved_time;
	}

	public Date getSend_user_uat_confirm_time() {
		return send_user_uat_confirm_time;
	}

	public void setSend_user_uat_confirm_time(Date send_user_uat_confirm_time) {
		this.send_user_uat_confirm_time = send_user_uat_confirm_time;
	}

	public Date getUser_uat_confirmed_time() {
		return user_uat_confirmed_time;
	}

	public void setUser_uat_confirmed_time(Date user_uat_confirmed_time) {
		this.user_uat_confirmed_time = user_uat_confirmed_time;
	}

	public Date getBa_resolved_time() {
		return ba_resolved_time;
	}

	public void setBa_resolved_time(Date ba_resolved_time) {
		this.ba_resolved_time = ba_resolved_time;
	}

	public Date getSend_user_prod_confirm_time() {
		return send_user_prod_confirm_time;
	}

	public void setSend_user_prod_confirm_time(Date send_user_prod_confirm_time) {
		this.send_user_prod_confirm_time = send_user_prod_confirm_time;
	}

	public Date getBa_send_acknowledge_time() {
		return ba_send_acknowledge_time;
	}

	public void setBa_send_acknowledge_time(Date ba_send_acknowledge_time) {
		this.ba_send_acknowledge_time = ba_send_acknowledge_time;
	}

	public Date getDev_send_acknowledge_time() {
		return dev_send_acknowledge_time;
	}

	public void setDev_send_acknowledge_time(Date dev_send_acknowledge_time) {
		this.dev_send_acknowledge_time = dev_send_acknowledge_time;
	}

	public String getSurvey_results() {
		return survey_results;
	}

	public void setSurvey_results(String survey_results) {
		this.survey_results = survey_results;
	}

	public String getSurvey_remarks() {
		return survey_remarks;
	}

	public void setSurvey_remarks(String survey_remarks) {
		this.survey_remarks = survey_remarks;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	@Override
	public String toString() {
		return "AigTicket [id=" + id + ", application=" + application + ", application_no=" + application_no
				+ ", profit_center=" + profit_center + ", issue_description=" + issue_description + ", applicant_name="
				+ applicant_name + ", lOB=" + lOB + ", change_type=" + change_type + ", code_change=" + code_change
				+ ", branch=" + branch + ", department=" + department + ", submission_date=" + submission_date
				+ ", pending_MthOrYr=" + pending_MthOrYr + ", request_type=" + request_type + ", sub_type=" + sub_type
				+ ", priority=" + priority + ", severity=" + severity + ", team_in_charge=" + team_in_charge
				+ ", assign_dev_team_date=" + assign_dev_team_date + ", ba_in_charge=" + ba_in_charge
				+ ", data_owner_id=" + data_owner_id + ", developer=" + developer
				+ ", send_dev_team_for__estimation_time=" + send_dev_team_for_estimation_time
				+ ", send_estimation_to_BA_team_time=" + send_estimation_to_BA_team_time + ", estimated_effort="
				+ estimated_effort + ", actual_effort=" + actual_effort + ", test_results=" + test_results
				+ ", target_delivery_date=" + target_delivery_date + ", status=" + status + ", close_date=" + close_date
				+ ", build_no=" + build_no + ", build_release_date=" + build_release_date + ", build_status="
				+ build_status + ", pot_review=" + pot_review + ", pss_for_uat=" + pss_for_uat + ", uat_date="
				+ uat_date + ", uat_status=" + uat_status + ", pss_for_prod=" + pss_for_prod + ", production_date="
				+ production_date + ", production_status=" + production_status + ", solution=" + solution
				+ ", comments=" + comments + ", supervisor_approved_time=" + supervisor_approved_time
				+ ", it_manager_approved_time=" + it_manager_approved_time + ", data_owner_approved_time="
				+ data_owner_approved_time + ", dev_resolved_time=" + dev_resolved_time
				+ ", send_user_uat_confirm_time=" + send_user_uat_confirm_time + ", user_uat_confirmed_time="
				+ user_uat_confirmed_time + ", ba_resolved_time=" + ba_resolved_time + ", send_user_prod_confirm_time="
				+ send_user_prod_confirm_time + ", ba_send_acknowledge_time=" + ba_send_acknowledge_time
				+ ", dev_send_acknowledge_time=" + dev_send_acknowledge_time + ", survey_results=" + survey_results
				+ ", survey_remarks=" + survey_remarks + ", edit=" + edit + "]";
	}

	
	
}
