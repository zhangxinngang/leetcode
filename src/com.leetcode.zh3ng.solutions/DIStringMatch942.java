package com.leetcode.zh3ng.solutions;

public class DIStringMatch942 {
    public static int[] diStringMatch(String S) {
        int[] output = new int[S.length()+1];
        int incr = 0;
        int decr = S.length();
        for (int i =0;i<S.length();i++){
            if (S.charAt(i) == 'I'){
                output[i] = incr;
                incr++;
            }else{
                output[i] = decr;
                decr--;
            }
        }
        output[output.length-1] = incr;
        return output;
    }


    public static void main(String[] args) {
        String s = "III";

        int[] output = diStringMatch(s);

        for(int i = 0;i<output.length;i++){
            System.out.println(output[i]);
        }
    }
}
