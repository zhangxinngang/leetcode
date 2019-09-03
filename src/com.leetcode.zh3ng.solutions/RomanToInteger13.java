package com.leetcode.zh3ng.solutions;

import java.util.HashMap;
import java.util.Map;

/*
 * created by zhangxingang on 2019/08/12
 */
public class RomanToInteger13 {
    public static int solution(String s){
        char[] chars = s.toUpperCase().toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int total = 0;
        int thisValue = 0;
        int lastValue = map.get(chars[0]);

        for(int i = 1;i<chars.length;i++){
            thisValue = map.get(chars[i]);
            System.out.println(chars[i]+" "+thisValue+" "+lastValue+" "+total);
            if (lastValue == 0){
                lastValue = thisValue;
                continue;
            }

            if (thisValue > lastValue){
                total += thisValue - lastValue;
                lastValue = 0;
            }else{
                total += lastValue;
                lastValue = thisValue;
            }
        }
        total += lastValue;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(solution("LVIII"));
    }
}
