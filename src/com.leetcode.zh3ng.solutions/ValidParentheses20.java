package com.leetcode.zh3ng.solutions;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (Character c :s.toCharArray()){
            System.out.println(stack.size());
            if (c.equals(']')){
                if (stack.size() ==0){
                    return false;
                }
                Character cInStack = (Character) stack.pop();
                if (cInStack != null&&cInStack.equals('[')){
                    continue;
                }else{
                    return false;
                }
            }else if (c.equals('[')){
                stack.push(c);
            }
            if (c.equals('}')){
                if (stack.size() ==0){
                    return false;
                }
                Character cInStack = (Character) stack.pop();
                if (cInStack != null&&cInStack.equals('{')){
                    continue;
                }else{
                    return false;
                }
            }else if (c.equals('{')){
                stack.push(c);
            }
            if (c.equals(')')){
                if (stack.size() ==0){
                    return false;
                }
                Character cInStack = (Character) stack.pop();
                if (cInStack != null&&cInStack.equals('(')){
                    continue;
                }else{
                    return false;
                }
            }else if (c.equals('(')){
                stack.push(c);
            }
        }
        return stack.empty();
    }

    //忒巧妙了,写起来巧妙，但是执行起来很慢，因为涉及 string的复制，用的空间比较多。
    public boolean isValid2(String s) {
        while(s.contains("()") || s.contains("{}") || s.contains("[]")){
            s = s.replace("()","").replace("{}","").replace("[]","");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses20 v = new ValidParentheses20();
        System.out.println(v.isValid2("()[]{"));
    }
}
