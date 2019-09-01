import java.util.HashMap;
import java.util.Map;

/*
 * created by zhangxingang on 2019/08/27
 */
public class SingleNumber136 {
    public static int solution(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else{
                map.put(nums[i],1);
            }
        }
        for (Integer i:map.keySet()){
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2,1};
        System.out.println(solution(a));
    }
}
