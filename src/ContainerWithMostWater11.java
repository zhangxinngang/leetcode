public class ContainerWithMostWater11 {
    public static int maxArea(int[] height){
        int max = 0;
        for (int i = 0;i<height.length;i++){
            for (int j = height.length-1;j>i;j--){
                int area = getArea(i,height[i],j,height[j]);
                if (max < area){
                    max = area;
                }
            }
        }
        return max;
    }

    public static int getArea(int index1,int h1,int index2,int h2){
        return (index2-index1)*Math.min(h1,h2);
    }

    public static int solution2(int[] height){
        int max = 0;
        int start = 0;
        int end = height.length-1;
        while(start < end){
            int area = getArea(start,height[start],end,height[end]);
            if (area > max){
                max = area;
            }
            if (height[start] > height[end]){
                end--;
            }else{
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] hs = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.print(solution2(hs));
    }
}
