package com.core.excel.service;

import com.core.excel.pojo.ExcelData;

public interface ExcelService {

    /***
     * get excel data by sql
     * @param sql
     * @return
     */
    public ExcelData getExcelDataBySql(String sql);


}
