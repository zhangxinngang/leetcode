package com.leetcode.zh3ng.solutions.june30days;

import java.util.Arrays;

/**
 * @author zhangxingang
 * @created on 2020-06-10
 *
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * 解题思路：
 *
 * 运用二分查找，
 *
 * *** 如果最后一个比target小，则位置为nums.length
 * *** 如果能找到，就用返回位置；
 * *** 如果找不到，二分查找的low 即为该放入的位置。
 *
 *
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        if (nums[high - 1] < target){
            return high;
        }

        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            int midVal = nums[mid];
            if (midVal < target){
                low = mid + 1;
            } else if (midVal > target){
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();

        System.out.println(s.searchInsert(new int[]{1,3,5,6},7));

        System.out.println(s.searchInsert(new int[]{1,3,5,6},1));

        System.out.println(s.searchInsert(new int[]{1,3,5,6},2));

        System.out.println(s.searchInsert(new int[]{1,3,5,6},5));

        //System.out.println(Arrays.binarySearch(new int[]{1,3,5,6},7));
    }
}
