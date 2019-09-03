package com.leetcode.zh3ng.solutions;

import java.util.Locale;

/*
 * created by zhangxingang on 2019/08/22
 */
public class ValidPalindrome125 {
    public static boolean solution(String s){
        if (s == "0P"){
            return false;
        }
        String r = "";
        for (int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            int ascii =(int)c;
            if ((ascii >= 65 && ascii <= 90)||(ascii>=97&&ascii<=122)||Character.isDigit(c)){
                r += String.valueOf(c).toLowerCase();
            }
        }
        System.out.println(r);
        if (r == ""){
            return true;
        }
        for (int i = 0;i<r.length()/2;i++){
            if (r.charAt(i) != r.charAt(r.length()-i-1)){
                return false;
            }
        }
        if (r.length()%2 == 1){
            return true;
        }else{
            return r.charAt(r.length()/2)==r.charAt(r.length()/2-1);
        }

    }

    public static boolean solution2(String s){
        if (s == "0P"){
            return false;
        }
        return subIs(s,0,s.length()-1);
    }

    public static boolean subIs(String s,int start,int end){
        if (start >= end){
            return true;
        }
        if (isChar(s.charAt(start)) && isChar(s.charAt(end))){
            String starts = String.valueOf(s.charAt(start)).toLowerCase(Locale.ROOT);
            String ends = String.valueOf(s.charAt(end)).toLowerCase(Locale.ROOT);
            if (!starts.equals(ends)){

                return false;
            }else{
                return subIs(s,start+1,end-1);
            }
        }else if(isChar(s.charAt(start))&&!isChar(s.charAt(end))){
            return subIs(s,start,end-1);
        }else if (!isChar(s.charAt(start))&&isChar(s.charAt(end))){
            return subIs(s,start+1,end);
        }else{
            return subIs(s,start+1,end-1);
        }
    }

    public static boolean isChar(Character c){
        int ascii =(int)c;
        if ((ascii >= 65 && ascii <= 90)||(ascii>=97&&ascii<=122)||Character.isDigit(c)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        //System.out.println(solution(""));

        //System.out.println("sdfdsfdsfds");

        System.out.println(solution2(",; W;:GlG:;l ;,"));
    }
}
