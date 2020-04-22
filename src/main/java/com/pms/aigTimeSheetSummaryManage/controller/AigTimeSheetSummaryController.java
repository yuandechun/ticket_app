package com.pms.aigTimeSheetSummaryManage.controller;

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
import com.core.data.result.ResultBootstrapTable;
import com.core.data.result.ResultBootstrapTableUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.aigTimeSheetSummaryManage.pojo.AigTimeSheetSummary;
import com.pms.aigTimeSheetSummaryManage.service.AigTimeSheetSummaryService;
import com.pms.aigtimesheetmanage.pojo.AigTimeSheet;

@Controller
@RequestMapping("/aig/timesheet/summary")
public class AigTimeSheetSummaryController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(AigTimeSheetSummaryController.class);

	@Autowired
	private AigTimeSheetSummaryService aigTimeSheetSummaryService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/load")
	@ResponseBody
	public ResultBootstrapTable loadAllAigTimeSheet(HttpServletRequest request, HttpServletResponse response,
			AigTimeSheetSummary loadAigTimeSheetSummary, Integer pageSize, Integer pageNumber) {
		List<AigTimeSheetSummary> aigSummaryTimeSheetList = null;
		PageInfo<AigTimeSheetSummary> pageInfo = null;
		try {
			// 1、设置分页信息，包括当前页数和每页显示的总计数
			PageHelper.startPage(pageNumber == null ? 1 : pageNumber, pageSize == null ? 10 : pageSize);
			// 2、执行查询
			LocalDate today = LocalDate.now();
			int year = today.getYear();
			int month = today.getMonthValue();
			if (loadAigTimeSheetSummary.getYear() == null || "请选择年份".equals(loadAigTimeSheetSummary.getYear())) {
				loadAigTimeSheetSummary.setYear(String.valueOf(year));
			}
			if (loadAigTimeSheetSummary.getMonth() == null || "请选择月份".equals(loadAigTimeSheetSummary.getMonth())) {
				loadAigTimeSheetSummary.setMonth(String.valueOf(month));
			}
			aigSummaryTimeSheetList = aigTimeSheetSummaryService.loadAigAllSumTimeSheet(loadAigTimeSheetSummary);
			// 3、获取分页查询后的数据
			pageInfo = new PageInfo<>(aigSummaryTimeSheetList);
			logger.info("query aig summary timesheet success!");
		} catch (Exception e) {
			logger.error("query aig summary timesheet fail!");
			e.printStackTrace();
		}
		// 4.设置获取到的总记录数total
		Long sysUserCount = 0L;
		if (pageInfo != null) {
			sysUserCount = pageInfo.getTotal();
		}
		return ResultBootstrapTableUtil.success(sysUserCount, aigSummaryTimeSheetList);
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
