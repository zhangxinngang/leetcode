package com.leetcode.zh3ng.solutions.April30Days;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length < 1){
            return -1;
        }
        int minIdx = biSearchMin(nums);
        int maxIdx = minIdx - 1 >= 0 ? minIdx - 1:nums.length - 1;
        if (nums[minIdx] > target || nums[maxIdx] < target){
            return -1;
        }
        if (target >= nums[0]){
            return biSearch(nums,0,maxIdx+1,target);
        }

        if (target <= nums[nums.length-1]){
            return biSearch(nums, minIdx,nums.length,target);
        }
        return -1;
    }

    public int biSearch(int[] nums, int beginIdx, int endIdx, int target){
        int midInx = (beginIdx + endIdx) / 2;
        while (beginIdx < endIdx-1){
            if (nums[midInx] ==  target){
                return midInx;
            }
            if (nums[midInx] > target){
                endIdx = midInx;
                midInx = (beginIdx + endIdx)/2;
                continue;
            }
            if (nums[midInx] < target){
                beginIdx = midInx;
                midInx = (beginIdx+endIdx) / 2;
                continue;
            }
        }
        if (nums[midInx]==target){
            return midInx;
        }else{
            return -1;
        }
    }

    public int biSearchMin(int[] nums){
        int beginIdx = 0;
        int endInx = nums.length-1;
        int midIdx = (beginIdx + endInx)/2;
        while (beginIdx < endInx-1){
            if (nums[midIdx] >= nums[beginIdx] && nums[midIdx] <= nums[endInx]){
                break;
            }

            if (nums[midIdx] >= nums[endInx]){
                //比两个头都大，说明最小值在中间值 右边
                beginIdx = midIdx;
                midIdx = (beginIdx + endInx) / 2;
                continue;
            }

            if (nums[midIdx] < nums[beginIdx]) {
                //比两个头都小  说明最小值 在中间值左边
                endInx = midIdx;
                midIdx = (beginIdx + endInx) / 2;
                continue;
            }
        }

        if (nums[endInx] > nums[beginIdx]){
            return beginIdx;
        }else{
            return endInx;
        }
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();

        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},7)+" 3");
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},3)+ " -1");
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},2)+" 6");
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},6)+" 2");

        System.out.println(s.search(new int[]{},5));
    }
}
