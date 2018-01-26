package com;

/**
 * @author Arike
 * Create_at 2018/1/5 11:11
 */

/**
 * 用implements Runnable的方式模拟火车票4个窗口售卖.
 */
public class test12 {
    public static void main(String[] args) {
        ticket ticket =new ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }
}

class ticket1 implements Runnable{
    public static int tickets = 100;
    @Override
    public void run() {
        while (true){
            //这里如果不添加锁对象就会出现问题,必须同步.异步的话就会出现问题
            //这里的锁对象使用 .class和this都可以,因为只生成了一个ticket对象
            synchronized (""){
                if(tickets==0){
                    break;
                }
                try {
                    Thread.sleep(10);//这是为了模拟多行代码执行,异步的话cpu就会被别的线程抢去.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"   "+"还剩余"+tickets--+"张票");
            }
            
        }
    }
}