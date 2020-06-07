package com.leetcode.zh3ng.solutions.june30days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020/6/7
 *
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Note:
 *
 * You can assume that
 *
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 *
 * 解题思路：
 *
 * dp[i][j]  coins 的前i个coin组合成j 的组合数量。
 *
 * coins = [1,2,5]
 *
 * dp[0][0]  前0个，组合成0 那就只有一种组合  1： dp[0][0] = 1;
 * dp[0][0] = 1
 * dp[1][0] = 1
 * dp[2][0] = 1
 * dp[3][0] = 1
 * dp[1][1] = 1;  [1]      -> 1
 * dp[1][2] = 1;  [1]      -> 11
 * dp[1][3] = 1;  [1]      -> 111
 * dp[1][4] = 1;  [1]      -> 111
 * dp[1][5] = 1;  [1]      -> 11111
 * dp[2][1] = 1;  [1,2]    -> 1
 * dp[2][2] = 2;  [1,2]    -> 11,2
 * dp[2][3] = 2;  [1,2]    -> 111,12
 * dp[2][4] = 3;  [1,2]    -> 1111,112,22
 * dp[2][5] = 3;  [1,2]    -> 11111,122,1112
 * dp[3][5] = 4;  [1,2,5]  -> 11111,122,1112,5
 *
 * 求 dp[coins.length][amount];
 */
public class CoinChange2 {
    private int count = 0;

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1;i < coins.length+1;i++){
            dp[i][0] = 1;
            for (int j = 1; j < amount+1; j++){
                dp[i][j] = dp[i-1][j] + (coins[i-1] <= j?dp[i][j-coins[i-1]]:0);
            }
        }

        return dp[coins.length][amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for (int i = coin; i <= amount; ++i){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public void change(int amount, int[] coins, int i){
        if (amount == 0){
            count++;
            return;
        }else if (amount > 0){
            for (int j = i ; j < coins.length; j++){
                if (amount >= coins[j]){
                    change(amount-coins[j], coins, j);
                }else{
                    return;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        CoinChange2 c = new CoinChange2();
        System.out.println("  "+c.change(5, new int[]{1,2,5}));

        CoinChange2 c1 = new CoinChange2();
        System.out.println("  "+c1.change(3, new int[]{2}));

        CoinChange2 c2 = new CoinChange2();
        System.out.println("  "+c2.change2(500, new int[]{3,5,7,8,9,10,11}));

    }
}
