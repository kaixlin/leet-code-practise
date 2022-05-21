package com.linkai.practise.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
 *
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 示例 5：
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class LeetCode144 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
        example5();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,null,2,3));
        List<Integer> expected = Arrays.asList(1,2,3);
        List<Integer> actual = new LeetCode144().preorderTraversal2(root);
        System.out.println("示例1，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = TreeNodeUtil.buildTree(new ArrayList<>());
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new LeetCode144().preorderTraversal(root);
        System.out.println("示例2，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1));
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = new LeetCode144().preorderTraversal(root);
        System.out.println("示例3，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example4() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,2));
        List<Integer> expected = Arrays.asList(1,2);
        List<Integer> actual = new LeetCode144().preorderTraversal(root);
        System.out.println("示例4，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public static void example5() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,null,2));
        List<Integer> expected = Arrays.asList(1,2);
        List<Integer> actual = new LeetCode144().preorderTraversal(root);
        System.out.println("示例5，输出结果：" + (actual.equals(expected) ? "成功" : "失败"));
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode currentNode;
        if (root == null) {
            return new ArrayList<>();
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            result.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> array = new ArrayList<>();
        preorderTraversal(root, array);
        return array;
    }

    private void preorderTraversal(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        array.add(root.val);
        preorderTraversal(root.left, array);
        preorderTraversal(root.right, array);
    }
}
