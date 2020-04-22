package com.pms.aigTimeSheetSummaryManage.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.pms.aigtimesheetmanage.pojo.AigTimeSheet;

@Mapper
public interface AigTimeSheetSummaryRepository {

	/****
	 * create aig time sheet
	 * 
	 * @param saveAigTimeSheet
	 */
	public void saveAigTimeSheet(AigTimeSheet saveAigTimeSheet);

	/***
	 * load all user time sheet
	 * 
	 * @param
	 * @return
	 */
	public List<AigTimeSheet> loadAigAllTimeSheet(AigTimeSheet loadAigTimeSheet);

	/***
	 * delete aig timesheet by table id
	 * 
	 * @param deleteAigTimeSheet
	 */
	public void deleteAigTimesheet(AigTimeSheet deleteAigTimeSheet);

	/***
	 * load aig time sheet by table id
	 * 
	 * @param loadAigTimeSheet
	 * @return
	 */
	public AigTimeSheet loadAigTimeSheetById(AigTimeSheet loadAigTimeSheet);

	/****
	 * load aig time sheet by ticket no
	 * 
	 * @param loadAigTimeSheet
	 * @return
	 */
	public AigTimeSheet loadAigTimeSheetByTicketNo(AigTimeSheet loadAigTimeSheet);

	/****
	 * update aig time sheet
	 * 
	 * @param updateAigTimeSheet
	 */
	public void updateAigTimeSheet(AigTimeSheet updateAigTimeSheet);

}
