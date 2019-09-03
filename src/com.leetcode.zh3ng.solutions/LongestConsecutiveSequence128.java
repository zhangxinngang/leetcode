package com.leetcode.zh3ng.solutions;

import java.util.HashSet;
import java.util.Set;

/*
 * created by zhangxingang on 2019/08/27
 */
public class LongestConsecutiveSequence128 {
    public static int solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for (int i=0;i<nums.length;i++){
            int current = nums[i];
            int len = 0;
            while (set.contains(current+1)){
                current++;
                len++;
            }
            len = len + 1;
            if (max < len){
                max = len;
            }
        }
        return max;
    }

    public static int solution2(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        sort(nums,0,nums.length-1);

        int current = nums[0];
        int currentLen = 1;
        int max = currentLen;
        for (int i = 1;i<nums.length;i++){
            System.out.println(nums[i]+"  111 "+current);
            if (nums[i] - current == 1){
                current = nums[i];
                currentLen++;
                if (max < currentLen){
                    max = currentLen;
                }
            }else if(nums[i]==current){
                current = nums[i];
            }else{
                if (max < currentLen){
                    max = currentLen;
                }
                current = nums[i];
                currentLen = 1;
            }
        }
        return max;
    }

    public static void sort(int[] a,int low,int high){
        int key = a[low];
        int start = low;
        int end = high;
        while(start<end){
            while(start < end && key <= a[end]){
                end--;
            }
            if (key > a[end]){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while (start < end && key >= a[start]) {
                start++;
            }
            if (key < a[start]){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
        }

        if (start > low){
            sort(a,low,start-1);
        }
        if (end < high){
            sort(a,end+1,high);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,0,1};
        System.out.println(solution2(a));
    }
}
