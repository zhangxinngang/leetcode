package com.leetcode.zh3ng.solutions.byteDance;


import java.util.Arrays;

/**
 * @author zhangxingang
 * @created on 2020/6/12
 *
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class ReverseStringWords {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        String temp;
        for (int i = 0;i < strs.length/2;i++){
            temp = strs[i];
            strs[i] = strs[strs.length - 1 - i];
            strs[strs.length - 1 - i] = temp;
        }
        return String.join(" ", strs);
    }

    public static void main(String[] args) {
        ReverseStringWords reverseStringWords = new ReverseStringWords();

        //System.out.println(reverseStringWords.reverseWords("a good   example"));

        System.out.println(reverseStringWords.reverseWords("  hello world!  "));
    }

}
