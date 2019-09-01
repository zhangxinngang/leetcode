/* 给一个N*N的矩阵，螺旋输出
    1 , 2, 3, 4
    5 , 6, 7, 8
    9 ,10,11,12
    13,14,15,16

    print
    1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 */


import java.util.ArrayList;
import java.util.List;

public class ScrewMatrics {
    public static List<Integer> print(int[][] m){
        List<Integer> result = new ArrayList<>();
        int l = m.length%2;
        for (int i = 0;i<m.length/2;i++){
            for (int n = i;n<m.length-i-1;n++){
                System.out.print(m[i][n]+" ");
                result.add(m[i][n]);
            }
            for (int n = i;n<m.length-i-1;n++){
                System.out.print(m[n][m.length-i-1]+" ");
                result.add(m[n][m.length-i-1]);
            }
            for (int n = m.length-i-1;n>i;n--){
                System.out.print(m[m.length-i-1][n]+" ");
                result.add(m[m.length-i-1][n]);
            }
            for (int n = m.length-i-1;n>i;n--){
                System.out.print(m[n][i]+" ");
                result.add(m[n][i]);
            }
        }
        if (l == 1){
            System.out.println(m[m.length/2][m.length/2]);
            result.add(m[m.length/2][m.length/2]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9 ,10,11,12},
                new int[]{13,14,15,16},
        };
        int[][] n = new int[][]{
                new int[]{1,2,3},
                new int[]{5,6,7},
                new int[]{9 ,10,11},
        };
        print(m);
    }
}
