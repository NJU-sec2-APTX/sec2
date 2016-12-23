/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author 陈长生
 */
public class LocalDateToDate {
    
    /**
     *把localdate转化为date的方法
 * @param localDate:转化的localdate
 * @return date:转化成的date
 */
    public static Date localDateToDate(LocalDate localDate) {
        Date date=new Date();
        date.setYear(localDate.getYear());
        date.setMonth(localDate.getMonthValue());
        date.setDate(localDate.getDayOfMonth());
        date.setHours(12);
        date.setMinutes(0);
        date.setSeconds(0);
        return date;
    }
     /**
     *生成当前时间的date
    * 小时为12，分钟为00，秒为0
    * @return date:转化成的date
    */
    public static Date instantDate() {
        Date date=new Date();
        return date;
    }
}
