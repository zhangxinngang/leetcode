package com.leetcode.zh3ng.solutions.arrays101;

/**
 * @author zhangxingang
 * @created on 2020-05-12
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] aA) {
        int[] result = new int[aA.length];
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0;i<aA.length;i++){
            aA[i] = aA[i] * aA[i];
            if (aA[i] < min){
                min = aA[i];
                minIdx = i;
            }
        }
        int left = minIdx -1;
        int right = minIdx + 1;
        int c = 0;
        result[c] = aA[minIdx];
        c++;
        while(left > -1 || right < aA.length){
            if (left > -1 && right < aA.length){
                int leftNum = aA[left];
                int rightNum = aA[right];
                if (leftNum > rightNum){
                    result[c] = rightNum;
                    right++;
                }else{
                    result[c] = leftNum;
                    left--;
                }
                c++;
            }else if (left <= -1 && right < aA.length){
                result[c] = aA[right];
                c++;
                right++;
            }else if (left > -1 && right >= aA.length){
                result[c] = aA[left];
                left--;
                c++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresofaSortedArray s = new SquaresofaSortedArray();
        int[] result = s.sortedSquares(new int[]{-7,-3,2,3,11});
        for(Integer i:result){
            System.out.println(i);
        }
    }
}
