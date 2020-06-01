package com.leetcode.zh3ng.solutions.arrays101;

/**
 * @author zhangxingang
 * @created on 2020/5/16
 *
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 *
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  true
 *  0 2 3 4 5 2 1 0
 * Example 1:
 *
 * Input: [2,1]
 * Output: false
 * Example 2:
 *
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 *
 * Input: [0,3,2,1]
 * Output: true
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        boolean up = true;
        if (A.length < 3){
            return false;
        }
        int last = A[0];
        if (last >= A[1]){
            return false;
        }
        if (A[A.length-1] >= A[A.length-2]){
            return false;
        }
        for (int i=1;i<A.length-1;i++){
            if (up){
                if (last >= A[i]){
                    up = false;
                }
            }else{
                if (last <= A[i]){
                    return false;
                }
            }
            last = A[i];
        }
        return true;
    }

    public static void main(String[] args) {
        ValidMountainArray v = new ValidMountainArray();

        System.out.println(v.validMountainArray(new int[]{0,2,2,3,5,4,1,0}));

        System.out.println(v.validMountainArray(new int[]{0,5,5}));
    }
}
