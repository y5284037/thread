package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/15 15:11
 * yield()礼让线程
 */
public class test1 {
    public static void main(String[] args) {
        new mythread3("线程").start();
        new mythread2("礼让线程").start();
        
    }
}

class mythread2 extends Thread{
    public mythread2(String s){
        super(s);
    }
    @Override
    public void run() {
        
        for(int i = 0; i < 100; i++) {
            if(i%1==0){
              Thread.yield();
          }
            System.out.println(getName() +"   "+i);
        }
    }
}
class mythread3 extends Thread{
    public mythread3(String s){
        super(s);
    }
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println(getName() +"   "+i);
        }
    }
}