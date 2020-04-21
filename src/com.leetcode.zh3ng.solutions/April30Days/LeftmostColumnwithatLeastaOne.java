package com.leetcode.zh3ng.solutions.April30Days;

import model.BinaryMatrix;
import model.BinaryMatrixImpl;

import java.util.List;

/**
 * created by zhangxingang on 2020/04/21
 *
 * (This problem is an interactive problem.)
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 *
 *
 *
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 *
 *
 *
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 *
 *
 *
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= mat.length, mat[i].length <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 *
 *  * This is the BinaryMatrix's API interface.
 *  * // You should not implement it, or speculate about its implementation
 *  * interface BinaryMatrix {
 *  *     public int get(int x, int y) {}
 *  *     public List<Integer> dimensions {}
 *  * };
 *
 *
 *  1. 每行做一个二分查找，找到第一个1，并记录最左的1 下标   Time: nlog(m)
 *  2. 更进一步的优化   从最右上角的点开始，遇到1 就左移，遇到0就下移，直到遍历完整个 矩阵  Time: n+m
 */




public class LeftmostColumnwithatLeastaOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();

        int row = list.get(0);
        int col = list.get(1);

        int result = -1;

        int r = 0;
        int c = col - 1;

        while(r < row && c >= 0){
            int n = binaryMatrix.get(r,c);
            if (n == 1){
                result = c;
                c--;
            }else{
                r++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl(
                new int[][]{
                        new int[]{0,0,0,1},
                        new int[]{0,0,1,1},
                        new int[]{0,1,1,1},
                }
        );

        LeftmostColumnwithatLeastaOne l = new LeftmostColumnwithatLeastaOne();
        System.out.println(l.leftMostColumnWithOne(binaryMatrix));
    }

}
