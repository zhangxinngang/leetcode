/*
 * created by zhangxingang on 2019/08/14
 */
public class LongestCommonPrefix14 {
    public static String solution(String[] strs){
        int min = minLen(strs);
        String s = "";
        for (int i = 0;i < min;i++){
            Character c = strs[0].charAt(i);
            for (String str:strs){
                if (str.charAt(i) != c){
                    return s;
                }
            }
            s += c;
        }
        return s;
    }

    public static int minLen(String[] strs){
        if (strs.length == 0){
            return 0;
        }
        int min = strs[0].length();
        for (int i = 1;i < strs.length;i++){
            if (strs[i].length() < min){
                min = strs[i].length();
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String r = solution(new String[]{"abcdef","abcde","abc"});
        System.out.println(r);
    }


}
