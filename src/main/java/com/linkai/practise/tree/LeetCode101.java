package com.linkai.practise.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class LeetCode101 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,2,2,3,4,4,3), TreeBuildMode.LEVEL);
        boolean expected = true;
        boolean actual = new LeetCode101().isSymmetric2(root);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,2,2,null,3,null,3), TreeBuildMode.LEVEL);
        boolean expected = false;
        boolean actual = new LeetCode101().isSymmetric(root);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left, right;
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            if (right == null && left == null) {
                continue;
            }

            if (right != null && left == null) {
                return false;
            }

            if (right == null && left != null) {
                return false;
            }

            if (right.val != left.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return true;
        }

        if (expected != null && actual != null) {
            if (expected.val == actual.val) {
                return isSymmetric(expected.right, actual.left) && isSymmetric(expected.left, actual.right);
            }
        }
        return false;
    }
}
