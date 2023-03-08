package com.xiaolin.superresolution.service;

/**
 * @author xlxing
 */
public interface Calculator {
    /**
     * 两个数相加，返回和
     * @param a 加数1
     * @param b 加数2
     * @return 和
     */
    int addTwoNumbers(int a, int b);

    /**
     * 两数相乘，返回积
     * @param a 乘数1
     * @param b 乘数2
     * @return 积
     */
    int productTwoNumbers(int a, int b);
}
