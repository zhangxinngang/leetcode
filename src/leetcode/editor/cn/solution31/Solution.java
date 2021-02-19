package leetcode.editor.cn.solution31;
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
//ssible order (i.e., sorted in ascending order). 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [1,3,2]
// Example 2: 
// Input: nums = [3,2,1]
//Output: [1,2,3]
// Example 3: 
// Input: nums = [1,1,5]
//Output: [1,5,1]
// Example 4: 
// Input: nums = [1]
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 936 👎 0


import cucumber.api.java.en_pirate.Aye;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1){
            return;
        }
        boolean ok = false;
        for (int from = nums.length - 2;from >= 0;from--){
            if (isDescOrder(nums, from)){
                ok = true;
                continue;
            }else{
                if (ok){
                    for (int i = nums.length - 1; i > from;i--){
                        if (nums[i] > nums[from]){
                            int m = nums[from];
                            nums[from] = nums[i];
                            nums[i] = m;

                            Arrays.sort(nums, from+1, nums.length);
                            return;
                        }
                    }
                }else{
                    next(nums, from);
                    return;
                }
            }
        }
        if (isDescOrder(nums, 0)){
            reserve(nums);
        }
    }

    public void next(int[] nums, int from){
        int n = nums[nums.length - 1];
        int id = nums.length - 1;
        for (int i = nums.length - 1; i>=from;i--){
            if (n <= nums[i]){
                n = nums[i];
                id = i;
                continue;
            }else {
                int m = nums[id];
                nums[id] = nums[i];
                nums[i] = m;
                return;
            }
        }
    }

    public void reserve(int[] nums){
        for (int i=0;i<nums.length/2;i++){
            int n = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = n;
        }
    }

    public boolean isDescOrder(int[] nums, int from){
        if (nums.length == 0){
            return false;
        }
        int n = nums[from];
        for (int i = from+1;i<nums.length;i++){
            if (nums[i] > n){
                return false;
            }
            n = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,5,1,1};

        solution.nextPermutation(nums);
        for (int i:nums){
            System.out.print(i+",");
        }


    }
}


//leetcode submit region end(Prohibit modification and deletion)
