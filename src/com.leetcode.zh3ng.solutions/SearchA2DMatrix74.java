package com.leetcode.zh3ng.solutions;

public class SearchA2DMatrix74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int x = matrix[0].length-1;
        int y = 0;

        while(x >= 0&&y<matrix.length){
            if (matrix[y][x] > target){
                x--;
            }else if(matrix[y][x] < target){
                y++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
//                new int[]{1,3,5,7},
//                new int[]{10,11,16,20},
//                new int[]{23,30,34,50},
                new int[]{1}
        };

        System.out.print(searchMatrix(input,2));
    }
}
