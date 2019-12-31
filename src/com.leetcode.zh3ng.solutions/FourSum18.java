package com.leetcode.zh3ng.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum18 {

    /**
     * @method
     * @date 2019-12-31 14:25
     * @author zhangxingang
     * @description  一个数组，找四个数，相加之和等于目标值 的所有情况，不重复情况
     * 比如 【-1，-1，0，2，1】 target 0
     * 结果，[-1，-1，0，2]一种情况
     * @param null
     * @return
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<String> seqSet = new HashSet<>();
        quicksort(nums,0,nums.length-1);
        List<List<Integer>> finalResult = new ArrayList<>();
        for (int i = 0;i < nums.length;i++){
            int target1 = target-nums[i];

            for (int j = i+1;j < nums.length;j++){

                int low = j+1;
                int high = nums.length -1;
                List<List<Integer>> result = new ArrayList<>();
                while(low < high){
                    if (nums[j]+nums[low]+nums[high] > target1){
                        high--;
                    }else if (nums[j]+nums[low]+nums[high] < target1){
                        low++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[low]);
                        list.add(nums[high]);

                        String seq = String.format("%d.%d.%d.%d",nums[i],nums[j],nums[low],nums[high]);

                        if (!seqSet.contains(seq)){
                            result.add(list);
                            seqSet.add(seq);
                        }
                        low++;
                        high--;
                    }
                }
                finalResult.addAll(result);
            }
        }
        return finalResult;
    }

    public void quicksort(int[] a,int start,int end){
        if (a.length == 0){
            return;
        }
        int key = a[start];
        int low = start;
        int high = end;

        while(low < high){
            while(low < high && key <= a[high]){
                high--;
            }
            if (key > a[high]){
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
            while(low < high && key >= a[low]){
                low++;
            }
            if (key < a[low]){
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
        }

        if (high < end){
            quicksort(a,high+1,end);
        }
        if (low > start){
            quicksort(a,start,low-1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-5,-4,-3,-2,-1,0,0,1,2,3,4,5};//{2,3,1,2,34,14,23,78,112,11,11};
        FourSum18 fourSum18 = new FourSum18();

        List<List<Integer>> rsult = fourSum18.fourSum(a,0);

        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }

        for (List<Integer> list :rsult){
            System.out.println(list);
        }
    }



}
