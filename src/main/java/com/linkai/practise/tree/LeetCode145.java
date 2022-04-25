package com.linkai.practise.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 提示：
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class LeetCode145 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,null,2,3));
        List<Integer> expected = Arrays.asList(3,2,1);
        List<Integer> actual = new LeetCode145().postorderTraversal(root);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = null;
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new LeetCode145().postorderTraversal(root);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1));
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = new LeetCode145().postorderTraversal(root);
        System.out.println("示例3，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
