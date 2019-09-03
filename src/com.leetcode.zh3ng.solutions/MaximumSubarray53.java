package com.leetcode.zh3ng.solutions;

public class MaximumSubarray53 {
    public static int maxSubArray(int[] nums){
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1;i<nums.length;i++){
            if (sum > 0){
                sum += nums[i];
            }else{
                sum = nums[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(input);
        System.out.println(result);
    }
}
