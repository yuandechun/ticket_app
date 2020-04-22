package com.pms.aigTimeSheetSummaryManage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.aigTimeSheetSummaryManage.pojo.AigTimeSheetSummary;
import com.pms.aigTimeSheetSummaryManage.service.AigTimeSheetSummaryService;
import com.pms.aigtimesheetmanage.pojo.AigTimeSheet;
import com.pms.aigtimesheetmanage.service.AigTimeSheetService;
import com.common.usermanage.pojo.SysUser;
import com.common.usermanage.service.SysUserService;

@Service
public class AigTimeSheetSummaryServiceImpl implements AigTimeSheetSummaryService {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private AigTimeSheetService aigTimeSheetService;

	@Override
	public List<AigTimeSheetSummary> loadAigAllSumTimeSheet(AigTimeSheetSummary aigTimeSheetSummary) {
		SysUser sysUser = new SysUser();
		sysUser.setUserName(aigTimeSheetSummary.getUser_name());
		List<SysUser> sysUserList = sysUserService.loadAllSysUser(sysUser);
		AigTimeSheet aigTimeSheet = new AigTimeSheet();
		aigTimeSheet.setUser_name(aigTimeSheetSummary.getUser_name());
		aigTimeSheet.setYear(aigTimeSheetSummary.getYear());
		aigTimeSheet.setMonth(aigTimeSheetSummary.getMonth());
		List<AigTimeSheet> loadAigAllTimeSheet = aigTimeSheetService.loadAigAllTimeSheet(aigTimeSheet);
		return sumTimeSheet(aigTimeSheetSummary, sysUserList, loadAigAllTimeSheet);
	}

	public List<AigTimeSheetSummary> sumTimeSheet(AigTimeSheetSummary queryAigTimeSheetSummary,
			List<SysUser> sysUserList, List<AigTimeSheet> loadAigAllTimeSheet) {
		List<AigTimeSheetSummary> sumTimeSheetList = new ArrayList<>();
		for (int i = 0; i < sysUserList.size(); i++) {
			SysUser sysUser = sysUserList.get(i);
			if (!"admin".equals(sysUser.getUserName())) {
				AigTimeSheetSummary aigTimeSheetSummary = new AigTimeSheetSummary();
				aigTimeSheetSummary.setUser_name(sysUser.getUserName());
				aigTimeSheetSummary.setYear(queryAigTimeSheetSummary.getYear());
				aigTimeSheetSummary.setMonth(queryAigTimeSheetSummary.getMonth());
				int ticket_count = 0;
				double total_timesheet = 0;
				for (int j = 0; j < loadAigAllTimeSheet.size(); j++) {
					AigTimeSheet aigTimeSheet = loadAigAllTimeSheet.get(j);
					double onerowtimesheet = 0;
					if (sysUser.getUserName().equals(aigTimeSheet.getUser_name())) {
						ticket_count++;
						onerowtimesheet = getTotalTimeSheet(aigTimeSheet);
					}
					total_timesheet = total_timesheet + onerowtimesheet;
				}
				aigTimeSheetSummary.setTicket_count(String.valueOf(ticket_count));
				aigTimeSheetSummary.setTotal_timesheet(String.valueOf(total_timesheet));
				sumTimeSheetList.add(aigTimeSheetSummary);
			}
		}
		return sumTimeSheetList;
	}

	public double getTotalTimeSheet(AigTimeSheet aigTimeSheet) {
		double total_timesheet = covStrToDou(aigTimeSheet.getDay1()) + covStrToDou(aigTimeSheet.getDay2())
				+ covStrToDou(aigTimeSheet.getDay3()) + covStrToDou(aigTimeSheet.getDay4())
				+ covStrToDou(aigTimeSheet.getDay5()) + covStrToDou(aigTimeSheet.getDay6())
				+ covStrToDou(aigTimeSheet.getDay7()) + covStrToDou(aigTimeSheet.getDay8())
				+ covStrToDou(aigTimeSheet.getDay9()) + covStrToDou(aigTimeSheet.getDay10())
				+ covStrToDou(aigTimeSheet.getDay11()) + covStrToDou(aigTimeSheet.getDay12())
				+ covStrToDou(aigTimeSheet.getDay13()) + covStrToDou(aigTimeSheet.getDay14())
				+ covStrToDou(aigTimeSheet.getDay15()) + covStrToDou(aigTimeSheet.getDay16())
				+ covStrToDou(aigTimeSheet.getDay17()) + covStrToDou(aigTimeSheet.getDay18())
				+ covStrToDou(aigTimeSheet.getDay19()) + covStrToDou(aigTimeSheet.getDay20())
				+ covStrToDou(aigTimeSheet.getDay21()) + covStrToDou(aigTimeSheet.getDay22())
				+ covStrToDou(aigTimeSheet.getDay23()) + covStrToDou(aigTimeSheet.getDay24())
				+ covStrToDou(aigTimeSheet.getDay25()) + covStrToDou(aigTimeSheet.getDay26())
				+ covStrToDou(aigTimeSheet.getDay27()) + covStrToDou(aigTimeSheet.getDay28())
				+ covStrToDou(aigTimeSheet.getDay29()) + covStrToDou(aigTimeSheet.getDay30())
				+ covStrToDou(aigTimeSheet.getDay31());
		return total_timesheet;
	}

	public double covStrToDou(String object) {
		double resultDouble = 0;
		if (object != null && object.trim() != "") {
			Pattern pattern = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
			Matcher isNum = pattern.matcher(object.trim());
			if (isNum.matches()) {
				try {
					resultDouble = Double.parseDouble(object.trim());
				} catch (NumberFormatException e) {
					resultDouble = 0;
				}
			}
		}
		return resultDouble;
	}
}
