package com.leetcode.zh3ng.solutions.April30Days;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxingang
 * @created on 2020/04/30
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {

    /**
     * @date 2020-04-22 15:36
     * @author zhangxingang
     * @description   Time O(n^2)  Space O(n)
     * @return
    */
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            sums[i] = sums[i-1]+nums[i];
        }

        int count = 0;
        for (int s:sums){
            if(s == k){
                count++;
            }
        }

        for (int b = 0; b < sums.length;b++){
            for (int e = b+1;e < sums.length;e++){
                if (sums[e] - sums[b] == k){
                    count++;
                }
            }
        }

        return count;
    }


    /**
     * @date 2020-04-22 15:36
     * @author zhangxingang
     * @description  Time O(n)    Space O(n)
     * @return
    */
    public int subarraySum2(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int n:nums){
            sum += n;
            if (map.containsKey(sum - k)) {
                //说明前面的数组和  跟该点有相差k的
                count += map.get(sum - k);

            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();

        System.out.println(s.subarraySum(new int[]{1,2,3,4,5},5) + " 2");

        System.out.println(s.subarraySum(new int[]{1,1,1,1,-1},2) + " 4");

        System.out.println(s.subarraySum2(new int[]{1,2,3,4,5},5) + " 2");

        System.out.println(s.subarraySum2(new int[]{1,1,1,1,-1},2) + " 4");
    }
}
