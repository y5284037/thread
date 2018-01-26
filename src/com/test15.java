package com;

import java.util.Date;

/**
 * @author Arike
 * Create_at 2018/1/15 14:28
 * Runtime也是一个单例的类
 */
public class test15 {
    public static void main(String[] args) throws Exception{
        Runtime r = Runtime.getRuntime();
        r.exec("shutdown -s -t 300");
        Thread.sleep(5000L);
        r.exec("shutdown -a");
    }
}
