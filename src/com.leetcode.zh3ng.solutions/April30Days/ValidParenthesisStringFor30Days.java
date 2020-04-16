package com.leetcode.zh3ng.solutions.April30Days;

import java.util.Stack;

/**
 * created by zhangxingang on 2020/04/16
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParenthesisStringFor30Days {
    public boolean checkValidString(String s) {

        //return check(s.toCharArray(),new Stack(),0);
        return check(s.toCharArray(),0,0);
    }

    //采用深度优先遍历方法  mark记录顺序
    public boolean check(char[] chars, int mark, int index){
        if (mark < 0){
            return false;
        }
        if (index == chars.length){
            return mark == 0;
        }
        boolean ok = false;
        if (chars[index] == '('){
            mark++;
            ok |= check(chars,mark,index+1);
        }else if (chars[index] == ')'){
            mark--;
            ok |= check(chars,mark,index+1);
        }else{
            ok |= check(chars,mark,index+1);
            ok |= check(chars,mark+1,index+1);
            ok |= check(chars,mark-1,index+1);
        }
        return ok;
    }

    /**
     *
     * Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.
     *
     * If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--.
     * If we encounter what can be a left bracket (c != ')'), then hi++, otherwise we must write a right bracket, so hi--.
     * If hi < 0, then the current prefix can't be made valid no matter what our choices are. Also, we can never have less than 0 open left brackets.
     * At the end, we should check that we can have exactly 0 open left brackets.
     */

//    贪心算法
//    public boolean checkValidString(String s) {
//        int lo = 0, hi = 0;
//        for (char c: s.toCharArray()) {
//            lo += c == '(' ? 1 : -1;
//            hi += c != ')' ? 1 : -1;
//            if (hi < 0) break;
//            lo = Math.max(lo, 0);
//        }
//        return lo == 0;
//    }

    public boolean check(char[] chars,Stack stack,int index){
        if (index >= chars.length){
            return stack.size() == 0;
        }

        char c = chars[index];

        boolean ok = false;

        if (c == '('){
            stack.push(c);
            ok |= check(chars,(Stack)stack.clone(),index+1);
        }else if (c == ')'){
            if (stack.size() == 0){
                ok |= false;
                return ok;
            }
            char top = (char)stack.pop();
            if (top == '('){
                ok |= check(chars,(Stack)stack.clone(),index+1);
            }else{
                ok |= false;
            }
        }else if (c == '*'){
            ok |= check(chars,(Stack)stack.clone(),index+1);
            stack.push('(');
            ok |= check(chars,(Stack)stack.clone(),index+1);
            stack.pop();
            if (stack.size() == 0){
                ok |= false;
                return ok;
            }
            char top = (char)stack.pop();
            if (top == '('){
                ok |= check(chars,(Stack)stack.clone(),index+1);
            }

        }
        return ok;
    }

    public static void main(String[] args) {
        ValidParenthesisStringFor30Days v = new ValidParenthesisStringFor30Days();

        System.out.println(v.checkValidString("()") + " true");

        System.out.println(v.checkValidString("(*)") + " true");

        System.out.println(v.checkValidString("(*))") + " true");

        System.out.println(v.checkValidString("**") + " true");

        System.out.println(v.checkValidString("***") + " true");
    }
}
