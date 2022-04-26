package com.linkai.practise.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class LeetCode226 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(4,2,7,1,3,6,9), TreeBuildMode.LEVEL);
        TreeNode expected = TreeNodeUtil.buildTree(Arrays.asList(4,7,2,9,6,3,1), TreeBuildMode.LEVEL);
        TreeNode actual = new LeetCode226().invertTree2(root);
        System.out.println("示例1，输出结果：" + (TreeNodeUtil.isEqual(expected, actual) ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(2,1,3), TreeBuildMode.LEVEL);
        TreeNode expected = TreeNodeUtil.buildTree(Arrays.asList(2,3,1), TreeBuildMode.LEVEL);
        TreeNode actual = new LeetCode226().invertTree(root);
        System.out.println("示例2，输出结果：" + (TreeNodeUtil.isEqual(expected, actual) ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = null;
        TreeNode expected = null;
        TreeNode actual = new LeetCode226().invertTree(root);
        System.out.println("示例1，输出结果：" + (TreeNodeUtil.isEqual(expected, actual) ? "成功" : "失败"));
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            swap(current, current.left, current.right);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //中序遍历交换节点
        swap(root, root.left, root.right);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode root, TreeNode left, TreeNode right) {
        root.left = right;
        root.right = left;
    }
}
