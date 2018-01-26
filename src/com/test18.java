package com;

/**
 * @author Arike
 * Create_at 2018/1/25 10:26
 */
public class test18 {
    public static void main(String[] args) {
        final crshi c = new crshi();
        new Thread("线程1") {
            @Override
            public void run() {
                c.p1();
            }
        }.start();
        
        new Thread("线程2") {
            @Override
            public void run() {
                c.p2();
            }
        }.start();
    }
}

class crshi {
    int i = 1;
    
    public void p1() {
        while (true) {
            synchronized (this) {
                if (i != 1) {
                    try {
                        this.wait();
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
                this.notify();
            }
            
        }
    }
    
    public void p2() {
        while (true) {
            synchronized (this) {
                if (i != 2) {
                    try {
                        this.wait();
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
                this.notify();
            }
            
        }
    }
}