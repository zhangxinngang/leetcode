package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.List;

public class SortColors75 {
    //可以计数，而不是使用list
    public static void sortColors(int[] nums) {
//        List<Integer> red = new ArrayList<>();
//        List<Integer> white = new ArrayList<>();
//        List<Integer> blue = new ArrayList<>();
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == 0){
                red++;
            }else if(nums[i] == 1){
                white++;
            }else{
                blue++;
            }
        }
        System.out.println(red+" "+white+" "+blue);
        for(int i = 0;i<nums.length;i++){
            if (i < red){
                nums[i] = 0;
            }else if (red <= i&&i < red+white){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,1,2,0,2};
        sortColors(input);
        for (Integer i:input){
            System.out.println(i);
        }

    }
}
