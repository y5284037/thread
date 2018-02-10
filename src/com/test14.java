package com;

/**
 * @author Arike
 * Create_at 2018/1/15 13:23
 * 1.饿汉式是空间换时间,懒汉式是时间换空间.
 * 2.在多线程访问时饿汉式不会创建多个对象,而懒汉有可能会创建多个对象.
 */
public class test14 {
    public static void main(String[] args) {
        singleton1 s = singleton1.getInstance();
        singleton1 s1 = singleton1.getInstance();
        System.out.println(s == s1);
        singleton2 s2 = singleton2.getInstance();
        singleton2 s3 = singleton2.getInstance();
        System.out.println(s2 == s3);
    }
    
}

//饿汉式单例
class singleton1 {
    //1.私有构造方法
    private singleton1() {
    }
    
    //2.生成一个本例对象
    private static singleton1 s = new singleton1();
    
    //3.对外提供公共的方法
    public static singleton1 getInstance() {
        return s;
    }
}

//懒汉式
class singleton2 {
    //1.私有构造方法
    private singleton2() {
    }
    
    //2.声明一个对象
    private static singleton2 s;
    
    //3.对外提供公共的方法
    public static singleton2 getInstance() {
        if (s == null) {
            s = new singleton2();
        }
        return s;
    }
}

//机智的懒汉式子
class singleton3{
    //1.私有构造方法
    private singleton3() {
    }
    
    //2.声明一个对象
    private static singleton3 s;
    
    //3.对外提供同步的公共的方法
    public static synchronized singleton3 getInstance() {
        if (s == null) {
            s = new singleton3();
        }
        return s;
    }
}

//类似于饿汉式
class Singleton4 {
    private Singleton4() {}
    public static final Singleton4 s = new Singleton4();//final是最终的意思,被final修饰的变量不可以被更改
}