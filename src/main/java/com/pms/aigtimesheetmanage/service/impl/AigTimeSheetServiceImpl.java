package com.pms.aigtimesheetmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.aigtimesheetmanage.pojo.AigTimeSheet;
import com.pms.aigtimesheetmanage.repository.AigTimeSheetRepository;
import com.pms.aigtimesheetmanage.service.AigTimeSheetService;

@Service
public class AigTimeSheetServiceImpl implements AigTimeSheetService {
	private Logger logger = LoggerFactory.getLogger(AigTimeSheetServiceImpl.class);

	@Autowired
	private AigTimeSheetRepository aigTimeSheetRepository;

	@Override
	public void saveAigTimeSheet(AigTimeSheet saveAigTimeSheet) {
		if (saveAigTimeSheet != null) {
			initAigTimeSheetPar(saveAigTimeSheet);
			AigTimeSheet queryAigTimesheet = aigTimeSheetRepository.loadAigTimeSheetByTicketNo(saveAigTimeSheet);
			if (queryAigTimesheet != null) {
				// update
				aigTimeSheetRepository.updateAigTimeSheet(saveAigTimeSheet);
			} else {
				// insert
				aigTimeSheetRepository.saveAigTimeSheet(saveAigTimeSheet);
			}
		} else {
			logger.error("Time sheet can not be null!");
		}
	}

	@Override
	public List<AigTimeSheet> loadAigAllTimeSheet(AigTimeSheet loadAigTimeSheet) {
		return aigTimeSheetRepository.loadAigAllTimeSheet(loadAigTimeSheet);
	}

	@Override
	public void deleteAigTimesheet(AigTimeSheet deleteAigTimeSheet) {
		aigTimeSheetRepository.deleteAigTimesheet(deleteAigTimeSheet);
	}

	@Override
	public AigTimeSheet loadAigTimeSheetByTicketNo(AigTimeSheet loadAigTimeSheet) {
		return aigTimeSheetRepository.loadAigTimeSheetByTicketNo(loadAigTimeSheet);
	}

	@Override
	public AigTimeSheet loadAigTimeSheetById(AigTimeSheet loadAigTimeSheet) {
		return aigTimeSheetRepository.loadAigTimeSheetById(loadAigTimeSheet);
	}

	@Override
	public void updateAigTimeSheet(AigTimeSheet updateAigTimeSheet) {
		initAigTimeSheetPar(updateAigTimeSheet);
		aigTimeSheetRepository.updateAigTimeSheet(updateAigTimeSheet);
	}

	public void initAigTimeSheetPar(AigTimeSheet aigTimeSheet) {
		//aigTimeSheet.setUser_name("admin");
		//aigTimeSheet.setCreated_by("admin");
		aigTimeSheet.setCreated_date(new Date());
		//aigTimeSheet.setUpdate_by("admin");
		aigTimeSheet.setUpdate_date(new Date());
	}
}
