package com.leetcode.zh3ng.solutions.june30days;

import java.util.*;

/**
 * @author zhangxingang
 * @created on 2020-06-03
 *
 * There are 2N people a company is planning to interview.
 * The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TwoCityScheduling {
    private int min = Integer.MAX_VALUE;
    public int twoCitySchedCost(int[][] costs) {
        dfs(costs,0,0,1,0,0);
        dfs(costs,0,1,0,1,0);
        return min;
    }

    public void dfs(int[][] costs,int total,int cityId,int cityA,int cityB,int index){
        if (index == costs.length){
            return;
        }
        total += costs[index][cityId];
        if (total > min){
            return;
        }
        if (cityA == cityB && (cityA+cityB)==costs.length){
            if (total < min){
                min = total;
            }
        }
        dfs(costs,total,0,cityA+1,cityB,index+1);
        dfs(costs,total,1,cityA,cityB+1,index+1);
    }


    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();

//        int[][] costs = new int[][]{
//                new int[]{10,20},
//                new int[]{30,200},
//                new int[]{400,50},
//                new int[]{30,20}
//        };

        int[][] costs = new int[][]{
                new int[]{259,770},
                new int[]{448,54},
                new int[]{926,667},
                new int[]{184,139},
                new int[]{840,118},
                new int[]{577,469}
        };

        System.out.println(twoCityScheduling.twoCitySchedCost(costs));
    }
}
