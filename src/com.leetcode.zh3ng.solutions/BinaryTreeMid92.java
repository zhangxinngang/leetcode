package com.leetcode.zh3ng.solutions;

import model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangxingang
 * @created on 2020-09-14
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreeMid92 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traval(root, list);
        return list;
    }

    private void traval(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        traval(root.left, result);
        result.add(root.val);
        traval(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode root1 = new TreeNode(2);
        root.right = root1;
        TreeNode root2 = new TreeNode(3);
        root1.left = root2;

        BinaryTreeMid92 binaryTreeMid92 = new BinaryTreeMid92();
        System.out.println(binaryTreeMid92.inorderTraversal(root));
    }
}
