package com.thread;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Arike
 * Create_at 2018/1/5 14:57
 * 死锁
 */
public class test11 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized ("1") {
                        System.out.println(getName() + "  " + "手持" + 1 + "等待" + 2);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized ("2") {
                            System.out.println(getName() + "   " + "拿到" + 2 + "行动");
                        }
                    }
                }
            }
        }.start();
        
        
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized ("2") {
                        System.out.println(getName() + "  " + "手持" + 2 + "等待" + 1);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized ("1") {
                            System.out.println(getName() + "   " + "拿到" + 1 + "行动");
                        }
                    }
                }
            }
        }.start();
    }
}

