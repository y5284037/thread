package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/5 7:50
 */

/**
 * 测试守护线程
 */
public class test3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) {
                    System.out.println("主线程");
                }
            }
        };
        
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 50; i++) {
                System.out.println("守护线程");
            }
        });
        
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
