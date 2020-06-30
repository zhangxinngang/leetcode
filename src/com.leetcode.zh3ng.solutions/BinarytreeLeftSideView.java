package com.leetcode.zh3ng.solutions;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangxingang
 * @created on 2020-06-30
 *
 * 二叉树的左视图
 *
 *   ->        0
 *           /  \
 *   ->     1    2
 *         / \   / \
 *   ->   3  4  5  6
 *             /
 *   ->       7
 *
 *   结果 0，1，3，7
 */
public class BinarytreeLeftSideView {
    Set<Integer> layerSet = new HashSet<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> solution(TreeNode root){
        dfs(root, 1);
        return result;
    }

    public void dfs(TreeNode root, int layer){
        if (!layerSet.contains(layer)){
            layerSet.add(layer);
            result.add(root.val);
        }

        if (root.left != null){
            dfs(root.left, layer+1);
        }
        if (root.right != null){
            dfs(root.right, layer+1);
        }
    }

    public static void main(String[] args) {
        BinarytreeLeftSideView binarytreeLeftSideView = new BinarytreeLeftSideView();
        TreeNode root = new TreeNode(0);
        TreeNode root11 = new TreeNode(1);
        TreeNode root12 = new TreeNode(2);
        root.left = root11;
        root.right = root12;

        TreeNode root21 = new TreeNode(3);
        TreeNode root22 = new TreeNode(4);
        TreeNode root23 = new TreeNode(5);
        TreeNode root24 = new TreeNode(6);
        root11.left = root21;
        root11.right = root22;
        root12.left = root23;
        root12.right = root24;

        TreeNode root31 = new TreeNode(7);
        root23.left = root31;


        List<Integer> list = binarytreeLeftSideView.solution(root);

        System.out.println(list);
    }
}
