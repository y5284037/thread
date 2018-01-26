package com;

/**
 * @author Arike
 * Create_at 2018/1/25 10:45
 */
public class test19 {
     static int i=1;
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (test19.class) {
                        if (i != 1) {
                            try {
                                test19.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(Thread.currentThread().getName() + "     ");
                        System.out.print("我");
                        System.out.print("和");
                        System.out.print("你");
                        System.out.println();
                        i = 2;
                        test19.class.notify();
                    }
                }
            }
        }.start();
        
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (test19.class) {
                        if (i != 2) {
                            try {
                                test19.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(Thread.currentThread().getName() + "     ");
                        System.out.print("啪");
                        System.out.print("啪");
                        System.out.print("啪");
                        System.out.println();
                        i = 1;
                        test19.class.notify();
                    }
                }
            }
        }.start();
    }
}
