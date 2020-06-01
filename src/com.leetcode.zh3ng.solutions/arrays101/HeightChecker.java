package com.leetcode.zh3ng.solutions.arrays101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxingang
 * @created on 2020/5/23
 *
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 *
 * Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
 *
 * Notice that when a group of students is selected they can reorder in any possible way between themselves and the non selected students remain on their seats.
 *
 *
 *
 * Example 1:
 *
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Current array : [1,1,4,2,1,3]
 * Target array  : [1,1,1,2,3,4]
 * On index 2 (0-based) we have 4 vs 1 so we have to move this student.
 * On index 4 (0-based) we have 1 vs 3 so we have to move this student.
 * On index 5 (0-based) we have 3 vs 4 so we have to move this student.
 * Example 2:
 *
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Example 3:
 *
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {
    private Set<Integer> stepCount = new HashSet<>();

    public int heightChecker(int[] heights) {
        int[] origin = Arrays.copyOf(heights,heights.length);
        Arrays.sort(heights);
        int step = 0;
        for (int i=0;i<origin.length;i++){
            if (origin[i] != heights[i]){
                step++;
            }
        }
        return step;
    }

    public int heightChecker2(int[] heights) {
        sort(heights, 0, heights.length-1);
        return stepCount.size();
    }


    public void sort(int[] arrays, int low, int high){
        int key = arrays[low];
        int start = low;
        int end = high;

        while(start < end){
            while(start < end && key <= arrays[end]){
                end--;
            }
            if (key > arrays[end]){
                int temp = arrays[end];
                arrays[end] = arrays[start];
                arrays[start] = temp;
                stepCount.add(end);
                stepCount.add(start);
            }

            while(start < end && key >= arrays[start]){
                start++;
            }
            if (key < arrays[start]){
                int temp = arrays[end];
                arrays[end] = arrays[start];
                arrays[start] = temp;
                stepCount.add(end);
                stepCount.add(start);
            }
        }

        if (start > low){
            sort(arrays, low,start-1);
        }
        if (end < high){
            sort(arrays, end+1, high);
        }
    }

    public static void main(String[] args) {
        HeightChecker heightChecker = new HeightChecker();

        int[] a = new int[]{1,1,4,2,1,3};

        System.out.println(heightChecker.heightChecker(a));

        int[] b = new int[]{1,1,4,2,1,3};

        heightChecker.sort(b,0,b.length-1);

        System.out.println(heightChecker.stepCount);
    }

}
