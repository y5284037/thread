package com;

/**
 * @author Arike
 * Create_at 2018/1/5 10:16
 */

/**
 * 该类用于测试synchronized非静态方法的锁对象是this当前对象.
 */
public class test7 {
    public static void main(String[] args) {
        demo d =new demo();
        new Thread(()->{
            while(true){
                d.print1();
            }
        }).start();
        
        new Thread(()->{
            while (true){
                d.print2();
            }
        }).start();
    }
}

class demo{
    public  synchronized void print1(){
        System.out.print("我");
        System.out.print("爱");
        System.out.print("你");
        System.out.println();
    }
    
    public void  print2(){
        synchronized (this){
            System.out.print("很");
            System.out.print("开");
            System.out.print("心");
            System.out.println();
        }
    }
    
}