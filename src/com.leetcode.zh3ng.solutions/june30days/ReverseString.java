package com.leetcode.zh3ng.solutions.june30days;

/**
 * @author zhangxingang
 * @created on 2020-06-04
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Hint:
 * The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
 */
public class ReverseString {
    public void reverseString(char[] s) {
        System.out.println("in "+String.valueOf(s));

        for (int i = 0;i < s.length/2;i++){
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }

        System.out.println("out "+String.valueOf(s));
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        reverseString.reverseString("abcdef".toCharArray());

    }
}
