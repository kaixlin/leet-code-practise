package com.linkai.practise.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]
 *
 *
 * 返回它的最大深度 3 。
 */
public class LeetCode104 {

    public static void main(String[] args) {
        example1();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(3,9,20,null,null,15,7), TreeBuildMode.LEVEL);
        int expected = 3;
        int actual = new LeetCode104().maxDepth2(root);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        TreeNode current;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (current == null) {
                    continue;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
