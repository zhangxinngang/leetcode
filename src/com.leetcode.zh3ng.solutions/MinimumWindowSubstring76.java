package com.leetcode.zh3ng.solutions;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

    //unsolved
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }
        int head = 0;
        int tail = 0;

        String result = "";
        Map<Character,Integer> tMap = genMap(t);
        Map<Character,Integer> sMap = new HashMap<>();
        int keyLenth = tMap.size();
        while(tail <= s.length()){
            if (keyLenth == 0){
                String subString = s.substring(head,tail);
                if (result.length() == 0){
                    result = subString;
                }
                result = result.length() > subString.length()?subString:result;

                int count = sMap.get(s.charAt(head));
                sMap.put(s.charAt(head),count-1);
                if (tMap.containsKey(s.charAt(head))&&sMap.containsKey(s.charAt(head))&&sMap.get(s.charAt(head)) < tMap.get(s.charAt(head))){
                    keyLenth++;
                }
                head = head + 1;
            }else{
                if (tail == s.length()){
                    break;
                }
                int count = sMap.getOrDefault(s.charAt(tail),0);
                sMap.put(s.charAt(tail),count+1);
                if (sMap.get(s.charAt(tail)) != null && sMap.get(s.charAt(tail)) == tMap.get(s.charAt(tail))){
                    keyLenth--;
                }
                tail = tail + 1;
            }
        }
        return result;
    }

    public static Map<Character,Integer> genMap(String s){
        Map<Character,Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        return map;
    }

    public static void main(String[] args) {

    }

}
