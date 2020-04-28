package com.leetcode.zh3ng.solutions.April30Days;

/**
 * created by zhangxingang on 2020/04/27
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (matrix[i][j] == '1'){
                    max = Math.max(1,max);
                    int s = search(matrix,i,j,i,j+1,1,max);
                    max = Math.max(s,max);
                }
            }
        }
        return max;
    }

    public int search(char[][] matrix, int startrow, int startcol, int row, int col, int direct,int max){
        if (startcol == col && matrix[row][col] == '1'){
            //如果转会到起始点下面，则完成了一个正方形
            int square = (row - startrow+1)*(row - startrow+1);
            int newsqur = search(matrix,startrow,startcol,startrow,col+row-startrow+1,1,max);
            return Math.max(square,newsqur);
        }
        if (col < 0 || row >= matrix.length ||col >= matrix[0].length || matrix[row][col] == 0){
            return max;
        }
        if (matrix[row][col] == '1'){
            if (row-startrow == col-startcol){
                direct = 2;
            }
            if (direct == 1){
                int square = search(matrix,startrow,startcol,row+1,col,1,max);
                max = Math.max(square,max);
                return max;
            }
            if (direct == 2){
                int square = search(matrix,startrow,startcol,row,col-1,2,max);
                max = Math.max(square,max);
                return max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();

//        char[][] matrix = new char[][]{
//                new char[]{1,0,1,0,0},
//                new char[]{1,0,1,1,1},
//                new char[]{1,1,1,1,1},
//                new char[]{1,0,0,1,0},
//        };
//
//        System.out.println(maximalSquare.maximalSquare(matrix)+' - 4');
//
//        System.out.println(maximalSquare.maximalSquare(new char[][]{
//                new char[]{1,0,1,0,0},
//                new char[]{1,0,1,1,1},
//                new char[]{1,1,1,1,1},
//                new char[]{1,0,1,1,1},
//        })+' - 9');
//
//        System.out.println(maximalSquare.maximalSquare(new char[][]{
//                new char[]{1,1,1,1,0},
//                new char[]{1,1,1,1,1},
//                new char[]{1,1,1,1,1},
//                new char[]{1,1,1,1,1},
//        })+' - 16');

        //[['1','1','1','1','1','1','1','1'],['1','1','1','1','1','1','1','0'],['1','1','1','1','1','1','1','0'],['1','1','1','1','1','0','0','0'],
        // ['0','1','1','1','1','0','0','0']]
        
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                new char[]{'1','1','1','1','1','1','1','1'},
                new char[]{'1','1','1','1','1','1','1','0'},
                new char[]{'1','1','1','1','1','1','1','0'},
                new char[]{'1','1','1','1','1','0','0','0'},
                new char[]{'0','1','1','1','1','0','0','0'},
        })+" - 25");

       // [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]

//        System.out.println(maximalSquare.search(new char[][]{
//                new char[]{1,0,1,0,0},
//                new char[]{1,0,1,1,1},
//                new char[]{1,1,1,1,1},
//                new char[]{1,0,1,1,1},
//        },1,2,1,3,1));
    }
}
