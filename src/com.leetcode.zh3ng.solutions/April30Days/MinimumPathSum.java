package com.leetcode.zh3ng.solutions.April30Days;

public class MinimumPathSum {
    int min = Integer.MAX_VALUE;
    /**
     *
     * @param grid
     *
     * 计算出到达每个点的最短路径：
     * 思路关键：要将该二维数组记录 每个点的到达和
     *
     * 到达每个点的最短路径都是 由 到达该点左边的点 和 到达该点上边的点 最小的路径和 决定的。
     *
     * 具体求法：
     * 1. 求出第一行所有点到达的路径和
     * 2. 求出第一列多有点到达的路径和
     * 3. 其余各点 有左，上两个点到达路径和的最小值 加上本点的值得出
     *
     * @return
     */
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        if (rowNum == 0){
            return 0;
        }
        int colNum = grid[0].length;

        for (int i = 1;i < rowNum;i++){
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1;i < colNum;i++){
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i< rowNum;i++){
            for (int j = 1;j<colNum;j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[rowNum-1][colNum-1];
    }

    public int dfs(int[][] grid,int col,int row,int sum){
        if (sum >= min){
            return min;
        }
        if (col == grid[0].length - 1&& row == grid.length - 1){
            return sum + grid[row][col];
        }
        if (row < grid.length - 1){
            int s = dfs(grid, col, row+1, sum+grid[row][col]);
            if (s < min){
                min = s;
            }
        }
        if (col < grid[0].length - 1){
            int s = dfs(grid,col+1,row,sum+grid[row][col]);
            if (s < min){
                min = s;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();

        System.out.println(m.minPathSum(new int[][]{
                new int[]{4,6,1,4,7,2,5,6,1,8},
                new int[]{4,3,8,7,8,1,3,2,9,1},
                new int[]{0,2,3,3,3,3,0,7,3,2},
                new int[]{9,9,8,3,3,6,7,0,4,9},
                new int[]{1,9,4,9,6,2,2,1,6,4},
                new int[]{4,8,8,7,2,2,2,4,1,7},
                new int[]{6,3,6,7,6,2,3,3,2,9},
                new int[]{4,3,8,8,4,6,3,9,9,1},
                new int[]{3,3,0,1,3,4,5,5,8,7},
                new int[]{5,6,2,1,3,8,5,8,1,0}
        }));
    }
}
