package com;

/**
 * @author Arike
 * Create_at 2018/1/5 9:03
 */

/**
 * 测试priority优先级  10最大 1最小
 */
public class test5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 1000; i++) {
                System.out.println("低优先级");
            }
        });
        
        Thread t2 = new Thread(()->{
            for(int i = 0; i < 1000; i++) {
                System.out.println("高优先级");
            }
        });
        
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
