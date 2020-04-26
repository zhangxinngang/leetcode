package com.leetcode.zh3ng.solutions.April30Days;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangxingang on 2020/04/26
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 *
 *    Hide Hint #1
 * Try dynamic programming. DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
 * 来个二维数组，ij 表示两个子string的最大 共同子序列
 *    Hide Hint #2
 * 遍历两个string
 * DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] commonMatrix = new int[text1.length()+1][text2.length()+1];
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        if (char1[0] == char2[0]){
            commonMatrix[1][1] = 1;
        }
        for (int i = 1;i<=char1.length;i++){
            for (int j = 1;j<=char2.length;j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    commonMatrix[i][j] = commonMatrix[i-1][j-1]+1;
                }else{
                    commonMatrix[i][j] = Math.max(commonMatrix[i][j-1],commonMatrix[i-1][j]);
                }
            }
        }
        return commonMatrix[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();

        System.out.println(l.longestCommonSubsequence("ezupkr",
                "ubmrapg")+" 2");

        System.out.println(l.longestCommonSubsequence("abced",
                "ace")+" 3");

        System.out.println(l.longestCommonSubsequence("bsbininm",
        "jmjkbkjkv")+" 1");

        System.out.println(l.longestCommonSubsequence("oxcpqrsvwf",
        "shmtulqrypy")+" 3");

        System.out.println(l.longestCommonSubsequence("pmjghexybyrgzczy",
        "hafcdqbgncrcbihkd")+" 4");
    }
}
