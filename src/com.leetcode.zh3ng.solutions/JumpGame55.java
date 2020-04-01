package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2020/04/01
 */
public class JumpGame55 {
    /**
     * 从倒数第二个数开始    数值要大于 1 如果是否  倒数第三个要大于2 以此类推。
     * 当某个位置i的数大于要求的步数，那么i-1位置的数要大于1，重复前面步骤
     * 知道走到第一个位置，第一个位置的数要大于needstep
     *
     * 如果只有一个，直接返回true
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return nums[0] >= 0;
        }
        int needStep = 1;
        for (int i = nums.length - 2;i > 0;i--){
            boolean reach = nums[i] >= needStep;
            if (!reach) {
                needStep++;
            }else{
                needStep = 1;
            }
        }
        return nums[0] >= needStep;
    }

    public static void main(String[] args) {
        JumpGame55 jumpGame55 = new JumpGame55();

        int[] nums = new int[]{3,2,1,0,4};

        System.out.println(jumpGame55.canJump(nums));
    }
}
