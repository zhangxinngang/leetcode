package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2019/08/19
 */
public class ProductofArrayExceptSelf238 {

    //求出i左的乘积，i右边的乘积。
    public static int[] solution(int[] nums){
        int left = 1;
        int right = 1;
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        for (int i =0;i<nums.length;i++){
            left *= nums[i];
            right *= nums[nums.length - i - 1];
            leftProd[i] = left;
            rightProd[nums.length - i - 1] = right;
            System.out.println(""+i+"  left:   "+left+"right:   "+right);
        }
        int[] result = new int[nums.length];
        result[0] = rightProd[1];
        result[nums.length-1] = leftProd[nums.length-2];
        for (int i = 1;i<=nums.length-2;i++){
            result[i] = leftProd[i-1]*rightProd[i+1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = solution(new int[]{0,0});
        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
