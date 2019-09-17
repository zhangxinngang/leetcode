package com.leetcode.zh3ng.solutions;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }

        int first = 0;
        int second = 1;
        String result = s;
        while(first < second && second <= s.length()){
            String sub = s.substring(first,second);
            System.out.println(sub+" first:"+first+"secode"+second);
            if (containAll(sub,t)){
                if (sub.length() < result.length()){
                    result = sub;
                }
                first++;
            }else{
                if (second == s.length()&&first == 0){
                    result = "";
                }
                second++;
            }
        }
        return result;
    }

    public static boolean containAll(String s,String t){
        if (s.length() < t.length()){
            return false;
        }
        System.out.println("s:"+s+" t:"+t);
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        for (Character c:s.toCharArray()){
            if(sMap.containsKey(c)){
                sMap.put(c,sMap.get(c)+1);
            }else{
                sMap.put(c,1);
            }
        }
        for(Character c:t.toCharArray()){
            if(tMap.containsKey(c)){
                tMap.put(c,tMap.get(c)+1);
            }else{
                tMap.put(c,1);
            }
        }

        for(Character c:tMap.keySet()){
            int tc = tMap.get(c);
            System.out.println("t:"+tc+"s"+sMap.get(c)+""+c);
            if (sMap.containsKey(c)&&sMap.get(c)<tc){
                System.out.print(false);
                return false;
            }else if(!sMap.containsKey(c)){
                System.out.print(false);
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("bbaa","baa"));
    }

}
