package com.leetcode.zh3ng.solutions.April30Days;

import java.util.*;

/**
 * @author zhangxingang
 * @created on 2020/04/30
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<stones.length;i++){
            list.add(stones[i]);
        }
        while(list.size() > 1){
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int y = list.get(list.size() - 1);
            int x = list.get(list.size() - 2);
            if (y == x){
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }else{
                list.set(list.size() - 2,y-x);
                list.remove(list.size() - 1);
            }
        }
        if (list.size() > 0){
            return list.get(0);
        }
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();

        System.out.println(l.lastStoneWeight(new int[]{2,2}));
    }
}
