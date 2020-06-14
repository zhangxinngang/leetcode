package com.leetcode.zh3ng.solutions.june30days;

/**
 * @author zhangxingang
 * @created on 2020-06-08
 *
 * 判断 一个数 是不是 2的幂
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n){
        if (n <= 0){
            return false;
        }
        return (n&(n-1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();

        System.out.println(p.isPowerOfTwo(218));

        System.out.println(p.isPowerOfTwo(16));
    }
}
