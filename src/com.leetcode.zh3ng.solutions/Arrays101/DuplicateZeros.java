package com.leetcode.zh3ng.solutions.Arrays101;

import java.util.Arrays;

/**
 * @author zhangxingang
 * @created on 2020/5/5
 *
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 *
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Note:
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        for (Integer num:arr){
            if (i >= arr.length){
                break;
            }
            if (num == 0){
                result[i] = num;
                i+=1;
                if (i <= result.length - 1){
                    result[i] = num;
                    i+=1;
                }
            }else{
                result[i] = num;
                i++;
            }
        }
        for (int j=0;j<result.length;j++){
            arr[j] = result[j];
        }
    }

    public static void main(String[] args) {
        int[] aaa = new int[]{1,5,2,0,6,8,0,6,0};

        DuplicateZeros d = new DuplicateZeros();

        d.duplicateZeros(aaa);

        for (int a:aaa){
            System.out.println(a);
        }
    }
}
