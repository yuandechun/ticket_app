package com.pms.ticketReport.service.impl;

import com.pms.aigticketmanage.pojo.AigTicket;
import com.pms.aigticketmanage.service.AigTicketService;
import com.pms.ticketReport.pojo.TicketReport;
import com.pms.ticketReport.pojo.TicketReportForm;
import com.pms.ticketReport.service.TicketReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TicketReportServiceImpl implements TicketReportService {
    @Autowired
    private AigTicketService aigTicketService;

    @Override
    public List<TicketReport> loadTicketReport(TicketReportForm ticketReportForm) {
        List<AigTicket> aigTicketList = aigTicketService.loadAllAigTicket(new AigTicket());
        return convertTicketList(ticketReportForm, aigTicketList);
    }

    /****
     * convert ticket to report
     * @param aigTicketList
     * @return
     */
    public List<TicketReport> convertTicketList(TicketReportForm ticketReportForm, List<AigTicket> aigTicketList) {
        /**
         * remove dont't match  application data
         */
        if (ticketReportForm.getApplicationType() !=null) {
            Iterator<AigTicket> it = aigTicketList.iterator();
            while (it.hasNext()) {
                AigTicket ticket = it.next();
                if (!ticketReportForm.getApplicationType().equals(ticket.getApplication())){
                    it.remove();
                }
            }
        }

        List<TicketReport> ticketReportList = new ArrayList<>();
        LocalDate beginTime = LocalDate.of(Integer.parseInt(ticketReportForm.getYear()), Integer.parseInt(ticketReportForm.getMonth()), 1);
        for (int i = 0; i < Integer.parseInt(ticketReportForm.getMonthCount()); i++) {
            TicketReport ticketReport = new TicketReport();
            LocalDate localDate = beginTime.plusMonths(-i);
            this.countTicet(ticketReport, localDate, aigTicketList);
            ticketReportList.add(ticketReport);
        }
        return ticketReportList;
    }


    public void countTicet(TicketReport ticketReport, LocalDate localDate, List<AigTicket> aigTicketList) {
        String month = localDate.format(DateTimeFormatter.ofPattern("YYYY-MM"));
        LocalDate monthLastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        ticketReport.setMonth(month);
        int createCount = 0;
        int closeCount = 0;
        int assignCount = 0;
        int resolveCount = 0;
        int openCount = 0;
        int wipCount = 0;
        for (AigTicket aigTicket : aigTicketList) {
            if (aigTicket.getSubmission_date() != null && month.equals(date2String(aigTicket.getSubmission_date()))) {
                createCount++;
            }
            if (aigTicket.getClose_date() != null && month.equals(date2String(aigTicket.getClose_date()))) {
                closeCount++;
            }
            if (aigTicket.getAssign_dev_team_date() != null && month.equals(date2String(aigTicket.getAssign_dev_team_date()))) {
                assignCount++;
            }
            if (aigTicket.getDev_resolved_time() != null && month.equals(date2String(aigTicket.getDev_resolved_time()))) {
                resolveCount++;
            }
            LocalDate submissionDate = date2LocalDate(aigTicket.getSubmission_date());
            LocalDate closeDate1 = date2LocalDate(aigTicket.getClose_date());
            Boolean openA = monthLastDay.isAfter(submissionDate)
                    || monthLastDay.isEqual(submissionDate);
            Boolean openB = (aigTicket.getClose_date() != null && monthLastDay.isBefore(closeDate1))
                    || aigTicket.getClose_date() == null;
            if (openA && openB) {
                openCount++;
            }
            LocalDate assignDate = date2LocalDate(aigTicket.getAssign_dev_team_date());
            LocalDate devResolvedDate = date2LocalDate(aigTicket.getDev_resolved_time());
            LocalDate sendUatConfirmDate = date2LocalDate(aigTicket.getSend_user_uat_confirm_time());
            LocalDate closeDate = date2LocalDate(aigTicket.getClose_date());
            Boolean wipA = aigTicket.getAssign_dev_team_date() != null && (monthLastDay.isAfter(assignDate) || monthLastDay.isEqual(assignDate));
            Boolean wipB = devResolvedDate.isAfter(monthLastDay);
            Boolean wipC = aigTicket.getDev_resolved_time() == null;
            Boolean wipD = (aigTicket.getSend_user_uat_confirm_time() != null && sendUatConfirmDate.isAfter(monthLastDay))
                    || aigTicket.getSend_user_uat_confirm_time() == null;
            Boolean wipE = aigTicket.getClose_date() == null || (aigTicket.getClose_date() != null && closeDate.isAfter(monthLastDay));
            if ((wipA && wipB) || (wipA && wipC && wipD && wipE)) {
                wipCount++;
            }
        }
        ticketReport.setCreateCount(createCount);
        ticketReport.setCloseCount(closeCount);
        ticketReport.setAssignCount(assignCount);
        ticketReport.setResolveCount(resolveCount);
        ticketReport.setOpenCount(openCount);
        ticketReport.setWipCount(wipCount);

    }

    /****
     * convert date to LocalDate
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            //return null;
            return LocalDate.of(1900, 1, 1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date date1 = formatter.parse(dateString, pos);
        return date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /***
     * date to String
     * @param date
     * @return
     */
    public static String date2String(Date date) {
        if (null == date) {
            return "";
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("YYYY-MM"));
    }
}
