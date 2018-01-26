package com;

/**
 * @author Arike
 * Create_at 2018/1/5 7:56
 */

/**
 * 测试线程插入方法,执行join()直接插入,将执行插入线程之后再执行当前线程
 * join(miilis,nanos)插入多少时间之后就交替执行(恢复多线程交替操作(并发))
 */
public class test4 {
    public static void main(String[] args) {
       
        final Thread t1 = new Thread(() -> {
          
            for (int i = 0; i < 50; i++) {
                System.out.println("插队线程");
            }
        });
       
       
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                if(i==5){
                    try {
                        t1.join(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("主线程");
            }
        }
        );
        
        t2.start();
        t1.start();
    }
}
