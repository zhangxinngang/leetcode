package com.leetcode.zh3ng.solutions.byteDance;

/**
 * @author zhangxingang
 * @created on 2020/6/12
 *
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String min = strs[0];

        for (int i = 1;i<strs.length;i++){
            if (min.length() > strs[i].length()){
                min = strs[i];
            }
        }

        int max = 0;
        for (int i = 0;i < min.length();i++){
            for (int j = 0; j < strs.length; j++){
                if (strs[j].charAt(i) != min.charAt(i)){
                    return min.substring(0, max);
                }
                if (j == strs.length - 1){
                    max++;
                }
            }
        }
        return min.substring(0,max);
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();

        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));

        System.out.println(l.longestCommonPrefix(new String[]{"dog","racecar","car"}));


    }
}
