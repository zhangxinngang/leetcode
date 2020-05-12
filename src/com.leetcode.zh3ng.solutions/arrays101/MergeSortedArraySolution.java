package com.leetcode.zh3ng.solutions.arrays101;

/**
 * @author zhangxingang
 * @created on 2020/5/6
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sum = m + n;
        int idx1 = 0;
        int idx2 = 0;
        int[] nums = new int[sum];
        while(idx1+idx2 <= sum-1){
            if (idx1 < m && idx2 < n){
                int n1 = nums1[idx1];
                int n2 = nums2[idx2];
                if (n1 > n2){
                    nums[idx1+idx2] = n2;
                    idx2++;
                }else{
                    nums[idx1+idx2] = n1;
                    idx1++;
                }
            }else if(idx1 == m && idx2 < n){
                nums[idx1+idx2] = nums2[idx2];
                idx2++;
            }else if(idx2 == n && idx1 < m){
                nums[idx1+idx2] = nums1[idx1];
                idx1++;
            }

        }
        for (int i = 0;i<nums.length;i++){
            nums1[i] = nums[i];
        }
    }

    public static void main(String[] args) {
        MergeSortedArraySolution mergeSortedArraySolution = new MergeSortedArraySolution();

        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};

        mergeSortedArraySolution.merge(a,3,b,3);

        for (Integer i:a){
            System.out.println(i);
        }
    }
}
