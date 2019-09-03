package com.leetcode.zh3ng.solutions;

import java.util.HashSet;
import java.util.Set;

/*
 * created by zhangxingang on 2019/08/28
 *
 * 超时，代码不好看
 */
@Deprecated
public class MaxPointsOnALine149 {
    public static int solution(int[][] points){
        if (points.length <=2){
            return points.length;
        }
        int max = 0;
        Set<String> set = new HashSet<>();
        for (int i=0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                double[] keydouble = solut(points[i][0],points[i][1],points[j][0],points[j][1]);
                String key = getKey(keydouble);
                set.add(key);
            }
        }
        for (String key:set){
            int keyMax = 0;
            for(int i= 0;i<points.length;i++){
                System.out.println("aaaaa"+key);
                String[] strs = key.split(",");
                if (inLine(strs,points[i][0],points[i][1])){
                    keyMax++;
                }
            }
            if (max < keyMax){
                max = keyMax;
            }
        }
        return max;
    }

    public static String getKey(double[] nums){
        return String.format("%s,%s,%s",nums[0],nums[1],nums[2]);
    }

    public static boolean inLine(String[] s,int x,int y){
        if (s.length < 3){
            return false;
        }
        double[] nums = new double[3];
        for (int i = 0;i<3;i++){
            nums[i] = Double.valueOf(s[i]);
        }
        if (nums[0] == nums[1]&& nums[1] == 0){
            return x == nums[2];
        }
        return Math.abs(y-(nums[0]*x + nums[1]))<1e-6;
    }

    public static double[] solut(int x1,int y1,int x2,int y2){
        double[] result = new double[3];
        if (x1-x2 == 0){
            result[2] = x1;
            return result;
        }
        double a = (double)(y1-y2)/(double)(x1-x2);
        double b = y1-a*x1;
        result[0] = a;
        result[1] = b;
        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                new int[]{0,-1},
                new int[]{0,3},
                new int[]{0,-4},
                new int[]{0,-2},
//                new int[]{4,1},
//                new int[]{2,3},
//                new int[]{1,4},
                };
        int max = solution(points);
        System.out.println("max:"+max);
    }
}
