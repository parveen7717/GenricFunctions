package com.example.genricfunctions.genric_classes;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**************
 * This class used for convert time stamp into different format
 */

public class ConvertTimeStamp {

    // function will get date long type and return date in string format
    public static String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        //String date = DateFormat.format("MM-dd-yyyy", cal).toString();
        String date = DateFormat.format("dd MMM, yyyy", cal).toString();
        return date;
    }

    // function for get current date
    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd MMM, yyyy");
        String strDate = mdformat.format(calendar.getTime());
        return strDate;
    }

    // function for add days into current date
    public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    // function will get date string type and return date in Date format
    public static Date stringToDate(String stringDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        Date date = formatter.parse(stringDate);
        System.out.println(date);
        System.out.println(formatter.format(date));
        return date;
    }

    // function will get date Date type and return date in String format
    public static String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        String expireDate = formatter.format(date);
        return expireDate;
    }

    // function will get date string type and return date in Long format
    public static Long dateToLong(String stringDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
        Date date = formatter.parse(stringDate);
        long mills = date.getTime();
        return mills;
    }
}
