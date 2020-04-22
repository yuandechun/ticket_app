package com.pms.pagemanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.core.controller.BaseController;

@Controller
@RequestMapping("/load")
public class LoadPageController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(LoadPageController.class);

	@RequestMapping(value = "/menu", method = { RequestMethod.GET })
	public String getPageMenu(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load menu page success!");
		return "menu";
	}
	
	@RequestMapping(value = "/menu_admin", method = { RequestMethod.GET })
	public String getPageAdminMenu(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load menu page success!");
		return "menu_admin";
	}

	@RequestMapping(value = "/main", method = { RequestMethod.GET })
	public String getPageMain(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load main page success!");
		return "main";
	}

	@RequestMapping(value = "/sysUser", method = { RequestMethod.GET })
	public String getPageSysUSer(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load sysUser page success!");
		return "sysUser";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String getPageSysLogin(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load login page success!");
		return "login";
	}

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String getPageRegister(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load register page success!");
		return "register";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		logger.info("logout application success!");
		return "login";
	}

	@RequestMapping(value = "/createTask", method = { RequestMethod.GET })
	public String getPagecreateTask(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load createTask page success!");
		return "createTask";
	}

	@RequestMapping(value = "/uploadAigTicket", method = { RequestMethod.GET })
	public String getPageUploadAigTicket(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load upload aig ticket page success!");
		return "aig-ticket-upload";
	}

	@RequestMapping(value = "/aigTicket", method = { RequestMethod.GET })
	public String getPageAigTicket(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load createTask page success!");
		return "aig-ticket";
	}

	@RequestMapping(value = "/aigTimesheet", method = { RequestMethod.GET })
	public String getPageAigTimesheet(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load createTask page success!");
		return "aig-timesheet";
	}
	
	@RequestMapping(value = "/monthTimesheetSummary", method = { RequestMethod.GET })
	public String getPagemonthTimesheetSummary(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load month timesheet summary page success!");
		return "aig-timesheetMonthDetail";
	}

	@RequestMapping(value = "/ticketReport", method = { RequestMethod.GET })
	public String getPageTicketReport(HttpServletRequest request, HttpServletResponse response) {
		logger.info("load ticket report page success!");
		return "aig-ticket-report";
	}
}