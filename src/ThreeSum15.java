import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {
    public static List<List<Integer>> threeSum(int[] nums){
        sort(nums,0,nums.length-1);
        System.out.println(nums[0]+","+nums[nums.length-1]);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            int key = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                int sum = nums[l]+nums[r]+key;
                if (sum > 0){
                    r = r-1;
                }else if (sum < 0){
                    l = l+1;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(key);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    r = r-1;
                    l = l+1;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void sort(int[] a,int low,int high){
        if (a.length ==0){
            return;
        }
        int start = low;
        int end = high;
        int key = a[start];
        while(start < end){
            while(start < end && key <= a[end]){
                end--;
            }
            if (key > a[end]){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while(start < end && key >= a[start]){
                start++;
            }
            if (key < a[start]){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
        }
        if (start > low){
            sort(a,low,start-1);
        }
        if (end < high){
            sort(a,end+1,high);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(num);

        System.out.println(result);
    }

}
