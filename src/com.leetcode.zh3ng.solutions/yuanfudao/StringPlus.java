package com.leetcode.zh3ng.solutions.yuanfudao;

/**
 * @author zhangxingang
 * @created on 2020-09-24
 */
public class StringPlus {
    public String stringPlus(String s1, String s2){
        String longs = s1.length() >= s2.length()?s1:s2;
        String shorts = s1.length() >= s2.length()?s2:s1;

        StringBuilder sb = new StringBuilder();
        int step = 0;
        for (int i=shorts.length() -1;i>=0;i--){
            int sum = step + shorts.charAt(i) + longs.charAt(i+(longs.length()-shorts.length())) - 96;
            sb.append(sum % 10);
            step = 0;
            if (sum >=10){
                step=1;
            }
        }

        if (step == 0){
            if (longs.length() > shorts.length()){
                sb.append(new StringBuilder(longs.substring(0, longs.length()-shorts.length())).reverse());
            }
        }else {
            if (longs.length() > shorts.length()){
                for (int i = longs.length()-shorts.length()-1;i>=0;i--){
                    int sum = step + longs.charAt(i) - 48;
                    sb.append(sum%10);
                    step = 0;
                    if (sum >= 10){
                        step=1;
                    }
                }
            }else{
                sb.append(longs.substring(shorts.length(), longs.length()));
            }
            if (step == 1){
                sb.append("1");
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        StringPlus stringPlus = new StringPlus();

        System.out.println(stringPlus.stringPlus("7","98"));

        System.out.println(stringPlus.stringPlus("12","99"));

        System.out.println(stringPlus.stringPlus("12","909"));

        System.out.println(stringPlus.stringPlus("12","123"));

        System.out.println(stringPlus.stringPlus("45","123"));

        System.out.println(stringPlus.stringPlus("1","999999999999999"));

        System.out.println(stringPlus.stringPlus("0","9133"));
    }
}
