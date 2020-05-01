package com.leetcode.zh3ng.solutions.April30Days;

import java.util.Stack;

/**
 * @author zhangxingang
 * @created on 2020/04/30
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (char c:S.toCharArray()){
            if (c == '#' && sStack.size() > 0){
                sStack.pop();
            }else if (c != '#'){
                sStack.push(c);
            }
        }

        for (char c:T.toCharArray()){
            if (c == '#' && tStack.size() > 0){
                tStack.pop();
            }else if (c != '#'){
                tStack.push(c);
            }
        }

        System.out.println(sStack.toString());
        System.out.println(tStack.toString());
        if (sStack.size() != tStack.size()){
            return false;
        }else{
            while (sStack.size() > 0 && tStack.size() > 0){
                char s = sStack.pop();
                char t = tStack.pop();
                if (s != t){
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();

        System.out.println(b.backspaceCompare(
                "y#fo##f",
                "y#f#o##f"));
    }
}
