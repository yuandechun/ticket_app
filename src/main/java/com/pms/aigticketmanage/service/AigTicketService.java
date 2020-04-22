package com.pms.aigticketmanage.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.pms.aigticketmanage.pojo.AigTicket;

public interface AigTicketService {

	/****
	 * upload aig ticket excel
	 * 
	 * @param workbook
	 */
	public void uploadTicketExcel(Workbook workbook);

	/***
	 * save aig ticket
	 * 
	 * @param saveAigTicket
	 */
	public void saveAigTicket(AigTicket saveAigTicket);

	/***
	 * save aig ticket list
	 * 
	 * @param
	 */
	public void saveAigTicketList(List<AigTicket> aigTicketList);

	/***
	 * load aig ticket info by ticket no
	 * 
	 * @param
	 * @return
	 */
	public AigTicket loadAigTicketByTicketNo(AigTicket loadAigTicket);

	/******
	 * load aig ticket info by table id
	 * 
	 * @param loadAigTicket
	 * @return
	 */
	public AigTicket loadAigTicketById(AigTicket loadAigTicket);

	/*****
	 * load all aig ticket info
	 * 
	 * @param loadAllAigTicket
	 * @return
	 */
	public List<AigTicket> loadAllAigTicket(AigTicket loadAllAigTicket);

	/******
	 * update aig ticket info by table id
	 * 
	 * @param updateAigTicket
	 */
	public void updateAigTicket(AigTicket updateAigTicket);

	/*****
	 * update aig ticket by upload ticket excel
	 * 
	 * @param updateAigTicketByExcel
	 */
	public void updateAigTicketByExcel(AigTicket updateAigTicketByExcel);

}
