package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2019/08/20
 */
public class TargetSum494 {
    //private static int count = 0;

    public static int solution(int[] nums, int S){
        return sum(nums,0,0,S,1)+
            sum(nums,0,0,S,-1);
    }

    //深度优先
    public static int sum(int[] nums,int index,int summ,int target,int sign){
        System.out.print(" "+sign);
        summ += nums[index]*sign;
        if (index == nums.length-1){
            System.out.println(" "+index+"sum:"+summ);
            if (summ == target){
                return 1;
            }
            return 0;
        }
        return sum(nums,index+1,summ,target,1)+
                sum(nums,index+1,summ,target,-1);
    }

    public static void main(String[] args) {
        int c = solution(new int[]{1,1,1,1,1},3);
        System.out.println(c);
    }
}
