package com.leetcode.zh3ng.solutions;

import java.util.*;

/*
 * created by zhangxingang on 2020/03/27
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        return sub(numsList);
    }

    private List<List<Integer>> sub(List<Integer> numsList){
        List<List<Integer>> result = new ArrayList<>();
        if (numsList.size() == 1){
            result.add(new ArrayList<>());
            result.add(numsList);
        }else{
            List<List<Integer>> res = sub(numsList.subList(0,numsList.size()-1));
            result.addAll(res);
            for (List<Integer> list:res){
                List<Integer> l = new LinkedList<>(list);
                l.add(numsList.get(numsList.size() -1));
                result.add(l);
            }
        }
        return result;
    }

    //discuss 里的最快答案
    public List<List> subsets1(int[] nums) {
        List<List> ans = new ArrayList<>();
        List list = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
            int num = i;
            for (int j = 0; j < nums.length; j++) {
                int rem = num % 2;
                num = num / 2;
                if (rem > 0) {
                    list.add(nums[j]);
                }
            }
            System.out.println(list+"i="+i);
            ans.add( list);
            list = new ArrayList();
        }
        return ans;

    }

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();

        System.out.println(subsets78.subsets1(new int[]{1,2,3}));

    }
}
