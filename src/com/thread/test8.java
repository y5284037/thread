package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/5 10:39
 */

/**
 * 静态同步方法的锁对象是该类的.class字节码对象
 *synchronized非静态方法的锁对象是this当前对象.
 */
public class test8 {
    public static void main(String[] args) {
        demo1 d = new demo1();
        new Thread(() -> {
            while (true) {
                d.print1();
            }
        }).start();
        
        new Thread(() -> {
            while (true) {
                d.print2();
            }
        }).start();
    }
}


class demo1 {
    public synchronized static void print1() {
        System.out.print("我");
        System.out.print("爱");
        System.out.print("你");
        System.out.println();
    }
    
    public static void print2() {
        synchronized (demo1.class) {
            System.out.print("很11");
            System.out.print("开");
            System.out.print("心");
            System.out.println();
        }
    }
}
