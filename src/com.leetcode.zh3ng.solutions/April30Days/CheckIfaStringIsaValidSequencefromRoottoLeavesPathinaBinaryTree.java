package com.leetcode.zh3ng.solutions.April30Days;

import model.TreeNode;

/**
 * @author zhangxingang
 * @created on 2020/04/30
 */
public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root,arr,0);
    }

    public boolean dfs(TreeNode root,int[] arr, int index){
        if (index == arr.length-1){
            return root.val == arr[index] && root.right == null && root.left == null;
        }
        if (root.val != arr[index]){
            return false;
        }
        boolean ok = false;
        if (index < arr.length-1 && root.left != null && root.left.val == arr[index+1]){
            ok |= dfs(root.left,arr,index+1);
        }
        if (index < arr.length-1 && root.right != null && root.right.val == arr[index+1]){
            ok |= dfs(root.right,arr,index+1);
        }
        return ok;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode roo9 = new TreeNode(1);
        root.left = roo9;
        TreeNode roo20 = new TreeNode(0);
        root.right = roo20;

        TreeNode root2 = new TreeNode(0);
        roo9.left = root2;

        TreeNode root3 = new TreeNode(1);
        roo9.right = root3;

        CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree c = new CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree();

        System.out.println(c.isValidSequence(root,new int[]{0,1,1}));
    }
}
