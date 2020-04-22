package com.pms.aigTimeSheetSummaryManage.service;

import java.util.List;

import com.pms.aigTimeSheetSummaryManage.pojo.AigTimeSheetSummary;

public interface AigTimeSheetSummaryService {
	
	public List<AigTimeSheetSummary> loadAigAllSumTimeSheet(AigTimeSheetSummary aigTimeSheetSummary);
}
