package com.linkai.practise.tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class TreeNode102 {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(3,9,20,null,null,15,7), TreeBuildMode.LEVEL);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3), Arrays.asList(9,20), Arrays.asList(15,7));
        List<List<Integer>> actual = new TreeNode102().levelOrder(root);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1), TreeBuildMode.LEVEL);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1));
        List<List<Integer>> actual = new TreeNode102().levelOrder(root);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = null;
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> actual = new TreeNode102().levelOrder(root);
        System.out.println("示例3，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        TreeNode current;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> resultItem = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                resultItem.add(current.val);
            }
            result.add(resultItem);
        }
        return result;
    }
}
