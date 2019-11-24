package com.leetcode.zh3ng.solutions;

import java.util.HashSet;
import java.util.Set;

/*
 * created by zhangxingang on 2019/09/03
 */
public class SetMatrixZeros {
    public static int[][] solution(int[][] nums){
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        for(int r=0;r<nums.length;r++){
            for(int c=0;c<nums.length;c++){
                if(nums[r][c]==c){
                    columnSet.add(c);
                    rowSet.add(r);
                }
            }
        }
        int[][] output = nums;
        for (Integer c:columnSet){
            for (int r=0;r<nums.length;r++){
                output[r][c] = 0;
            }
        }
        for (Integer r:columnSet){
            for(int c=0;c<nums[0].length;c++){
                output[r][c] = 0;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{1,2,3,4,0,5},
                new int[]{1,2,3,4,5,0},
                new int[]{1,2,3,4,5,6},
        };
        int[][] result = solution(input);
        for (int r=0;r<result.length;r++){
            for (int c=0;c<result[0].length;c++){
                System.out.print(result[r][c]+" ");
            }
            System.out.println("");
        }
    }
}
