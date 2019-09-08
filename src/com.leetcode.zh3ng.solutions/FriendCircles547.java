package com.leetcode.zh3ng.solutions;

import java.util.*;

public class FriendCircles547 {

    /*
    * 还是得用DFS 深度优先搜索，递归的写代码。
    *
    *
    * */
    public static int findCircleNum2(int[][] M) {
        Set<Integer> setReach = new HashSet<>();
        int setNum = 0;
        int count = 0;
        for (int i = 0;i<M.length;i++){
            if (setReach.contains(i)){
                continue;
            }
            dfs(M[i],setReach,M);
            if (setReach.size() > setNum){
                setNum = setReach.size();
                count++;
            }
        }

        return count;
    }

    public static void dfs(int[] row,Set<Integer> setReach,int[][] M){
        Set<Integer> result = setReach;
        for (int i = 0;i<row.length;i++){
            if (result.contains(i)||row[i] == 0){
                continue;
            }
            if (row[i] == 1){
                result.add(i);
                dfs(M[i],result,M);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                new int[]{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                new int[]{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                new int[]{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                new int[]{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                new int[]{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                new int[]{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                new int[]{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                new int[]{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                new int[]{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        };
//        int[][] input = new int[][]{
//                new int[]{1, 0, 0, 1},
//                new int[]{0, 1, 1, 0},
//                new int[]{0, 1, 1, 1},
//                new int[]{1, 0, 1, 1},
//        };

        System.out.println(findCircleNum2(input));
    }

    /*
    * [[],[],[],[],[],[],[],[],[],[],[],[],[],[],[]]
    * */
}
