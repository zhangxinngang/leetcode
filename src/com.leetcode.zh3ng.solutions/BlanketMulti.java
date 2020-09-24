package com.leetcode.zh3ng.solutions;

import java.util.Stack;

/**
 * @author zhangxingang
 * @created on 2020-09-24
 */
public class BlanketMulti {
    public int blanketMulti(String s){
        Stack<Integer> stack = new Stack();
        stack.push(0);

        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(0);
            }else{
                int a = stack.pop();
                int b = stack.pop();

                stack.push(b + Math.max(1, 2*a));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        BlanketMulti blanketMulti = new BlanketMulti();

        System.out.println(blanketMulti.blanketMulti("(()(()))"));

        System.out.println(blanketMulti.blanketMulti("()()()"));


        System.out.println(blanketMulti.blanketMulti("()()(())"));
    }
}
