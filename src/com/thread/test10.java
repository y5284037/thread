package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/5 14:11
 */
public class test10 {
    public static void main(String[] args) {
        new Mythread().start();
        new Mythread().start();
        new Mythread().start();
        new Mythread().start();
    }
}

class Mythread extends Thread{
   private static int ticktes = 100;
    @Override
    public void run() {
        while(true){
            //这里如果不添加锁对象就会出现问题,必须同步.异步的话就会出现问题
            //这里的锁对象只能使用 .class,因为生成了4个Mythread对象,如果使用this其实还是不同的四把锁.
            //发现更好用的,使用String字符串..相同的字符串会指向同一个常量池已存在字符串..
           
                if(ticktes==0){
                    break;}
                System.out.println(this.getName()+"   "+"还剩余"+ticktes--+"张票");
            }
        }
    }

