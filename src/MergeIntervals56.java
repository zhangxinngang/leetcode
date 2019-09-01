import java.util.ArrayList;
import java.util.List;

public class MergeIntervals56 {
    public static int[][] merge(int[][] intervals){
        if (intervals.length == 0){
            return intervals;
        }
        sort(intervals,0,intervals.length-1);
        List<int[]> result = new ArrayList<>();
        int[] a = intervals[0];
        for (int[] ints:intervals){
            if (a[1] > ints[0]){
                a[1] = a[1]>ints[1]?a[1]:ints[1];
            }else{
                result.add(a);
                a = ints;
            }
        }
        result.add(a);

        int[][] finallist = new int[result.size()][2];
        int i = 0;
        for (int[] array :result){
            finallist[i] = array;
            i++;
        }
        return finallist;
    }

    public static void sort(int[][] i,int low,int high){
        int start = low;
        int end = high;
        int key = i[start][0];
        while(start < end){
            while(start < end && key <= i[end][0]){
                end--;
            }
            if (key > i[end][0]){
                int[] temp = i[end];
                i[end] = i[start];
                i[start] = temp;
            }
            while(start < end && key >= i[start][0]){
                start++;
            }
            if (key < i[start][0]){
                int[] temp = i[end];
                i[end] = i[start];
                i[start] = temp;
            }
        }
        if (start > low){
            sort(i,low,start-1);
        }
        if (end < high){
            sort(i,end+1,high);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                new int[]{1,3},
                new int[]{2,6},
                new int[]{15,16},
                new int[]{7,10},
        };
        int[][] result = merge(intervals);

        for (int i=0;i< result.length;i++){
            System.out.println(result[i][0]+" "+result[i][1]);
        }
    }
}
