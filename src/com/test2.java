package com;

/**
 * @author Arike
 * Create_at 2018/1/4 18:32
 */

/**
 * 测试休眠线程,并且给线程命名
 * 一种命名方式是直接使用构造函数添加字符串的形式命名 new Thread("线程1")
 * 二种命名方式是使用new Thread().setName("线程1")命名
 * 获取到当前线程     Thread.currentThread()  ,如果是继承的Runnable接口,要获取到当前线程就需要使用Thread.currentThread().
 */
public class test2 {
    public static void main(String[] args) throws InterruptedException {
        
        new Thread(() -> {
            Thread.currentThread().setName("线程B");
            for(int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+i);
            }
        }).start();
        
        new Thread("线程3"){
            @Override
            public void run() {
                this.setName("线程A");
                for(int i = 0; i <10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName()+i);
                    
                }
            }
        }.start();
        
        for(int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+i);
        }
        
    }
}
