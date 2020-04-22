package com.pms.ticketReport.service;

import com.pms.ticketReport.pojo.TicketReport;
import com.pms.ticketReport.pojo.TicketReportForm;

import java.util.List;

public interface TicketReportService {

    /***
     * query ticket report
     * @param ticketReportForm
     * @return
     */
    List<TicketReport> loadTicketReport(TicketReportForm ticketReportForm);
}
