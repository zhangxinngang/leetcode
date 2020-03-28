package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2020/02/01
 */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        //return uniqPath(m-1,n-1);

        if (n == 1 || m == 1){
            return 1;
        }

        if (m < n){
            int temp = m;
            m = n;
            n = temp;
        }

        long cM = m+n-2;
        long cN = n-1;

        long resultM = cM;
        for (long i = cM-1;i>cM-cN;i--){
            resultM *= i;
        }

        long resultN = cN;
        for (long i = 1;i<cN;i++){
            resultN *= i;
        }

        System.out.println(resultM+" "+resultN);
        return (int)(resultM/resultN);
    }

    private int uniqPath(int m,int n){
        if (m == 0 && n > 0){
            return uniqPath(m,n-1);
        }
        if (m > 0 && n == 0){
            return uniqPath(m-1,n);
        }

        if (m == 0 && n == 0){
            return 1;
        }

        return uniqPath(m-1,n)+uniqPath(m,n-1);
    }


    public static void main(String[] args) {
        UniquePaths62 uniquePaths62 = new UniquePaths62();

        int paths = uniquePaths62.uniquePaths(10,10);
        System.out.println(paths);
    }
}
