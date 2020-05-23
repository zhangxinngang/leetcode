package com.leetcode.zh3ng.solutions.arrays101;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zhangxingang
 * @created on 2020/5/23
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue q = new PriorityQueue();
        for (Integer i :nums){
            if (!set.contains(i)){
                q.add(i);
                if (q.size() > 3){
                    q.poll();
                }
                set.add(i);
            }
        }
        if (q.size() == 3) {
            return (int)q.peek();
        }else{
            int size = q.size();
            for (int i= 0;i<size-1;i++){
                q.poll();
            }
        }
        return (int)q.peek();
    }

    public static void main(String[] args) {
        ThirdMaximumNumber t = new ThirdMaximumNumber();

        System.out.println(t.thirdMax(new int[]{2,2,3,1}));
    }
}
