public class SpiralMatrixII59 {
    public static int[][] generateMatrix(int nlen) {
        int[][] result = new int[nlen][nlen];
        int l = nlen%2;
        int c = 1;
        for (int i = 0;i<nlen/2;i++){
            for (int n = i;n<nlen-i-1;n++){
                result[i][n] = c;
                c++;
            }
            for (int n = i;n<nlen-i-1;n++){
                result[n][nlen-i-1] = c;
                c++;
            }
            for (int n = nlen-i-1;n>i;n--){
                result[nlen-i-1][n]=c;
                c++;
            }
            for (int n = nlen-i-1;n>i;n--){
                result[n][i] = c;
                c++;
            }
        }
        if (l == 1){
            result[nlen/2][nlen/2]=c;
            c++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] a = generateMatrix(n);

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
