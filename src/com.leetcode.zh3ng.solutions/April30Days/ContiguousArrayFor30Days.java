package com.leetcode.zh3ng.solutions.April30Days;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangxingang on 2020/04/13
 *
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 *
 *
 */
public class ContiguousArrayFor30Days {
    public int findMaxLength(int[] nums) {
        int mark = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        for (int i = 0;i < nums.length;i++){
            int n = nums[i];
            mark += n==0?-1:1;
            if (map.containsKey(mark)){
                max = Math.max(max, i - map.get(mark));
            }else{
                map.put(mark,i);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        ContiguousArrayFor30Days c = new ContiguousArrayFor30Days();
        // 68
        //System.out.println(c.findMaxLength(new int[]{0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));

        System.out.println(c.findMaxLength(new int[]{0,1}));
    }
}
