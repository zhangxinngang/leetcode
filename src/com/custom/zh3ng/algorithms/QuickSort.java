package com.custom.zh3ng.algorithms;

/**
 * @author zhangxingang
 * @created on 2019/11/22
 */
public class QuickSort {
    public void sort(int[] a,int low,int high) {
        int start = low;
        int end = high;
        int key = a[end];

        while (start < end){
            while (start < end && key >= a[start]){
                start++;
            }
            if (key < a[start]){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }

            while (start < end && key <= a[end]){
                end--;
            }
            if (key > a[end]){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if (start > low){
            sort(a, low, start-1);
        }
        if (end < high){
            sort(a, end+1, high);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,2,34,14,23,78,112,11,11};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(a,0,a.length-1);

        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }

}
