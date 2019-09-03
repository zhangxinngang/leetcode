package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] m) {
        List<Integer> result = new ArrayList<>();
        int l = m.length%2;
        for (int i = 0;i<m.length/2;i++){
            for (int n = i;n<m.length-i-1;n++){
                System.out.print(m[i][n]+" ");
                result.add(m[i][n]);
            }
            for (int n = i;n<m.length-i-1;n++){
                System.out.print(m[n][m.length-i-1]+" ");
                result.add(m[n][m.length-i-1]);
            }
            for (int n = m.length-i-1;n>i;n--){
                System.out.print(m[m.length-i-1][n]+" ");
                result.add(m[m.length-i-1][n]);
            }
            for (int n = m.length-i-1;n>i;n--){
                System.out.print(m[n][i]+" ");
                result.add(m[n][i]);
            }
        }
        if (l == 1){
            System.out.println(m[m.length/2][m.length/2]);
            result.add(m[m.length/2][m.length/2]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                new int[]{1,   4,  7, 11, 15},
                new int[]{2,   5,  8, 12, 19},
                new int[]{3,   6,  9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                //new int[]{18, 21, 23, 26, 30}
        };

        List<Integer> list = spiralOrder(m);
    }

}
