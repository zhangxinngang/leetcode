package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2020/01/09
 * todo not soluted
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }

        int start = -1;
        int end = -1;

        if (nums[0] == target){
            start = 0;
        }
        if (nums[nums.length-1] == target){
            end = nums.length-1;
        }
        if (start == -1){
            start = findIdxStart(nums,target);
        }

        if (end == -1){
            end = findIdxEnd(nums,target);
        }

        return new int[]{start,end};
    }


    //target condition      (nums[mid] == target && nums[mid-1] < target)
    public int findIdxStart(int[] nums,int target){
        int left = 1;
        int right = nums.length - 2;

        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target && nums[mid-1] < target){
                return mid;
            }else if (nums[mid] == target && nums[mid-1] == target){
                right = mid - 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target && nums[mid+1] == target){
                return mid+1;
            }else if (nums[mid] < target && nums[mid+1] < target){
                left = mid+1;
            }else if (nums[mid] < target && nums[mid+1] > target){
                return -1;
            }
        }
        return -1;
    }

    public int findIdxEnd(int[] nums,int target){
        int left = 1;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] == target && nums[mid+1] > target){
                return mid;
            }else if (nums[mid] == target && nums[mid+1] == target){
                left = mid + 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target && nums[mid-1] == target){
                return mid-1;
            }else if (nums[mid] > target && nums[mid-1] > target){
                right = mid-1;
            }else if (nums[mid] > target && nums[mid-1] < target){
                return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray34 f = new FindFirstAndLastPositionOfElementInSortedArray34();

        int[] idx = f.searchRange(new int[]{5,7,7,8,8,10},6);

        System.out.println(idx[0]);
        System.out.println(idx[1]);

        System.out.println("------");
        idx = f.searchRange(new int[]{1,4},4);

        System.out.println(idx[0]);
        System.out.println(idx[1]);
    }
}
