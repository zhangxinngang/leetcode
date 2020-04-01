package com.leetcode.zh3ng.solutions;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> longListMap = new HashMap<>();
        for (String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sort = String.valueOf(chars);
            if (longListMap.containsKey(sort)){
                List<String> list = longListMap.get(sort);
                list.add(s);
                longListMap.put(sort,list);
            }else{
                List<String> list = new LinkedList<>();
                list.add(s);
                longListMap.put(sort,list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key:longListMap.keySet()){
            result.add(longListMap.get(key));
        }
        return result;
    }

    public void sort(char[] chars, int low, int high){
        int key = chars[low];
        int start = low;
        int end = high;

        while (start < end){
            while(start < end && key <= chars[end]){
                end--;
            }
            if (chars[end] < key){
                char t = chars[start];
                chars[start] = chars[end];
                chars[end] = t;
            }
            while (start < end && key <= chars[start]){
                start++;
            }
            if (chars[start] > key){
                char t = chars[start];
                chars[start] = chars[end];
                chars[end] = t;
            }
        }

        if (low < start){
            sort(chars,low,start-1);
        }
        if (high > end){
            sort(chars,end+1,high);
        }
    }

    public static void main(String[] args) {
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();

        System.out.println(groupAnagrams49.groupAnagrams(new String[]{"epa","pep"}));

        int[] a1 = new int[]{0,1,1};
        int[] a2 = new int[]{0,2,1,4,6,5};

        char[] chars = new char[]{'a','b','m','n','f','s'};

        groupAnagrams49.sort(chars,0,chars.length-1);

        for (char c:chars){
            System.out.println(c);
        }

        System.out.println(a2.equals(a1));
    }
}
