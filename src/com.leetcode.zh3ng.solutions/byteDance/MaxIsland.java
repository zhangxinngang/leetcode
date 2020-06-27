package com.leetcode.zh3ng.solutions.byteDance;

/**
 * @author zhangxingang
 * @created on 2020/6/27
 *
 * 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 *
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class MaxIsland {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j=0; j < grid[0].length; j++){
                int sum = dfs(grid, i, j, 0);
                max = Math.max(sum,max);
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int col, int sum){
        if ( row >= grid.length || col >= grid[0].length || col < 0 || row < 0 || grid[row][col] == 0){
            //max = Math.max(sum, max);
            return sum;
        }else{
            grid[row][col] = 0;
            sum+=1;
            sum = dfs(grid, row+1, col, sum);
            sum = dfs(grid, row, col+1, sum);
            sum = dfs(grid, row-1, col, sum);
            sum = dfs(grid, row, col-1,sum);
            return sum;
        }
    }

    public static void main(String[] args) {
        MaxIsland m = new MaxIsland();

        int[][] grid = new int[][]{
                new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0},
                new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0},
                new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0},
                new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
//        int[][] grid = new int[][]{
//                new int[]{1,0,1},
//                new int[]{1,1,1},
//                new int[]{0,0,1},
//        };


        System.out.println(m.maxAreaOfIsland(grid));
    }
}
