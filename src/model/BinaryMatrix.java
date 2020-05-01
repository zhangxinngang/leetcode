package model;

import java.util.List;

/**
 * created by zhangxingang on 2020/04/21
 * a Matrix
 *
 * |--------- m ------|
 * --------------------
 * |   |  x x x x .. x|
 * |   |  x x x x .. x|
 * n   |  x x x x .. x|
 * |   |  x x x x .. x|
 * |   |  x x x x .. x|
 * --------------------
 */
public interface BinaryMatrix {
    public int get(int x, int y);
    public List<Integer> dimensions();
}
