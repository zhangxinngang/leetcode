package com.leetcode.zh3ng.solutions;

public class DivideTwoIntegers29 {
    public static int divide(int dividend, int divisor) {
        int num = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend > 0 && divisor > 0){
            while(dividend >= divisor){
                dividend -= divisor;
                num++;
            }
            return (int)num;
        }else if (dividend > 0 && divisor < 0){
            while (dividend >= -divisor){
                dividend += divisor;
                num--;
            }
            return (int)num;
        }else if (dividend < 0 && divisor < 0){
            while (dividend <= divisor){
                dividend -= divisor;
                num++;
            }
            return (int)num;
        }else if (dividend < 0 && divisor > 0){
            while (dividend <= -divisor){
                dividend += divisor;
                num--;
            }
            return (int)num;
        }else{
            return (int)num;
        }
    }

    public static int divide1(int dividend, int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        int a1 = Math.abs(dividend);
        int a2 = Math.abs(divisor);
        while (a1 - a2 >= 0) {
            int pow = 0;
            while (a1 - (a2 << 1 << pow) >= 0) {
                pow++;
            }
            result += 1 << pow;
            a1 -= a2 << pow;
        }
        return (dividend >= 0) == (divisor >= 0) ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide1(-2147483648
                ,-1));

        System.out.println(-2147483648*(-1));
    }
}
