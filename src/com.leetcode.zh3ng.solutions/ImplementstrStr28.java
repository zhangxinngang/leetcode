package com.leetcode.zh3ng.solutions;

public class ImplementstrStr28 {

    /*
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    找到子string出现的一个下标
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0;i<=haystack.length()-needle.length();i++){
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }else{
                continue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr28 implementstrStr28 = new ImplementstrStr28();
        System.out.println(implementstrStr28.strStr("hello","ll"));
    }
}
