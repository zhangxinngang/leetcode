package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2020/04/05
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0){
            return profit;
        }
        int buyPrice = prices[0];
        for (int i = 1;i<prices.length;i++){
            if (buyPrice < prices[i]){
                profit += (prices[i]-buyPrice);
                buyPrice = prices[i];
            }
            if (buyPrice > prices[i]){
                buyPrice = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockII b = new BestTimetoBuyandSellStockII();

        int[] prices = new int[]{7,6,4,3,1};

        System.out.println(b.maxProfit(prices));
    }
}
