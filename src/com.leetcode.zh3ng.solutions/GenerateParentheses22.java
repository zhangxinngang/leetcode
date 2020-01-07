package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        Set<String> strSet = gen(n*2-1,new HashSet<>(),"(",1,0);
        return new ArrayList<>(strSet);
    }

    public Set<String> gen(int n,Set<String> set,String s,int left,int right){
        if (right > left){
            return set;
        }
        if (n == 1){
            String a = s + ")";
            right += 1;
            if (left == right){
                set.add(a);
            }
            return set;
        }else{
            set.addAll(gen(n-1,set,s +"(",left+1,right));
            set.addAll(gen(n-1,set,s +")",left,right+1));
            return set;
        }
    }

    public static void main(String[] args) {
        GenerateParentheses22 g = new GenerateParentheses22();
        List<String> list = g.generateParenthesis(6);

        for (String s:list){
            System.out.println(s);
        }
    }
}
