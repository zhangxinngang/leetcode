package com.leetcode.zh3ng.solutions.byteDance;

/**
 * @author zhangxingang
 * @created on 2020/6/12
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class StringMultiply {
    public String multiply(String num1, String num2) {
        int seat = num1.length() + num2.length() - 1;
        int[] multi = new int[seat];
        for (int i = 0;i<num1.length();i++){
            for (int j = 0;j<num2.length();j++){
                multi[i+j] += (num1.charAt(i)-48) * (num2.charAt(j)-48);
            }
        }

        int step = 0;
        for (int i = seat - 1;i > 0;i--){
            int sum = multi[i] + step;
            multi[i] = sum % 10;
            step = sum / 10;
        }

        multi[0] = step + multi[0];

        StringBuilder sb = new StringBuilder();
        boolean haszero = true;
        for (Integer i : multi){
            if (i != 0){
                haszero = false;
            }
            if (!haszero){
                sb.append(i);
            }
        }

        return haszero?"0":sb.toString();
    }

    public static void main(String[] args) {
        StringMultiply s = new StringMultiply();

        System.out.println(s.multiply("123","234")+"-28782");

        System.out.println(s.multiply("1235","2354")+"-2907190");

        System.out.println(s.multiply("1235","0")+"-0");
    }
}
