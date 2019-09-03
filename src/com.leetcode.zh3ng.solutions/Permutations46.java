package com.leetcode.zh3ng.solutions;

import java.util.*;

public class Permutations46 {
    public static List<List<Integer>> solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        return getSubList(set);
    }

    public static List<List<Integer>> getSubList(Set<Integer> numset){
        Set<List<Integer>> list = new HashSet<>();
        List<Integer> listtt = new LinkedList<>(numset);
        if(numset.size() == 1){
            List<Integer> list2 = new LinkedList<>();
            list2.add(listtt.get(0));
            list.add(list2);
            return new ArrayList<>(list);
        }
        for (int j=0;j<listtt.size()-1;j++){
            int n = listtt.get(j);
            Set<Integer> set = new HashSet<>(listtt);
            set.remove(n);
            List<List<Integer>> l = getSubList(set);
            for(List<Integer> ll:l){
                for (int i = 0;i<=ll.size();i++){
                    List<Integer> lll = clone(ll);
                    lll.add(i,n);
                    list.add(lll);
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static List<Integer> clone(List<Integer> nums){
        List<Integer> list = new LinkedList<>();
        for (Integer i :nums){
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<List<Integer>> list = getSubList(set);
        for (List<Integer> l:list){
            for (Integer i:l){
                System.out.print(i+" ");
            }
            System.out.println(" ");
        }

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(0,3);
//
//        for(int i = 0;i<list.size();i++){
//            System.out.print(list.get(i));
//        }
    }
}
