package com.pms.aigticketmanage.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.usermodel.Workbook;
import com.pms.aigticketmanage.pojo.AigTicket;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@Mapper
//@CacheConfig(cacheNames = "ticket")
public interface AigTicketRepository {

    /****
     * upload aig ticket excel
     *
     * @param workbook
     */
    public void uploadTicketExcel(Workbook workbook);

    /***
     * save aig ticket info list
     *
     * @param
     */
    public void saveAigTicketList(List<AigTicket> aigTicketList);

    /*****
     * save aig ticket info
     *
     * @param saveAigTicket
     */
    public void saveAigTicket(AigTicket saveAigTicket);

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


    /****
     * delete aig ticket by application no
     * @param
     */
    public void deleteAigTicket(AigTicket updateAigTicket);

}
