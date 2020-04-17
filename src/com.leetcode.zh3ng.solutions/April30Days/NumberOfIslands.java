package com.leetcode.zh3ng.solutions.April30Days;

/**
 *
 * created by zhangxingang on 2020/04/17
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid){
        int count = 0;
        for (int row = 0;row < grid.length;row++){
            for (int col = 0;col < grid[0].length;col++){
                if (grid[row][col] == ' ' || grid[row][col] == '0'){
                    continue;
                }
                boolean ok = dfs(grid,col,row);
                if (ok){
                    count++;
                }
            }
        }
        return count;
    }


    public boolean dfs(char[][] grid, int col, int row){
        if (grid[row][col] != '1'){
            return false;
        }
        grid[row][col] = ' ';
        if (col < grid[0].length - 1){
            dfs(grid, col+1,row);
        }
        if (row < grid.length - 1){
            dfs(grid,col,row+1);
        }
        if (col > 0){
            dfs(grid, col-1,row);
        }
        if (row > 0){
            dfs(grid,col,row-1);
        }
        return true;
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();

//        System.out.println(n.numIslands(new char[][]{
//                new char[]{'1','1','1','1','0'},
//                new char[]{'1','1','0','1','0'},
//                new char[]{'1','1','0','0','0'},
//                new char[]{'0','0','0','0','0'},
//        }));
//
//        System.out.println(n.numIslands(new char[][]{
//                new char[]{'1','1','0','0','0'},
//                new char[]{'1','1','0','0','0'},
//                new char[]{'0','0','1','0','0'},
//                new char[]{'0','0','0','1','1'},
//        }));


        System.out.println(n.numIslands(new char[][]{
                new char[]{'1','1','1'},
                new char[]{'0','1','0'},
                new char[]{'1','1','1'},
        }));
    }
}
