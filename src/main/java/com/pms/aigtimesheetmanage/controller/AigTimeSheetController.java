package com.pms.aigtimesheetmanage.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.controller.BaseController;
import com.core.data.result.Result;
import com.core.data.result.ResultBootstrapTable;
import com.core.data.result.ResultBootstrapTableUtil;
import com.core.data.result.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.aigtimesheetmanage.pojo.AigTimeSheet;
import com.pms.aigtimesheetmanage.service.AigTimeSheetService;

@Controller
@RequestMapping("/aig/timesheet")
public class AigTimeSheetController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(AigTimeSheetController.class);

	@Autowired
	private AigTimeSheetService aigTimeSheetService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/load")
	@ResponseBody
	public ResultBootstrapTable loadAllAigTimeSheet(HttpServletRequest request, HttpServletResponse response,
			AigTimeSheet loadAigTimeSheet, Integer pageSize, Integer pageNumber) {
		List<AigTimeSheet> aigTimeSheetList = null;
		PageInfo<AigTimeSheet> pageInfo = null;
		try {
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNumber == null ? 1 : pageNumber, pageSize == null ? 10 : pageSize);
			// 2、执行查询
			aigTimeSheetList = aigTimeSheetService.loadAigAllTimeSheet(loadAigTimeSheet);
			// 3、获取分页查询后的数据
			pageInfo = new PageInfo<>(aigTimeSheetList);
			logger.info("query all aig timesheet success!");
		} catch (Exception e) {
			logger.error("query all aig timesheet fail!");
			e.printStackTrace();
		}
		// 4.设置获取到的总记录数total
		Long sysUserCount = 0L;
		if (pageInfo != null) {
			sysUserCount = pageInfo.getTotal();
		}
		return ResultBootstrapTableUtil.success(sysUserCount, aigTimeSheetList);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/save")
	@ResponseBody
	public Result uploadTicketExcel(HttpServletRequest request, HttpServletResponse response,
			AigTimeSheet saveAigTimeSheet) {
		try {
			String user_name = (String) request.getSession().getAttribute("user_name");
			saveAigTimeSheet.setUser_name(user_name);
			saveAigTimeSheet.setCreated_by(user_name);
			saveAigTimeSheet.setUpdate_by(user_name);
			aigTimeSheetService.saveAigTimeSheet(saveAigTimeSheet);
			logger.info("save aig timesheet success!");
		} catch (Exception e) {
			logger.error("save aig timesheet fail!");
			e.printStackTrace();
		}
		return ResultUtil.success();
	}

	/****
	 * delete aig timesheet by table id
	 * 
	 * @param request
	 * @param response
	 * @param
	 */
	@PostMapping("/delete")
	public void deleteAigTimesheet(HttpServletRequest request, HttpServletResponse response,
			AigTimeSheet deleteAigTimeSheet) {
		try {
			// 执行删除
			aigTimeSheetService.deleteAigTimesheet(deleteAigTimeSheet);
			logger.info("delete aig timesheet success!");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("delete aig timesheet error!");
			e.printStackTrace();
		}

	}

	/****
	 * 
	 * @param request
	 * @param response
	 * @param loadAigTimeSheetDetail
	 * @return
	 */
	@PostMapping("/loadDetail")
	@ResponseBody
	public ResultBootstrapTable<?> loadAigTimesheetById(HttpServletRequest request, HttpServletResponse response,
			AigTimeSheet loadAigTimeSheetDetail) {
		AigTimeSheet aigTimeSheetDetail = null;
		Long total = 1L;
		try {
			// 执行查询
			aigTimeSheetDetail = aigTimeSheetService.loadAigTimeSheetById(loadAigTimeSheetDetail);
			logger.info("query aig time sheet success!");
		} catch (Exception e) {
			logger.error("query aig time sheet fail!");
			e.printStackTrace();
		}
		// 2.设置获取到的总记录数total
		return ResultBootstrapTableUtil.success(total, aigTimeSheetDetail);
	}

	/****
	 * 
	 * @param request
	 * @param response
	 * @param updateAigTimeSheet
	 */
	@PostMapping("/update")
	public void updateAigTimesheet(HttpServletRequest request, HttpServletResponse response,
			AigTimeSheet updateAigTimeSheet) {
		try {
			String user_name = (String) request.getSession().getAttribute("user_name");
			updateAigTimeSheet.setCreated_by(user_name);
			updateAigTimeSheet.setUpdate_by(user_name);
			// 1、执行更新
			aigTimeSheetService.updateAigTimeSheet(updateAigTimeSheet);
			logger.info("edit aig time sheet success!");
		} catch (Exception e) {
			logger.error("edit aig time sheet fail!");
			e.printStackTrace();
		}
	}

	@PostMapping("/initAddParameter")
	@ResponseBody
	public ResultBootstrapTable<?> loadInitAddParameter(HttpServletRequest request, HttpServletResponse response) {
		AigTimeSheet AigTimeSheetDetail = new AigTimeSheet();
		Long total = 1L;
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		// int day = today.getDayOfMonth();
		AigTimeSheetDetail.setYear(String.valueOf(year));
		AigTimeSheetDetail.setMonth(String.valueOf(month));
		// 2.设置获取到的总记录数total
		return ResultBootstrapTableUtil.success(total, AigTimeSheetDetail);
	}

}
