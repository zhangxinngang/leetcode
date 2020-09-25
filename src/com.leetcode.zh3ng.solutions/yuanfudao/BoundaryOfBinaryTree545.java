package com.leetcode.zh3ng.solutions.yuanfudao;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020/9/23
 */
public class BoundaryOfBinaryTree545 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        dfs(root, true, true);
        return result;
    }

    private void dfs(TreeNode node, boolean leftBound, boolean rightBound) {
        if (node == null) {
            return;
        }
        if (leftBound) {
            result.add(node.val);
        } else if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        dfs(node.left, leftBound, !leftBound && rightBound && node.right == null);
        dfs(node.right, !rightBound && leftBound && node.left == null, rightBound);
        if (!leftBound && rightBound) {
            result.add(node.val);
        }
    }

}
