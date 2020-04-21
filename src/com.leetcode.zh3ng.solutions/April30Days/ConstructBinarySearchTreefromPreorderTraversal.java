package com.leetcode.zh3ng.solutions.April30Days;

import model.TreeNode;

/**
 * created by zhangxingang on 2020/04/20
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val,
 * and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first,
 * then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *            8
 *          /  \
 *         5   10
 *        / \    \
 *       1  7    12
 * Note:
 *
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1;i<preorder.length;i++){
            addTree(root,preorder[i]);
        }
        return root;
    }

    public void addTree(TreeNode now, int v){
        if (now.val > v){
            if (now.left == null){
                now.left = new TreeNode(v);
                return;
            }else{
                addTree(now.left,v);
            }
        }
        if (now.val < v){
            if (now.right == null){
                now.right = new TreeNode(v);
            }else{
                addTree(now.right,v);
            }
        }
    }

    public static void main(String[] args) {
        ConstructBinarySearchTreefromPreorderTraversal c = new ConstructBinarySearchTreefromPreorderTraversal();

        TreeNode root = c.bstFromPreorder(new int[]{8,5,1,7,10,12});

        System.out.println(root.val);
    }
}
