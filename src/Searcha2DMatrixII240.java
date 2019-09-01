public class Searcha2DMatrixII240 {

    public static boolean solution(int[][] m,int target){
        if (m.length == 0 || m[0].length == 0){
            return false;
        }
        int x = m[0].length-1;
        int y = 0;
        while(x >=0&&y<m.length){
            System.out.println(m[y][x]);
            System.out.println("y:"+y+"x:"+x);
            if (target == m[y][x]){
                return true;
            }else if (target > m[y][x]){
                y++;
            }else{
                x--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] m = new int[][]{
//                new int[]{1,   4,  7, 11, 15},
//                new int[]{2,   5,  8, 12, 19},
//                new int[]{3,   6,  9, 16, 22},
//                new int[]{10, 13, 14, 17, 24},
//                //new int[]{18, 21, 23, 26, 30}
//        };

        int[][] m = new int[][]{
                new int[]{1},
                new int[]{1},
                //new int[]{6},
        };

        System.out.print(solution(m,1));
    }
}
