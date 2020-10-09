package com.leetcode.zh3ng.solutions.yuanfudao;

/**
 * @author zhangxingang
 * @created on 2020/10/9
 */
public class MaxIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int curI, int curJ) {
        if (curI < 0 || curJ < 0 || curI == grid.length || curJ == grid[0].length || grid[curI][curJ] != 1) {
            return 0;
        }
        grid[curI][curJ] = 0;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        int ans = 1;
        for (int index = 0; index != 4; ++index) {
            int next_i = curI + di[index], nextJ = curJ + dj[index];
            ans += dfs(grid, next_i, nextJ);
        }
        return ans;
    }

}
