package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/5 9:35
 */

/**
 * 测试synchronized如何使用
 */
public class test6 {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized ("锁") {
                    System.out.print("我");
                    System.out.print("爱");
                    System.out.print("你");
                    System.out.println();
                }
            }
        }).start();
        
        new Thread(() -> {
            synchronized ("锁") {
                while (true) {
                    System.out.print("很");
                    System.out.print("开");
                    System.out.print("心");
                    System.out.println();
                }
            }
        }).start();
    }
}

