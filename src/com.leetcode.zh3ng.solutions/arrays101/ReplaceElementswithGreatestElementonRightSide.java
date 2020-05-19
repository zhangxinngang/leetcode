package com.leetcode.zh3ng.solutions.arrays101;

/**
 * @author zhangxingang
 * @created on 2020-05-19
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */
public class ReplaceElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            result[i] = max;
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{17,18,5,4,6,1};
        ReplaceElementswithGreatestElementonRightSide r = new ReplaceElementswithGreatestElementonRightSide();

        int[] result = r.replaceElements(nums);

        for (Integer i:result){
            System.out.println(i);
        }
    }
}
