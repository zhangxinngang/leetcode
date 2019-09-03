package com.leetcode.zh3ng.solutions;

/*
 * created by zhangxingang on 2019/05/10
 * leetcode 43
 */
public class MultiplyStrings {

    public static String reverse(String num){
        String result = "";
        for (int i = num.length()-1;i >= 0;i--){
            result += num.charAt(i);
        }
        return result;
    }

    public static String addTwo(String numlong,String numshort){
        //长的string在前面
        if (numshort.length() > numlong.length()){
            String temp = numlong;
            numlong = numshort;
            numshort = temp;
        }
        String reuslt = "";
        int n = 0;
        for (int i = numlong.length()-1;i>=0;--i){
            char c1 = numlong.charAt(i);
            if (i >= numlong.length() - numshort.length()){
                char c2 = numshort.charAt(i-(numlong.length()-numshort.length()));
                int add = Integer.valueOf(String.valueOf(c1))+Integer.valueOf(String.valueOf(c2));
                reuslt = (add+n)%10 +reuslt;
                if (n > 0 && add+n < 10){
                    n = 0;
                }
                if (add+n >= 10){
                    n = (add+n)/10;
                }
            }else{
                int add = Integer.valueOf(String.valueOf(c1))+n;
                reuslt = add%10 +reuslt;
                if (n > 0){
                    n = 0;
                }
                if (add >= 10){
                    n = add/10;
                }
            }
        }
        if (n>0){
            reuslt = n + reuslt;
        }
        return reuslt;
    }

    public static String multiplySingle(String num1,String single,int m){
        //乘个位数 324435 X 2
        if (single == "0"){
            return "0";
        }
        int n = 0;
        String result = "";
        for (int i = num1.length()-1;i >=0;i--){
            int multi = Integer.valueOf(String.valueOf(num1.charAt(i)))*Integer.valueOf(single);
            result = String.valueOf((multi%10+n)%10)+result;
            if (n != 0 && (multi%10+n)<10){
                n = 0;
            }
            if ((multi+n) >= 10){
                n = (multi+n)/10;
            }
        }
        if (n != 0){
            result = n+result;
        }
        String res0 = "";
        for (int i = 0;i<m;i++){
            res0 += "0";
        }

        return result+res0;
    }

    public static String multiply(String num1, String num2) {
        if (num1.length() > num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //短的在前面 num1
        int n = 0;
        String[] results = new String[num1.length()+num2.length()+1];
        for(int i = num1.length()-1;i>=0;i--){
            String r1 = multiplySingle(num2,String.valueOf(num1.charAt(i)),num1.length()-1-i);
            System.out.println("single multi result:"+r1+" num1:"+num1.charAt(i));
            results[i] = r1;
        }

        String result = "0";
        System.out.println(results);
        for (int i = 0;i<results.length;i++){
            if (results[i] == null){
                break;
            }
            System.out.println(results[i]);
            result = addTwo(results[i],result);
        }
        for (int i = 0;i<result.length();i++){
            if (Integer.valueOf(String.valueOf(result.charAt(i)))!=0){
                System.out.println("result.charAt"+i);
                System.out.println("result.charAt"+result.charAt(i));
                System.out.println("result.charAt"+String.valueOf(result.charAt(i))=="0");
                return result;
            }
        }
        return "0";
    }

    public static void main(String[] args) {
        //System.out.println(multiplySingle("2","9",0));
        //System.out.println(addTwo("989010","8991"));
        System.out.println(multiply("999","0"));
    }
}
