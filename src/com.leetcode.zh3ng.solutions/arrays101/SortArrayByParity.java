package com.leetcode.zh3ng.solutions.arrays101;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-05-21
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    /**
     * Time - O(n)    Space - O(n)    change orgin array
     */
    public int[] sortArrayByParity2(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end){
            if (array[start] % 2 != 0){
                if (array[end] % 2 == 0){
                    int i = array[start];
                    array[start] = array[end];
                    array[end] = i;
                }else{
                    end--;
                    continue;
                }
            }else{
                start++;
                continue;
            }
        }
        return array;
    }

    /**
     * Time - O(2n)    Space - O(3n)    not change origin array
     */
    public int[] sortArrayByParity(int[] array) {
        List<Integer> oddList = new LinkedList<>();
        List<Integer> evenList = new LinkedList<>();

        for (Integer i:array){
            if (i % 2 == 0){
                evenList.add(i);
            }else{
                oddList.add(i);
            }
        }
        evenList.addAll(oddList);
        int[] a = new int[evenList.size()];
        int i = 0;
        for (Integer integer:evenList){
            a[i] = integer;
            i++;
        }
        return a;
    }

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        int[] a = s.sortArrayByParity(new int[]{3,1,2,4});

        for (Integer i :a){
            System.out.println(i);
        }
        System.out.println("ssssssss");


        int[] b = s.sortArrayByParity2(new int[]{3,2,1,4,5,6});
        for (Integer i :b){
            System.out.println(i);
        }
        System.out.println("ssssssss");
    }
}

