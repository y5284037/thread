package com.thread;

/**
 * @author Arike
 * Create_at 2018/1/26 16:21
 */
//线程组,如果没有给线程分组,默认是在main线程里面.
public class test23 {
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("线程组1");
        System.out.println(new Thread(tg, () -> System.out.println(1), "线程1").getThreadGroup().getName());
        System.out.println(new Thread(tg, () -> System.out.println(2), "线程2").getThreadGroup().getName());
    }
}
