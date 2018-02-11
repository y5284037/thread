package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/26 10:19
 */


//2个线程以上的通讯需要使用while进行循环判断条件,并且使用notifyAll来唤醒所有线程,并且让他进行判断.
//如果使用if的话,会在wait位置停下来, 唤醒之后会接着waite下面的代码执行,而使用while就会重新进入判断,只有条件满足了,才会往下走.
public class test21 {
    static int i = 1;
    
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (test21.class) {
                        while (i != 1) {
                            try {
                                test21.class.wait();
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
                        test21.class.notifyAll();
                    }
                }
            }
        }.start();
        
        new Thread(() -> {
            while (true) {
                synchronized (test21.class) {
                    while (i != 2) {
                        try {
                            test21.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(Thread.currentThread().getName() + "     ");
                    System.out.print("啪");
                    System.out.print("啪");
                    System.out.print("啪");
                    System.out.println();
                    i = 3;
                    test21.class.notifyAll();
                }
            }
        }).start();
        
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (test21.class) {
                        while (i != 3) {
                            try {
                                test21.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(Thread.currentThread().getName() + "     ");
                        System.out.print("喜");
                        System.out.print("当");
                        System.out.print("爹");
                        System.out.println();
                        i = 1;
                        test21.class.notifyAll();
                    }
                }
            }
        }.start();
    }
}
