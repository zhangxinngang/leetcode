package com.leetcode.zh3ng.solutions.yuanfudao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020/9/23
 */
public class RestoreIpAddresses93 {


    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12){
            return result;
        }
        for (int a = 1; a< 4;a++){
            for(int b = 1; b< 4;b++){
                for (int c = 1;c < 4; c++){
                    for (int d = 1;d < 4;d++){
                        if ((a + b+ d + c) != s.length()){
                            continue;
                        }
                        int num1 = Integer.valueOf(s.substring(0, a));
                        if (num1 > 255){
                            continue;
                        }
                        int num2 = Integer.valueOf(s.substring(a, a+b));
                        if (num2 > 255) {
                            continue;
                        }
                        int num3 = Integer.valueOf(s.substring(a+b,a+b+c));
                        if (num3 > 255){
                            continue;
                        }
                        int num4 = Integer.valueOf(s.substring(a+b+c));
                        if (num4 > 255){
                            continue;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(num1).append(".").append(num2).append(".").append(num3).append(".").append(num4);
                        if (sb.length() == s.length()+3){
                            result.add(sb.toString());
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RestoreIpAddresses93 restoreIpAddresses93 = new RestoreIpAddresses93();

        System.out.println(restoreIpAddresses93.restoreIpAddresses("25525511135"));
    }

}
