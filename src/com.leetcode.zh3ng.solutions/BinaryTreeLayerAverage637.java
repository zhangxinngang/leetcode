package com.leetcode.zh3ng.solutions;

import model.TreeNode;

import java.util.*;

/**
 * @author zhangxingang
 * @created on 2020/9/12
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 */
public class BinaryTreeLayerAverage637 {
    private Map<Integer, Long[]> layerMap = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 1);
        List<Double> average = new ArrayList<>();
        for (int i = 1; i <= layerMap.size(); i++){
            Long[] list = layerMap.get(i);
            if (list != null){
                average.add(new Double(list[0])/list[1]);
            }
        }
        return average;
    }

    private void dfs(TreeNode root, int layer){
        if (root == null){
            return;
        }
        if (layerMap.containsKey(layer)){
            Long[] list = layerMap.get(layer);
            list[0] += root.val;
            list[1] += 1;
        }else{
            Long[] list = new Long[2];
            list[0] = (long)root.val;
            list[1] = 1L;
            layerMap.put(layer, list);
        }
        dfs(root.left, layer+1);
        dfs(root.right, layer+1);
    }

    public static void main(String[] args) {
        BinaryTreeLayerAverage637 b = new BinaryTreeLayerAverage637();

        TreeNode root = new TreeNode(3);

        TreeNode root1 = new TreeNode(9);
        root.left = root1;
        TreeNode root2 = new TreeNode(20);
        root.right = root2;

        TreeNode root3 = new TreeNode(15);
        root2.left = root3;
        TreeNode root4 = new TreeNode(7);
        root2.right = root4;

        System.out.println(b.averageOfLevels(root));

    }
}
