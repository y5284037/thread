package com.thread;

import java.util.concurrent.Callable;

/**
 * @author Arike
 * Create_at 2018/1/26 14:47
 */
//Callable是可以带返回值并且能够抛出异常的多线程.在需要在多线程完毕之后返回一个返回值的就可以用Callable.
public class test22 {
    public static void main(String[] args) throws Exception {
        ((Callable<Integer>) () -> null).call();
        ((demo22) () -> null).ceshi();
        ((demo221) () -> System.out.println("测试")).ceshi();
        new Thread(() -> System.out.println("测试")).start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        }.start();
    }
}

interface demo22 {
    Integer ceshi();
}

interface demo221 {
    void ceshi();
}