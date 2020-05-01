package com.leetcode.zh3ng.solutions.April30Days;

import model.TreeNode;

/**
 * @author zhangxingang
 * @created on 2020/04/30
 *
 * 点到点最长路径   思路：根的最长路径就是  左结点的最长路径 + 右结点的最长路径 + 2  每个根的最长路径找最大的结点
 *
 *
 */
public class DiameterofBinaryTreeFor30Days {
    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        depth(root);
        return max;
    }

    public int depth(TreeNode root){
        if (root == null){
            return -1;
        }
        int leftDapth = 0;
        if (root.left != null){
            leftDapth = depth(root.left)+1;
        }
        int rightDepth = 0;
        if (root.right != null){
            rightDepth = depth(root.right)+1;
        }
        int diameter = leftDapth + rightDepth;
        max = Math.max(diameter,max);

        return Math.max(leftDapth,rightDepth);
    }

    public static void main(String[] args) {
        DiameterofBinaryTreeFor30Days d = new DiameterofBinaryTreeFor30Days();

        TreeNode root = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        root.left = treeNode2;
        root.right = treeNode3;

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        System.out.println(d.depth(root));

    }
}
