package com.linkai.practise.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 */
public class LeetCode111 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(3,9,20,null,null,15,7), TreeBuildMode.DEFAULT);
        int expected = 2;
        int actual = new LeetCode111().minDepth2(root);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(2,null,3,null,4,null,5,null,6), TreeBuildMode.DEFAULT);
        int expected = 5;
        int actual = new LeetCode111().minDepth2(root);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth2(root.left);
        int rightDepth = minDepth2(root.right);

        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        }

        if (root.left != null && root.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
