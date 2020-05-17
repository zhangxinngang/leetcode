package com.leetcode.zh3ng.solutions;

/**
 * @author  zhangxingang on 2020/02/01
 */
public class ClimbingStairs70 {

    public int climbStairs(int n) {
        //return climb(n,1,0)+climb(n,2,0);
        //return fibonacci(n);
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        //斐波那契数列  只要算一遍即可，不用递归
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    private int climb(int n,int sub,int result){
        if (n - sub == 0){
            return result + 1;
        }else if (n - sub > 0){
            return climb(n-sub,1,result) + climb(n-sub,2,result);
        }else if (n -sub < 0){
            return result;
        }
        return 0;
    }

    private int fibonacci(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }


    public static void main(String[] args) {
        ClimbingStairs70 climbingStairs70 = new ClimbingStairs70();

        System.out.println(climbingStairs70.climbStairs(7));
    }
}
