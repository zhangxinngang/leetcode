import java.util.HashMap;

/*
 * created by zhangxingang on 2019/08/21
 */
public class PerfectSquares279 {

    //四方定理：所有自然数，最多可以用4个数的平方表示。
    private static HashMap<Integer,Integer> resultMap = new HashMap<>();

    public static int solution(int n){
        int result =  solute(n,0);
        return result;
    }

    public static int solute(int n,int count){
        if (n == 1){
            return 1+count;
        }
        if (resultMap.containsKey(n)){
            return resultMap.get(n)+count;
        }
        int half = (int) Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for (int i = half;i> 0;i--){
            if (i*i > n){
                continue;
            }else if (i*i == n){
                //System.out.print(i*i+" ");
                return 1+count;
            }else if (i*i < n){
                //System.out.print(i*i+" ");
                int res = solute(n-i*i,count)+1;
                min = res>=min?min:res;
                if (i == 80&&n==7168){
                    System.out.println("i:"+i+" min:"+min+" n:"+n+" res:"+res+" sub:"+(n-i*i)+" "+count);
                }
            }
        }
        resultMap.put(n,min);
        return min;
    }

    public static int f(int n, int a[], int idx) {
        if (n==0) // 填空1
            return 1;
        if (idx == 4)
            return 0;

        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            a[idx] = i;

            if (f(n-i*i, a, idx+1) == 1) // 填空2
                return 1;
        }
        return 0;
    }

    public int numSquares(int n) {
        int[] map = new int[n + 1];
        return numSquaresHelper(n, map);
    }

    public int numSquaresHelper(int n, int[] map) {
        if (n < 4)
            return n;

        if (map[n] != 0)
            return map[n];

        int root = (int)Math.sqrt(n);
        int res = Integer.MAX_VALUE;
        for (int i = root; i >= 1; i--) {
            int num = n / (i * i);
            int remain = numSquaresHelper(n - num * i * i, map);
            if (remain + num < res)
                res = remain + num;
        }

        map[n] = res;
        return res;
    }

    public static void main(String[] args) {
//        for (int i = 1;i<8000;i++){
//            if (solution(i)>4){
//                System.out.println(i);
//            }
//        }
        System.out.println("asdfsdfsdfds");
        System.out.println(solution(7168));

        int a[] = { 0, 0, 0, 0 };
        f(7168,a,0);

        for(int i = 0;i<4;i++){
            System.out.println(a[i]);
        }
    }
}
