public class SearchinRotatedSortedArray33 {
    public static int search(int[] nums, int target) {
        return helper(nums,0,nums.length-1,target);
    }

    /*
    二分查找，比较恶心的地方在，要判断  【7，0，1，2】 这种情况
    如果有上述情况就一直二分下去，知道找到【7，0】，
    找到之后判断num[0] num[1] 这两个点是否==targe就可以。
     */
    public static int helper(int[] nums, int left,int right,int target){
        if (left > right){
            return -1;
        }
        int mid = (left+right)/2;
        if (nums[left] > nums[right]){
            if (right - left <= 1){
                if (nums[right]==target)return right;
                if (nums[left]==target)return left;
                return -1;
            }
            System.out.println("left:"+left+"right:"+right);
            int f1 = helper(nums,left,mid,target);
            int f2 = helper(nums,mid,right,target);
            return Math.max(f1,f2);
        }else{
            if (nums[mid] > target){
                return helper(nums,left,mid-1,target);
            }else if (nums[mid] < target){
                return helper(nums,mid+1,right,target);
            }else{
                return mid;
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
    }
}
