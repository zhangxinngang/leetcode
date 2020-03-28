package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2020/01/28
 */
public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int seat = 1;

        for (int i = 1;i<nums.length;i++){
            if (nums[i] > nums[seat-1]){
                nums[seat] = nums[i];
                seat++;
            }
        }
        return seat;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 r = new RemoveDuplicatesFromSortedArray26();

        int[] nums = new int[]{0,0,1,1,1,2,3,3,4,5};

        int lenth = r.removeDuplicates(nums);

        System.out.println(lenth);

        for (int i = 0;i<lenth;i++){
            System.out.print(nums[i]);
        }
    }
}
