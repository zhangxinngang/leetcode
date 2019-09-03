package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2019/08/27
 */
public class GasStation134 {


    /**
     * Input:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     *
     * Output: 3
     *
     * Explanation:
     * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
     * Travel to station 4. Your tank = 4 - 1 + 5 = 8
     * Travel to station 0. Your tank = 8 - 2 + 1 = 7
     * Travel to station 1. Your tank = 7 - 3 + 2 = 6
     * Travel to station 2. Your tank = 6 - 4 + 3 = 5
     * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
     * Therefore, return 3 as the starting index.
     *
     */
    public static int solution(int[] gas, int[] cost){
        for (int i =0;i < gas.length;i++){
            System.out.println("i:-----"+i);
            int sum = solute(gas,cost,i);
            if (sum >=0){
                return i;
            }
        }
        return -1;
    }

    public static int solute(int[] gas,int[] cost,int index){
        int sum = 0;
        for (int i = index;i<=gas.length*2;i++){
            int mod = (i)%gas.length;
            int left = gas[mod]-cost[mod];
            System.out.println("left"+left+"sum："+sum+"i:"+i+"index:"+index);
            if (sum + left < 0){
                return -1;
            }
            sum += left;
        }
        System.out.println(sum+"sum");
        if (sum >= 0){
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};

        //gas  = [2,3,4]
        //cost = [3,4,3]

        //[1,2,3,4,3,2,4,1,5,3,2,4]
        //[1,1,1,3,2,4,3,6,7,4,3,1]


        System.out.println(solution(gas,cost));
    }
}
