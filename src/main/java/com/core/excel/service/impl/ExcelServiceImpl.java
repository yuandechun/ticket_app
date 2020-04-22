package com.core.excel.service.impl;

import com.core.excel.pojo.ExcelData;
import com.core.excel.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /***
     * get excel data by sql
     * @param sql
     * @return
     */
    @Override
    public ExcelData getExcelDataBySql(String sql) {
        ExcelData excelData = new ExcelData();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        if (result == null || result.size() == 0) {
            return null;
        } else {
            List<String> titles = new ArrayList<String>(result.get(0).keySet());
            List<List<Object>> rows = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                List<Object> values = new ArrayList<Object>(result.get(i).values());
                rows.add(values);
            }
            excelData.setTitles(titles);
            excelData.setRows(rows);
        }
        return excelData;
    }
}
