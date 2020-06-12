package com.leetcode.zh3ng.solutions.byteDance;

import java.util.Map;

/**
 * @author zhangxingang
 * @created on 2020/6/12
 *
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int[] countForS1 = new int[26];

        for (char c: s1.toCharArray()){
            countForS1[c-97]++;
        }
        for (int i = 0;i <= s2.length() - s1.length();i++) {
            String s = s2.substring(i, i + s1.length());

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c-97]++;
            }
            int same = 0;
            for (int j = 0; j < 26; j++) {
                if (count[j] == countForS1[j]) {
                    same++;
                } else {
                    continue;
                }
            }
            if (same == 26) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();

//        System.out.println(c.checkInclusion("ab","eidbaooo"));
//
//        System.out.println(c.checkInclusion("ab" ,"eidboaoo"));

        System.out.println(c.checkInclusion("adc" ,"dcda"));
    }
}
