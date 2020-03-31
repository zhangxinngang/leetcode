package com.leetcode.zh3ng.solutions;

public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int layer = (matrix.length + 1)/2;
        for (int l = 0; l < layer;l++) {
            int[] tempList = new int[matrix.length - 1 - 2 * l];
            //右侧
            for (int i = matrix.length - 1 - l; i > l; i--) {
                tempList[i - 1 - l] = matrix[i][matrix.length - l - 1];
                matrix[i][matrix.length - l - 1] = matrix[l][i];
            }
            //下侧
            for (int i = l; i < matrix.length - l - 1; i++) {
                int temp = tempList[matrix.length - 2 - i - l];
                tempList[matrix.length - 2 - i - l] = matrix[matrix.length - 1 - l][i];
                matrix[matrix.length - 1- l][i] = temp;
            }
            //左侧
            for (int i = matrix.length - 2 - l ; i >= l; i--) {
                int temp = tempList[matrix.length - 2 - i - l];
                tempList[matrix.length - 2 - i - l] = matrix[i][l];
                matrix[i][l] = temp;
            }
            //上侧
            for (int i = l+1; i < matrix.length - l; i++) {
                matrix[l][i] = tempList[i - 1 - l];
            }
        }
    }

    public static void main(String[] args) {
        RotateImage48 rotateImage48 = new RotateImage48();

//        int[][] matrix = new int[][]{
//                new int[]{1,2,3},
//                new int[]{4,5,6},
//                new int[]{7,8,9},
//        };
//        int[][] matrix = new int[][]{
//                new int[]{1,2,3,4},
//                new int[]{5,6,7,8},
//                new int[]{9,10,11,12},
//                new int[]{13,14,15,16},
//        };
        int[][] matrix = new int[][]{
                new int[]{1,2,3,4,5},
                new int[]{6,7,8,9,10},
                new int[]{11,12,13,14,15},
                new int[]{16,17,18,19,20},
                new int[]{21,22,23,24,25},
        };
        rotateImage48.rotate(matrix);

        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix.length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
