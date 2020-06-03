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
 *
 *
 *
 *
 * 解题思路：
 *
 * 1.首先将成本分成两拨，一拨去A成本低，一拨去B成本低
 * 2.找到数量多的那一拨，从中去除一部分n, 分给少的那拨
 * 3.分出的部分n为 去A和去B成本相差 最少的n个人
 *
 * 时间复杂度 NlogN
 */
public class TwoCityScheduling {
    private int min = Integer.MAX_VALUE;
    public int twoCitySchedCost(int[][] costs) {
        List<int[]> costA = new ArrayList<>();
        List<int[]> costB = new ArrayList<>();

        for (int[] cost:costs){
            if (cost[0] > cost[1]){
                costB.add(cost);
            }else{
                costA.add(cost);
            }
        }

        List<int[]> big = costB;
        List<int[]> small = costA;
        boolean big1 = true;

        if (costA.size() > costB.size()){
            big = costA;
            small = costB;
            big1 = false;
        }
        Collections.sort(big, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0]-o1[1]) - Math.abs(o2[0]-o2[1]);
            }
        });

        int d = (big.size() - small.size())/2;
        small.addAll(big.subList(0,d));
        big = big.subList(d,big.size());

        int total = 0;
        for (int i = 0;i<big.size();i++){
            if (big1){
                total += (big.get(i)[1]+small.get(i)[0]);
            }else{
                total += (big.get(i)[0]+small.get(i)[1]);
            }
        }
        return total;
    }

    public int twoCitySchedCostDfs(int[][] costs){
        dfs(costs,0,0,1,0,0);
        dfs(costs,0,1,0,1,0);
        return min;
    }

    public void dfs(int[][] costs,int total,int cityId,int cityA,int cityB,int index){
        if (index == costs.length){
            return;
        }
        total += costs[index][cityId];
        if (total > min || cityA > costs.length || cityB > costs.length){
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

        int[][] costs = new int[][]{
                new int[]{10,20},
                new int[]{30,200},
                new int[]{400,50},
                new int[]{30,20}
        };

        //1859
//        int[][] costs = new int[][]{
//                new int[]{259,770},
//                new int[]{448,54},
//                new int[]{926,667},
//                new int[]{184,139},
//                new int[]{840,118},
//                new int[]{577,469}
//        };

        System.out.println(twoCityScheduling.twoCitySchedCost(costs));
    }
}
