package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-07-06
 *
 *
 *
 */
public class KthNum {
    static int[] nums = new int[]{1,2,6,24,120,720,5040,40320,362880};
    int finalNum = 0;

    public int solution(int n, int k){
        if (k > nums[n-1]){
            return -1;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            numList.add(i);
        }
        int i = 1;
        while (numList.size() > 0){
            long sub = factor(n-i);
            int idx = k/(int)sub;
            finalNum += finalNum*10 + numList.get(idx);
            numList.remove(idx);
            k -= idx*sub;
            i++;
        }

        return finalNum;
    }


    public long factor(long i){
        if (i == 1){
            return 1;
        }
        return i * factor(i-1);
    }

    public static void main(String[] args) {
        KthNum kthNum = new KthNum();

        System.out.println(kthNum.solution(4, 16));

    }
}
