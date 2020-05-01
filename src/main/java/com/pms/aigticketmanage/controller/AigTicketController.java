package com.pms.aigticketmanage.controller;

import com.core.controller.BaseController;
import com.core.data.result.Result;
import com.core.data.result.ResultBootstrapTable;
import com.core.data.result.ResultBootstrapTableUtil;
import com.core.data.result.ResultUtil;
import com.core.excel.ExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pms.aigticketmanage.pojo.AigTicket;
import com.pms.aigticketmanage.service.AigTicketService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/aig/ticket")
public class AigTicketController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(AigTicketController.class);

    @Autowired
    private AigTicketService aigTicketService;

    
    @PostMapping("/upload/excel")
    @ResponseBody
    public Result uploadTicketExcel(@RequestParam("file") MultipartFile file) {
        if (file != null) {
            Workbook workbook = null;
            try {
                String fileName = file.getOriginalFilename();
                InputStream inputStream = file.getInputStream(); // 通过对象多态性，进行实例化
                // 获取workbook对象
                workbook = ExcelUtils.getWorkbook(inputStream, fileName);
                if (inputStream != null) {
                    inputStream.close(); // 关闭输出流
                }
                // 解析excel数据
                aigTicketService.uploadTicketExcel(workbook);
                logger.info("upload aig ticket success!");
            } catch (Exception e) {
                logger.info("upload aig ticket fail!");
                e.printStackTrace();
            }
        }
        return ResultUtil.success();
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/load")
    @ResponseBody
    public ResultBootstrapTable loadAllAigTicket(HttpServletRequest request, HttpServletResponse response,
                                                 AigTicket queryAigTicket, Integer pageSize, Integer pageNumber) {
        List<AigTicket> ticketList = null;
        PageInfo<AigTicket> pageInfo = null;
        try {
            // 1、设置分页信息，包括当前页数和每页显示的总计数
            PageHelper.startPage(pageNumber == null ? 1 : pageNumber, pageSize == null ? 10 : pageSize);
            // 2、执行查询
            ticketList = aigTicketService.loadAllAigTicket(queryAigTicket);
            // 3、获取分页查询后的数据
            pageInfo = new PageInfo<>(ticketList);
            logger.info("query all aig ticket success!");
        } catch (Exception e) {
            logger.error("query all aig ticket fail!");
            e.printStackTrace();
        }
        // 4.设置获取到的总记录数total
        Long sysUserCount = 0L;
        if (pageInfo != null) {
            sysUserCount = pageInfo.getTotal();
        }
        return ResultBootstrapTableUtil.success(sysUserCount, ticketList);
    }

    @PostMapping("/loadDetail")
    @ResponseBody
    public ResultBootstrapTable<?> loadAigTicketById(HttpServletRequest request, HttpServletResponse response,
                                                     AigTicket loadAigTicketDetail) {
        AigTicket aigTicketDetail = null;
        Long total = 1L;
        try {
            // 执行查询
            aigTicketDetail = aigTicketService.loadAigTicketById(loadAigTicketDetail);
            logger.info("query aig ticket detail success!");
        } catch (Exception e) {
            logger.error("query aig ticket detail fail!");
            e.printStackTrace();
        }
        // 2.设置获取到的总记录数total
        return ResultBootstrapTableUtil.success(total, aigTicketDetail);
    }

    @PostMapping("/update")
    public void updateSysUser(HttpServletRequest request, HttpServletResponse response, AigTicket updateAigTicket) {
        try {
            // 1、执行更新
            aigTicketService.updateAigTicket(updateAigTicket);
            logger.info("edit aig ticket success!");
        } catch (Exception e) {
            logger.error("edit aig ticket fail!");
            e.printStackTrace();
        }
    }

    @PostMapping("/loadAllAigTicket")
    @ResponseBody
    public List<AigTicket> loadAigTicketNo(HttpServletRequest request, HttpServletResponse response,
                                           AigTicket loadAigTicket) {
        List<AigTicket> aigTicketsList = null;
        try {
            aigTicketsList = aigTicketService.loadAllAigTicket(loadAigTicket);
            Iterator<AigTicket> it = aigTicketsList.iterator();
            while (it.hasNext()) {
                AigTicket x = it.next();
                if ("Closed".equals(x.getStatus())) {
                    it.remove();
                }
            }
            logger.info("load aig ticket no success!");
        } catch (Exception e) {
            logger.info("load aig ticket no fail!");
            e.printStackTrace();
        }
        return aigTicketsList;
    }

}
