package com.leetcode.zh3ng.solutions.April30Days;

/**
 * created by zhangxingang on 2020/04/23
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range,
 * inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 *
 *
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        for (int i = m+1;i<=n&&i>=0;++i){
            if ((i&i-1)==0){
                return 0;
            }
            result = result & i;
        }
        return result;
    }

    public int rangeBitwiseAnd2(int m, int n){
        while(m < n){
            n -= (n & -n);
        }
        return n;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange b = new BitwiseANDofNumbersRange();

        System.out.println(b.rangeBitwiseAnd2(5,7)+" 4");

        System.out.println(b.rangeBitwiseAnd2(0,1)+" 0");

        System.out.println(b.rangeBitwiseAnd(2147483646,2147483647));

        System.out.println("快去看看吧>>".length());
    }
}
