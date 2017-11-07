package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args){
        String fromDate = "2013-04-16 08:29:12";
        String toDate = "2013-04-20 09:44:29";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //前的时间
            Date fd = df.parse(fromDate);
            //后的时间
            Date td = df.parse(toDate);
            //两时间差,精确到毫秒
            long diff = td.getTime() - fd.getTime();
            long day = diff / 86400000;                         //以天数为单位取整
            long hour= diff % 86400000 / 3600000;               //以小时为单位取整
            long min = diff % 86400000 % 3600000 / 60000;       //以分钟为单位取整
            long seconds = diff % 86400000 % 3600000 % 60000 / 1000;   //以秒为单位取整
            //天时分秒
            System.out.println("两时间差---> " +day+"天"+hour+"小时"+min+"分"+seconds+"秒");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        long time1 = System.currentTimeMillis();
        try {
            Thread.sleep(300);
            long time2 = System.currentTimeMillis();
            System.out.println(time2 + "\t" + time1 + "\t" + (time2-time1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
