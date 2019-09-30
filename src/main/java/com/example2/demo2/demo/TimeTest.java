package com.example2.demo2.demo;

import java.util.Calendar;

public class TimeTest {

    public static long getTimeSlot(){
        Calendar end = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.add(Calendar.HOUR,-1);
        long l = end.getTimeInMillis() -start.getTimeInMillis();
        System.out.println(l);
        System.out.println("你好");
        System.out.println("你好祖国");
        return l;
    }

    public static void main(String[] args){

        getTimeSlot();

    }
}
