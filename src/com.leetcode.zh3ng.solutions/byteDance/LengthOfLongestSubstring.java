package com.leetcode.zh3ng.solutions.byteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxingang
 * @created on 2020/6/12
 *
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> keyIndexMap = new HashMap<>();
        int sum = 0;
        int start = -1;
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (keyIndexMap.containsKey(c)){
                int oldIndex = keyIndexMap.get(c);
                keyIndexMap.put(c,i);
                if (oldIndex < start){
                    sum = sum >= (i - start)? sum: (i - start);
                }else{
                    start = oldIndex;
                }
            }else{
                keyIndexMap.put(c,i);
            }
            sum = sum >= (i - start)? sum: (i - start);
        }

        return sum;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb")+"=3");

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb")+"=1");

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew")+"=3");

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abb")+"=2");

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("aab")+"=2");

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba")+"=2");

        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("tmmzuxt")+"=5");
    }
}
