package com;

/**
 * @author Arike
 * Create_at 2018/1/4 17:50
 */

/**
 * 最基本的方式获取到线程,
 * 一是Extends于Thread类
 * 二是implements于Rannable接口,并且将此类作为参数传给一个Thread对象使用.调用start()
 */
public class test {
    public static void main(String[] args) {
        mythread mt = new mythread();
        mt.start();
        
        for (int i = 0; i < 500; i++) {
            System.out.println("主线程");
        }
        
        new Thread(new mythread1()).start();
    }
}

class mythread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("继承Thread");
        }
    }
}

class mythread1 implements Runnable {
    
    @Override
    public void run() {
        System.out.println("实现Runnable");
    }
}