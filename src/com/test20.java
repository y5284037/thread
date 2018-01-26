package com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arike
 * Create_at 2018/1/26 10:04
 */

/**
 * 互斥锁
 *  1.同步
 * 使用ReentrantLock类的lock()和unlock()方法进行同步
 * 2.通信
 * 使用ReentrantLock类的newCondition()方法可以获取Condition对象
 * 需要等待的时候使用Condition的await()方法, 唤醒的时候用signal()方法
 * 不同的线程使用不同的Condition, 这样就能区分唤醒的时候找哪个线程了
 */
public class test20 {
    static int i = 1;
    public static void main(String[] args) {
        final ReentrantLock rtl = new ReentrantLock();
        final Condition c1 = rtl.newCondition();
        final Condition c2 = rtl.newCondition();
        final Condition c3 = rtl.newCondition();
        new Thread(() -> {
            while (true) {
                rtl.lock();
                if (i != 1) {
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("我");
                System.out.print("和");
                System.out.print("你");
                System.out.print("\r\n");
                i = 2;
                c2.signal();
                rtl.unlock();
            }
        }).start();
        
        new Thread(() -> {
            while (true) {
                rtl.lock();
                if (i != 2) {
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("啪");
                System.out.print("啪");
                System.out.print("啪");
                System.out.print("\r\n");
                i = 3;
                c3.signal();
                rtl.unlock();
            }
        }).start();
        
        new Thread(() -> {
            while (true) {
                rtl.lock();
                if (i != 3) {
                    try {
                        c3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("喜");
                System.out.print("当");
                System.out.print("爹");
                System.out.print("\r\n");
                i = 1;
                c1.signal();
                rtl.unlock();
            }
        }).start();
    }
}


