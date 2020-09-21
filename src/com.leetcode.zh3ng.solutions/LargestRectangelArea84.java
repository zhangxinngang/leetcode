package com.leetcode.zh3ng.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxingang
 * @created on 2020-09-14
 *
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangelArea84 {
    int max = 0;
    public int largestRectangleArea(int[] heights) {
        area(heights, 0, heights.length - 1);
        return max;
    }

    public void area(int[] heights, int start, int end){
        if (start > end){
            return;
        }
        int min = start;
        for (int i = start; i <= end; i++){
            if (heights[i] < heights[min]){
                min = i;
            }
        }
        int area = heights[min] * (end-start+1);
        max = area > max?area:max;

        area(heights, start, min-1);
        area(heights, min+1, end);
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,3,3};

        LargestRectangelArea84 largestRectangelArea84 = new LargestRectangelArea84();

        System.out.println(largestRectangelArea84.largestRectangleArea(heights));
    }
}
