package com.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Arike
 * Create_at 2018/1/15 14:56
 * Timer定时任务.
 */
public class test16 {
    public static void main(String[] args) throws Exception{
        Timer t = new Timer();
        //t.schedule(new myTimerTask(),new Date(118,0,15,17,16,20));
       t.schedule(new myTimerTask(20L),new Date(118,0,15,17,17,40),3000);
        
        while(true){
         Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}


class myTimerTask extends TimerTask {
    Long id;
    public myTimerTask(Long id){}
    @Override
    public void run() {
        System.out.println(id);
    }
}