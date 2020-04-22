package com.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertUtils {

    /***
     * object covert int
     */
    public static int covertObjectToInt(Object object) {
        int resultInt = 0;
        if (object != null && ((String) object).trim() != "") {
            try {
                resultInt = Integer.parseInt(((String) object).trim());
            } catch (NumberFormatException e) {
                try {
                    Double resultDouble = Double.valueOf(((String) object).trim());
                    resultInt = resultDouble.intValue();
                } catch (NumberFormatException e1) {
                    resultInt = 0;
                }
            }
        }
        return resultInt;
    }

    /***
     * object covert double
     */
    public static Double covertObjectToDouble(Object object) {
        Double resultDouble = 0.00;
        if (object != null && ((String) object).trim() != "") {
            Pattern pattern = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])");
            Matcher isNum = pattern.matcher(((String) object).trim());
            if (isNum.matches()) {
                try {
                    resultDouble = Double.parseDouble(((String) object).trim());
                } catch (NumberFormatException e) {
                    resultDouble = 0.00;
                }
            }
        }
        return resultDouble;
    }

    /***
     * object covert date
     */
    public static Date covertObjectToDate(Object object) {
        Date resultDate = new Date();
        if (object != null && !object.toString().trim().equals("")) {
            try {
                resultDate = (Date) object;
            } catch (Exception e) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    resultDate = format.parse(object.toString());
                } catch (ParseException e2) {
                    try {
                        String convertDate = object.toString();
                        if (convertDate.contains("上午")) {
                            convertDate = convertDate.replace("上午", "上午 ");
                        } else if (convertDate.contains("下午")) {
                            convertDate = convertDate.replace("下午", "下午 ");
                        }
                        resultDate = format.parse(DateUtils.aigTicketConvertDate(convertDate));
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        } else {
            resultDate = null;
        }
        return resultDate;
    }

}
