package com.leetcode.zh3ng.solutions;

public class LongestPalindromicSubstring5 {
    public static String longestPalindrome(String s) {
        System.out.println(s);
        String result = s.length()>0?s.substring(0,1):"";
        int l = s.length();
        System.out.println("l:"+l);
        for(int i = 0;i<=l;i++) {
            for (int r = result.length()/2; r <= i && r + i <= l - 1; r++) {
                if (!isPalindrome(s.substring(i - r, i + r + 1))) {
                    continue;
                } else {
                    result = s.substring(i - r, i + r + 1);
                }
            }
            System.out.println("......" + i);
        }
        for(int i = 0;i<=l;i++){
            for (int r = result.length()/2;r<=i&&r+i<l-1;r++){
                System.out.println("i:"+i+" r:"+r);
                System.out.println(s.substring(i-r,i+r+2));
                if (!isPalindrome(s.substring(i-r,i+r+2))){
                    continue;
                } else{
                    result = s.substring(i-r,i+r+2);
                }
            }
        }

        return result;
    }

    public static boolean isPalindrome(String s){
        int l = s.length();
        int mid = l/2;
        if (l%2 == 0 && mid > 0){  //偶数  abba
            if (s.charAt(mid) != s.charAt(mid-1)){
                return false;
            }
            for (int i=0;i<mid;i++){
                if (s.charAt(mid-1-i)!=s.charAt(mid+i)){
                    return false;
                }
            }
        }else{ //奇数   aba
            for (int i=0;i<=mid;i++){
                if (s.charAt(mid-i)!=s.charAt(mid+i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
//        System.out.println(longestPalindrome("bb")+" excpet bb");
//
//
//        System.out.println(longestPalindrome("abbc")+" excpet bb");
//        System.out.println(longestPalindrome("asdfdsaabdbaasdfds")+" excpet dfdsaabdbaasdfd");
//        System.out.println(longestPalindrome("")+" excpet ");
//        System.out.println(longestPalindrome("a")+" excpet a");

        System.out.println(longestPalindrome("ccc")+" excpet ccc");

        //System.out.println(isPalindrome("aaab"));
    }
}
