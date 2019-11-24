package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2019/09/16
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int stepNum = 1;
        for (int i = digits.length -1;i>=0;i--){
            int num = digits[i] + stepNum;
            stepNum = 0;
            if (num >= 10){
                digits[i] = 0;
                stepNum = 1;
            }else{
                digits[i] = num;
            }
        }
        int[] result = digits;
        if (stepNum > 0){
            result = new int[digits.length+1];
            result[0] = 1;
            for (int i = 1;i<result.length;i++){
                result[i] = digits[i-1];
            }
            return result;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = new int[]{9,9,9,9};
        int[] result = plusOne(a);
        for (int i = 0;i< result.length;i++){
            System.out.print(result[i]+",");
        }

    }
}
