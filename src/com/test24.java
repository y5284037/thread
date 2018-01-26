package com;

/**
 * @author Arike
 * Create_at 2018/1/26 17:59
 */
public class test24 {
    public static void main(String[] args) {
        fu f = new zi();
        System.out.println(f.getClass());
        zi z = (zi)f;
        System.out.println(z.i);
    }
    
}

class fu{
    int i =10;
}

class zi extends fu{
    int i =20;
}