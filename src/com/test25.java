package com;

import java.math.BigInteger;

/**
 * @author Arike
 * Create_at 2018/1/26 21:37
 */
//使用递归和循环分别完成兔子函数(斐波那契函数)
    //对于性能这块儿,还是循环完胜.递归上百次就会造成内存溢出.(栈内存先进后出限制了递归的效率)
    //这就是为什么在windows删除多层(上百层)文件夹无法操作的原因,毕竟底层也是递归来完成.
public class test25 {
    public static void main(String[] args) {
        // System.out.println(run(4));
        int x = 9999;
        BigInteger smallbegin = new BigInteger("1");
        BigInteger bigend = new BigInteger("0");
        for (int i = 1; i < x; i++) {
           BigInteger  temp = bigend;
            bigend = smallbegin.add(bigend);
            smallbegin = temp;
        }
        System.out.println(bigend.add(smallbegin));
        //System.out.println(run(50));
    }
    
    public static BigInteger run(int month) {
        if (month < 3) {
            return new BigInteger("1");
        } else {
            return new BigInteger(run(month - 2).toString()).add(new BigInteger(run(month - 1).toString()));
        }
    }
}
