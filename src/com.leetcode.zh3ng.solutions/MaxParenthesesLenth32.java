package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2020/01/09
 */
public class MaxParenthesesLenth32 {
    public int longestValidParentheses(String s){
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0;i< chars.length ;i++){
            if (chars[i] == '('){
                left++;
            }else{
                right++;
            }
            if (right == left){
                max = max > left*2?max:left*2;
            }else if(right > left){
                right = 0;
                left = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = chars.length-1;i > -1 ;i--){
            if (chars[i] == ')'){
                left++;
            }else{
                right++;
            }
            if (right == left){
                max = max > left*2?max:left*2;
            }else if(right > left){
                right = 0;
                left = 0;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        MaxParenthesesLenth32 maxParenthesesLenth = new MaxParenthesesLenth32();

        System.out.println(maxParenthesesLenth.longestValidParentheses("(()")+"-"+2);

        System.out.println(maxParenthesesLenth.longestValidParentheses("()(()")+"-"+2);
    }
}
