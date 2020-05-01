package com.leetcode.zh3ng.solutions.April30Days;

/**
 * @author zhangxingang
 * @created on 2020/04/14
 */

public class PerformStringShifts30Days {
    public String solution(String s, int[][] shift){
        //最终转换次数
        int mark = 0;
        for (int[] sft:shift){
            if (sft[0] == 0){
                mark -= sft[1];
            }else{
                mark += sft[1];
            }
        }
        if (mark == 0){
            return s;
        }
        int mod = mark % s.length();
        if (mark > 0){ //往右偏移
            String r = s.substring(s.length()-mod,s.length());
            String l = s.substring(0,s.length()-mod);
            return new StringBuilder().append(r).append(l).toString();
        }else { //往左偏移
            String l = s.substring(0, -mod);
            String r = s.substring(-mod, s.length());
            return new StringBuilder().append(r).append(l).toString();
        }
    }

    public static void main(String[] args) {

        String s = "wpdhhcj";
        PerformStringShifts30Days p = new PerformStringShifts30Days();


        //[0,7],[1,7],[1,0],[1,3],[0,3],[0,6],[1,2]
        System.out.println(p.solution(s,new int[][]{
                new int[]{0,7},
                new int[]{1,7},
                new int[]{1,0},
                new int[]{1,3},
                new int[]{0,3},
                new int[]{0,6},
                new int[]{1,2}}));

    }
}
