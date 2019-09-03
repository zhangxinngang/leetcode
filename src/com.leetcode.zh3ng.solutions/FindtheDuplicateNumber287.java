package com.leetcode.zh3ng.solutions;

import java.util.BitSet;

/*
 * created by zhangxingang on 2019/08/19
 */
public class FindtheDuplicateNumber287 {


    /**
     * @method
     * @date 2019-08-19 20:25
     * @author zhangxingang
     * @description 给一个数组，里面肯定有一个数字是重复的，找出来
     *              要求 空间O(1) 时间小于O(n^2) 不可以改变数组
     * @return  
    */
    public static int solution(int[]nums){
        BitSet bitSet=new BitSet();
        for(int i = 0;i<nums.length;i++){
            boolean in = bitSet.get(nums[i]);
            if (in){
                return nums[i];
            }else{
                bitSet.flip(nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        BitSet bitSet = new BitSet();
//        System.out.println(bitSet.get(0));
//        bitSet.flip(0);
//        System.out.println(bitSet.get(0));
//
//        bitSet.flip(1);
//        System.out.println(bitSet.get(0));
        System.out.println(solution(new int[]{1,2,3,4,2,8,4,10,11,12,14,15,16,21,23,43,54,9}));
    }
}
