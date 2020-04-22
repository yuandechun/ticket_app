package com.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author dechun.yuan
 */
public class DateUtils {

    /***
     * formate date return string
     * @param date
     * @param dateFormate
     * @return
     */
    public static String dateFormat(Date date, String dateFormate) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormate);
        String formResult = null;
        if (date == null || formatter == null) {
            return null;
        }
        try {
            formResult = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formResult;
    }


    /****
     * convert mmm d yyyy k:m:s a to yyyy-MM-dd HH:mm:ss
     *
     * @param resourceDate
     * @return
     */
    public static String convertDate(String resourceDate) {
        //SimpleDateFormat sdf = new SimpleDateFormat("MMM d yyyy K:m:s a", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d yyyy K:m a", Locale.ENGLISH);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sourceDate = null;
        String resurt = "";
        try {
            sourceDate = sdf.parse(resourceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            resurt = formatter.format(sourceDate);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resurt;
    }

    /****
     * convert  yyyy-MM-dd HH:mm:ss to  mmm d yyyy k:m:s a
     * @param resource
     * @return
     */
    public static String convertDate(Date resource) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d yyyy K:m:s a", Locale.ENGLISH);
        String resurt = "";
        try {
            resurt = sdf.format(resource);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resurt;
    }

    /***
     * convert MMM d yyyy K:m:s a  to yyyy-MM-dd HH:mm:ss
     * @param resourceDate
     * @return
     */
    public static String aigTicketConvertDate(String resourceDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-M-d a k:m", Locale.CHINESE);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sourceDate = null;
        String resurt = "";
        try {
            sourceDate = sdf.parse(resourceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            resurt = formatter.format(sourceDate);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resurt;
    }
}
