package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                List<Integer> l = new ArrayList<>(list);
                l.add(numsList.get(numsList.size() -1));
                result.add(l);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();

        System.out.println(subsets78.subsets(new int[]{1,2,3}));

    }
}
