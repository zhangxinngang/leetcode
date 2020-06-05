package com.leetcode.zh3ng.solutions.june30days;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhangxingang
 * @created on 2020-06-05
 *
 *   Random Pick with Weight
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array w. pickIndex has no arguments.
 * Arguments are always wrapped with a list, even if there aren't any.
 *
 *
 *
 *
 */
public class RandomPickwithWeight {
    private int[] weightSum;
    private Random random;

    public RandomPickwithWeight(int[] w) {
        weightSum = new int[w.length];
        weightSum[0] = w[0];
        for (int i = 1; i<w.length; i++){
            weightSum[i] = weightSum[i-1] + w[i];
        }
        random = new Random();
    }

    public int pickIndex() {
        int sum = weightSum[weightSum.length - 1];

        int rand = Double.valueOf(sum * Math.random()).intValue();
        ///int rand = random.nextInt(sum);
        if (rand < weightSum[0]){
            return 0;
        }
        int start = 1;
        int end = weightSum.length;
        while(start <= end){
            int mid = (start + end)/2;
            if (rand >= weightSum[mid-1] && rand < weightSum[mid]){
                return mid;
            }else if (rand >= weightSum[mid]){
                start = mid;
            }else if (rand < weightSum[mid-1]){
                end = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        RandomPickwithWeight randomPickwithWeight = new RandomPickwithWeight(new int[]{10,20,30,40,50});
        long start = System.currentTimeMillis();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<10000;i++){
            int pick = randomPickwithWeight.pickIndex();
            Integer c = map.getOrDefault(pick,0);
            map.put(pick,c+1);
        }

        System.out.println(map);
        System.out.println("time"+(System.currentTimeMillis()-start));
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
}
