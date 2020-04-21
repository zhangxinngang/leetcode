package model;

import java.util.ArrayList;
import java.util.List;

/*
 * created by zhangxingang on 2020/04/21
 */
public class BinaryMatrixImpl implements BinaryMatrix {
    private int[][] matrix;

    public BinaryMatrixImpl(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int get(int x, int y) {
        return this.matrix[x][y];
    }

    @Override
    public List<Integer> dimensions() {
        List<Integer> result = new ArrayList<>();
        result.add(matrix.length);
        result.add(matrix[0].length);
        return result;
    }
}
