package com.leetcode.zh3ng.solutions.April30Days;

import model.TreeNode;

/**
 * created by zhangxingang on 2020/04/29
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    //遍历到的最大path和
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int sum = maxChildSum(root);
        return max>sum?max:sum;
    }

    //返回 算上root结点 的最大 path的和
    public int maxChildSum(TreeNode root){
        if (root.val > max){
            max = root.val;
        }
        if (root.left == null && root.right == null){
            return root.val;
        }
        Integer left = null;
        Integer right = null;
        if (root.left != null){
            left = maxChildSum(root.left);
        }
        if (root.right != null){
            right = maxChildSum(root.right);
        }
        int sum = root.val;
        if (left != null && right != null && sum < root.val + left + right){
            sum = root.val + left + right;
        }
        if (left != null && sum < root.val + left){
            sum = root.val + left;
        }
        if (right != null && sum < root.val + right){
            sum = root.val + right;
        }
        if (right != null && sum < right){
            sum = right;
        }
        if (left != null && sum < left){
            sum = left;
        }
        if (sum > max){
            max = sum;
        }
        int result = root.val;
        if (left != null && right != null){
            if (root.val + Math.max(left,right) > result){
                result = root.val + Math.max(left,right);
            }
        }else if (left == null && right != null){
            if (root.val + right > result){
                result = root.val + right;
            }
        }else if (left != null && right == null){
            if (root.val + left > result){
                result = root.val + left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-2);
//        TreeNode r2 = new TreeNode(-1);
//        root.left = r2;
////        TreeNode r3 = new TreeNode(3);
////        root.right = r3;
//        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
//        System.out.println(b.maxPathSum(root));

        TreeNode roo = new TreeNode(-1);
        TreeNode roo9 = new TreeNode(5);
        roo.left = roo9;
        TreeNode roo20 = new TreeNode(4);
        roo9.left = roo20;

        TreeNode roo2 = new TreeNode(2);
        roo20.right = roo2;
        roo2.left = new TreeNode(-4);

        BinaryTreeMaximumPathSum b1 = new BinaryTreeMaximumPathSum();
        System.out.println(b1.maxPathSum(roo));


//        TreeNode root1 = new TreeNode(1);
//        TreeNode r21 = new TreeNode(-2);
//        root1.left = r21;
//        TreeNode r31 = new TreeNode(3);
//        root1.right = r31;
//        BinaryTreeMaximumPathSum b1 = new BinaryTreeMaximumPathSum();
//        System.out.println(b1.maxPathSum(root1));
    }

}
