package com.leetcode.zh3ng.solutions;

import java.util.HashMap;
import java.util.Map;

/*
 * created by zhangxingang on 2019/05/13
 * leetcode
 */
public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <=1){
            return s.length();
        }
        int max = 0;
        for(int i = 0;i<s.length();i++){
            Map<String,Integer> map = new HashMap<>();
            for (int j=i;j<s.length();j++){
                if (map.containsKey(String.valueOf(s.charAt(j)))){
                    max = max(max,map.size());
                    break;
                }else{
                    map.put(String.valueOf(s.charAt(j)),1);
                    if (j == s.length()-1){
                        max = max(max,map.size());
                    }
                }
            }
        }
        return max;
    }

    public static int max(int a,int b){
        return a > b ?a:b;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring( "aab"));
    }
}
