package com.linkai.practise.tree;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode94 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,null,2,3));
        List<Integer> expected = Arrays.asList(1,3,2);
        List<Integer> actual = new LeetCode94().inorderTraversal2(root);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = null;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new LeetCode94().inorderTraversal(root);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1));
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = new LeetCode94().inorderTraversal(root);
        System.out.println("示例3，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
