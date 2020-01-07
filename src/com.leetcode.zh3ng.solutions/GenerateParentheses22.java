package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        Set<String> strSet = new HashSet<>();
        gen(n*2-1,strSet,"(",1,0);
        return new ArrayList<>(strSet);
    }

    public void gen(int n,Set<String> set,String s,int left,int right){
        if (right > left){
            return;
        }
        if (n == 1){
            String a = s + ")";
            right += 1;
            if (left == right){
                set.add(a);
            }
            return;
        }else{
            gen(n-1,set,s +"(",left+1,right);
            gen(n-1,set,s +")",left,right+1);
            return;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        GenerateParentheses22 g = new GenerateParentheses22();
        List<String> list = g.generateParenthesis(5);

        long end = System.currentTimeMillis();
        System.out.println("cost"+(end-start)+"millis");

        for (String s:list){
            System.out.println(s);
        }
    }
}
