package com.pms.ticketReport.controller;

import com.core.controller.BaseController;
import com.core.data.result.ResultBootstrapTable;
import com.core.data.result.ResultBootstrapTableUtil;
//import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.ticketReport.pojo.TicketReport;
import com.pms.ticketReport.pojo.TicketReportForm;
import com.pms.ticketReport.service.TicketReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/aig/report")
public class TicketReportController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(TicketReportController.class);

    @Autowired
    private TicketReportService ticketReportService;

    @PostMapping("/load")
    @ResponseBody
    public ResultBootstrapTable loadTicketReport(HttpServletRequest request, HttpServletResponse response,
                                                 TicketReportForm ticketReportForm, Integer pageSize, Integer pageNumber) {
        List<TicketReport> ticketReportList = null;
        PageInfo<TicketReport> pageInfo = null;
        try {
            // 1、设置分页信息，包括当前页数和每页显示的总计数
            //PageHelper.startPage(pageNumber == null ? 1 : pageNumber, pageSize == null ? 10 : pageSize);
            // 2、执行查询
            LocalDate today = LocalDate.now();
            int year = today.getYear();
            int month = today.getMonthValue();
            if (ticketReportForm.getYear() == null || "请选择年份".equals(ticketReportForm.getYear())) {
                ticketReportForm.setYear(String.valueOf(year));
            }
            if (ticketReportForm.getMonth() == null || "请选择月份".equals(ticketReportForm.getMonth())) {
                ticketReportForm.setMonth(String.valueOf(month));
            }
            if (ticketReportForm.getMonthCount() == null || "请选择数据区间".equals(ticketReportForm.getMonthCount())) {
                ticketReportForm.setMonthCount("12");
            }
            if (ticketReportForm.getApplicationType() == null || "请选择系统类型".equals(ticketReportForm.getApplicationType())) {
                ticketReportForm.setApplicationType(null);
            }

            ticketReportList = ticketReportService.loadTicketReport(ticketReportForm);
            // 3、获取分页查询后的数据
            pageInfo = new PageInfo<>(ticketReportList);
            logger.info("query ticket report success!");
        } catch (Exception e) {
            logger.error("query ticket report fail!");
            e.printStackTrace();
        }
        // 4.设置获取到的总记录数total
        Long count = 0L;
        if (pageInfo != null) {
            count = pageInfo.getTotal();
        }
        return ResultBootstrapTableUtil.success(count, ticketReportList);
    }
}
