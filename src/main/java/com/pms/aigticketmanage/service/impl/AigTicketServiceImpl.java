package com.pms.aigticketmanage.service.impl;

import com.core.utils.ConvertUtils;
import com.pms.aigticketmanage.pojo.AigTicket;
import com.pms.aigticketmanage.repository.AigTicketRepository;
import com.pms.aigticketmanage.service.AigTicketService;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AigTicketServiceImpl implements AigTicketService {
    private Logger logger = LoggerFactory.getLogger(AigTicketServiceImpl.class);

    @Autowired
    private AigTicketRepository aigTicketRepository;


    @Override
    public void uploadTicketExcel(Workbook workbook) {

        Sheet aigTicketSheet = workbook.getSheet("ExportData");
        List<AigTicket> aigTicketList = new ArrayList<>();

        /***
         * get sheet data
         */
        if (aigTicketSheet != null) {
            // policy 总行数
            int rowNum = aigTicketSheet.getLastRowNum();
            Row row = null;
            // 正文内容应该从第二行开始,第一行为表头的标题
            for (int i = 1; i <= rowNum; i++) {
                row = aigTicketSheet.getRow(i);
                // 每行生成insured对象，然后加入到list中去
                aigTicketList.add(this.getAigTicket(row));
            }
            // save aig ticket to db
            // this.saveAigTicketList(aigTicketList);
            for (AigTicket aigTicket : aigTicketList) {
                this.saveAigTicket(aigTicket);
            }
            logger.info("save aig ticket success!");
        }

    }

    @Override
    public void saveAigTicket(AigTicket saveAigTicket) {
        if (saveAigTicket != null && saveAigTicket.getApplication_no() != null
                && !"".equals(saveAigTicket.getApplication_no().trim())) {
            AigTicket queryTicket = this.loadAigTicketByTicketNo(saveAigTicket);
            if (queryTicket != null) {
                try {
                    //delete
                    aigTicketRepository.deleteAigTicket(saveAigTicket);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            // save
            try {
                aigTicketRepository.saveAigTicket(saveAigTicket);
            } catch (Exception e) {
                System.out.println(e);
            }
            //else {
            // update
            //aigTicketRepository.updateAigTicketByExcel(saveAigTicket);
            //}
        }
    }

    @Override
    public void saveAigTicketList(List<AigTicket> aigTicketList) {
        aigTicketRepository.saveAigTicketList(aigTicketList);
    }

    @Override
    public AigTicket loadAigTicketByTicketNo(AigTicket loadAigTicket) {
        return aigTicketRepository.loadAigTicketByTicketNo(loadAigTicket);
    }

    @Override
    public AigTicket loadAigTicketById(AigTicket loadAigTicket) {
        return aigTicketRepository.loadAigTicketById(loadAigTicket);
    }

    @Override
    public List<AigTicket> loadAllAigTicket(AigTicket loadAllAigTicket) {
        return aigTicketRepository.loadAllAigTicket(loadAllAigTicket);
    }

    @Override
    public void updateAigTicket(AigTicket updateAigTicket) {
        aigTicketRepository.updateAigTicket(updateAigTicket);
    }

    @Override
    public void updateAigTicketByExcel(AigTicket updateAigTicketByExcel) {
        aigTicketRepository.updateAigTicketByExcel(updateAigTicketByExcel);
    }

    public AigTicket getAigTicket(Row row) {
        AigTicket aigTicket = new AigTicket();

        // private String application;
        String application = getCellFormatValue(row.getCell(0)).toString();
        aigTicket.setApplication(application);

        // private String application_no;
        String application_no = getCellFormatValue(row.getCell(1)).toString();
        aigTicket.setApplication_no(application_no);

        // private String profit_center;
        String profit_center = getCellFormatValue(row.getCell(2)).toString();
        aigTicket.setProfit_center(profit_center);

        // private String issue_description;
        String issue_description = getCellFormatValue(row.getCell(3)).toString();
        aigTicket.setIssue_description(issue_description);

        // private String applicant_name;
        String applicant_name = getCellFormatValue(row.getCell(4)).toString();
        aigTicket.setApplicant_name(applicant_name);

        // private String lOB;
        String lOB = getCellFormatValue(row.getCell(5)).toString();
        aigTicket.setlOB(lOB);

        // private String change_type;
        String change_type = getCellFormatValue(row.getCell(6)).toString();
        aigTicket.setChange_type(change_type);

        // private String code_change;
        String code_change = getCellFormatValue(row.getCell(7)).toString();
        aigTicket.setCode_change(code_change);

        // private String branch;
        String branch = getCellFormatValue(row.getCell(8)).toString();
        aigTicket.setBranch(branch);

        // private String department;
        String department = getCellFormatValue(row.getCell(9)).toString();
        aigTicket.setDepartment(department);

        // private Date submission_date;
        Date submission_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(10)));
        aigTicket.setSubmission_date(submission_date);

        // private String pending_MthOrYr;
        String pending_MthOrYr = getCellFormatValue(row.getCell(11)).toString();
        aigTicket.setPending_MthOrYr(pending_MthOrYr);

        // private String request_type;
        String request_type = getCellFormatValue(row.getCell(12)).toString();
        aigTicket.setRequest_type(request_type);

        // private String sub_type;
        String sub_type = getCellFormatValue(row.getCell(13)).toString();
        aigTicket.setSub_type(sub_type);

        // private String priority;
        String priority = getCellFormatValue(row.getCell(14)).toString();
        aigTicket.setPriority(priority);

        // private int severity;
        int severity = ConvertUtils.covertObjectToInt(getCellFormatValue(row.getCell(15)));
        aigTicket.setSeverity(severity);

        // private String team_in_charge;
        String team_in_charge = getCellFormatValue(row.getCell(16)).toString();
        aigTicket.setTeam_in_charge(team_in_charge);

        // private Date assign_dev_team_date;
        Date assign_dev_team_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(17)));
        aigTicket.setAssign_dev_team_date(assign_dev_team_date);

        // private String ba_in_charge;
        String ba_in_charge = getCellFormatValue(row.getCell(18)).toString();
        aigTicket.setBa_in_charge(ba_in_charge);

        // private String data_owner_id;
        String data_owner_id = getCellFormatValue(row.getCell(19)).toString();
        aigTicket.setData_owner_id(data_owner_id);

        // private String developer;
        String developer = getCellFormatValue(row.getCell(20)).toString();
        aigTicket.setDeveloper(developer);

        // private Date send_dev_team_for__estimation_time;
        Date send_dev_team_for__estimation_time = ConvertUtils
                .covertObjectToDate(getCellFormatValue(row.getCell(21)));
        aigTicket.setSend_dev_team_for__estimation_time(send_dev_team_for__estimation_time);

        // private Date send_estimation_to_BA_team_time;
        Date send_estimation_to_BA_team_time = ConvertUtils
                .covertObjectToDate(getCellFormatValue(row.getCell(22)));
        aigTicket.setSend_estimation_to_BA_team_time(send_estimation_to_BA_team_time);

        // private double estimated_effort;
        double estimated_effort = ConvertUtils.covertObjectToDouble(getCellFormatValue(row.getCell(23)));
        aigTicket.setEstimated_effort(estimated_effort);

        // private double actual_effort;
        double actual_effort = ConvertUtils.covertObjectToDouble(getCellFormatValue(row.getCell(24)));
        aigTicket.setActual_effort(actual_effort);

        // private String test_results;
        String test_results = getCellFormatValue(row.getCell(25)).toString();
        aigTicket.setTest_results(test_results);

        // private Date target_delivery_date;
        Date target_delivery_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(26)));
        aigTicket.setTarget_delivery_date(target_delivery_date);

        // private String status;
        String status = getCellFormatValue(row.getCell(27)).toString();
        aigTicket.setStatus(status);

        // private Date close_date;
        Date close_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(28)));
        aigTicket.setClose_date(close_date);

        // private String build_no;
        String build_no = getCellFormatValue(row.getCell(29)).toString();
        aigTicket.setBuild_no(build_no);

        // private Date build_release_date;
        Date build_release_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(30)));
        aigTicket.setBuild_release_date(build_release_date);

        // private String build_status;
        String build_status = getCellFormatValue(row.getCell(31)).toString();
        aigTicket.setBuild_status(build_status);

        // private String pot_review;
        String pot_review = getCellFormatValue(row.getCell(32)).toString();
        aigTicket.setPot_review(pot_review);

        // private String pss_for_uat;
        String pss_for_uat = getCellFormatValue(row.getCell(33)).toString();
        aigTicket.setPss_for_uat(pss_for_uat);

        // private Date uat_date;
        Date uat_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(34)));
        aigTicket.setUat_date(uat_date);

        // private String uat_status;
        String uat_status = getCellFormatValue(row.getCell(35)).toString();
        aigTicket.setUat_status(uat_status);

        // private String pss_for_prod;
        String pss_for_prod = getCellFormatValue(row.getCell(36)).toString();
        aigTicket.setPss_for_prod(pss_for_prod);

        // private Date production_date;
        Date production_date = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(37)));
        aigTicket.setProduction_date(production_date);

        // private String production_status;
        String production_status = getCellFormatValue(row.getCell(38)).toString();
        aigTicket.setProduction_status(production_status);

        // private String solution;
        String solution = getCellFormatValue(row.getCell(39)).toString();
        aigTicket.setSolution(solution);

        // private String comments;
        String comments = getCellFormatValue(row.getCell(40)).toString();
        aigTicket.setComments(comments);

        // private Date supervisor_approved_time;
        Date supervisor_approved_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(41)));
        aigTicket.setSupervisor_approved_time(supervisor_approved_time);

        // private Date it_manager_approved_time;
        Date it_manager_approved_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(42)));
        aigTicket.setIt_manager_approved_time(it_manager_approved_time);

        // private Date data_owner_approved_time;
        Date data_owner_approved_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(43)));
        aigTicket.setData_owner_approved_time(data_owner_approved_time);

        // private Date dev_resolved_time;
        Date dev_resolved_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(44)));
        aigTicket.setDev_resolved_time(dev_resolved_time);

        // private Date send_user_uat_confirm_time;
        Date send_user_uat_confirm_time = ConvertUtils
                .covertObjectToDate(getCellFormatValue(row.getCell(45)));
        aigTicket.setSend_user_uat_confirm_time(send_user_uat_confirm_time);

        // private Date user_uat_confirmed_time;
        Date user_uat_confirmed_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(46)));
        aigTicket.setUser_uat_confirmed_time(user_uat_confirmed_time);

        // private Date ba_resolved_time;
        Date ba_resolved_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(47)));
        aigTicket.setBa_resolved_time(ba_resolved_time);

        // private Date send_user_prod_confirm_time;
        Date send_user_prod_confirm_time = ConvertUtils
                .covertObjectToDate(getCellFormatValue(row.getCell(48)));
        aigTicket.setSend_user_prod_confirm_time(send_user_prod_confirm_time);

        // private Date ba_send_acknowledge_time;
        Date ba_send_acknowledge_time = ConvertUtils.covertObjectToDate(getCellFormatValue(row.getCell(49)));
        aigTicket.setBa_send_acknowledge_time(ba_send_acknowledge_time);

        // private Date dev_send_acknowledge_time;
        Date dev_send_acknowledge_time = ConvertUtils
                .covertObjectToDate(getCellFormatValue(row.getCell(50)));
        aigTicket.setDev_send_acknowledge_time(dev_send_acknowledge_time);

        // private String survey_results;
        String survey_results = getCellFormatValue(row.getCell(51)).toString();
        aigTicket.setSurvey_results(survey_results);

        // private String survey_remarks;
        String survey_remarks = getCellFormatValue(row.getCell(52)).toString();
        aigTicket.setSurvey_remarks(survey_remarks);

        // private String edit;
        String edit = getCellFormatValue(row.getCell(53)).toString();
        aigTicket.setEdit(edit);

        return aigTicket;
    }


    // 根据Cell类型设置数据
    @SuppressWarnings({"deprecation"})
    public static Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                case Cell.CELL_TYPE_FORMULA: {
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellvalue = date;
                    } else {
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:
                    cellvalue = cell.getRichStringCellValue().getString().trim();
                    break;
                default:
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
}
