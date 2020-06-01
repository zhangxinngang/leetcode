package com.leetcode.zh3ng.solutions.june30days;

import model.TreeNode;

/**
 * @author zhangxingang
 * @created on 2020-06-01
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode root){
        if (root == null){
            return root;
        }

        if (root.left != null){
            root.left = dfs(root.left);
        }

        if (root.right != null){
            root.right = dfs(root.right);
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l3 = new TreeNode(3);

        TreeNode l6 = new TreeNode(6);
        TreeNode l9 = new TreeNode(9);

        TreeNode l2 = new TreeNode(2,l1,l3);
        TreeNode l7 = new TreeNode(7,l6,l9);

        TreeNode root = new TreeNode(4,l2,l7);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        TreeNode rootFinal = invertBinaryTree.invertTree(root);

        System.out.println(rootFinal.val);

    }
}
