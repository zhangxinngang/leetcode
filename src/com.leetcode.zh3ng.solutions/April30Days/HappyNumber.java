package com.leetcode.zh3ng.solutions.April30Days;

import java.util.HashSet;
import java.util.Set;

/*
 * created by zhangxingang on 2020/04/02
 */
public class HappyNumber {
    /**
     * Write an algorithm to determine if a number is "happy".
     *
     * A happy number is a number defined by the following process: Starting with any positive integer,
     * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
     * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
     */
    public boolean isHappy(int n) {
        return ishappy(n,new HashSet<>());
    }

    public boolean ishappy(int n, Set<Integer> set){
        String num = String.valueOf(n);

        int count = 0;
        for (int i: num.toCharArray()){
            count += (i-48) * (i-48);
        }
        if (count == 1){
            return true;
        } if (count != 1 && !set.contains(count)){
            set.add(count);
            return ishappy(count,set);
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        System.out.println(happyNumber.isHappy(19));
    }
}
