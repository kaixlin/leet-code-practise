package com.linkai.practise.tree;

import java.util.Arrays;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例3：
 * 输入：root = []
 * 输出：true
 */
public class LeetCode110 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(3,9,20,null,null,15,7), TreeBuildMode.LEVEL);
        boolean expected = true;
        boolean actual = new LeetCode110().isBalanced(root);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,2,2,3,3,null,null,4,4), TreeBuildMode.LEVEL);
        boolean expected = false;
        boolean actual = new LeetCode110().isBalanced(root);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = null;
        boolean expected = true;
        boolean actual = new LeetCode110().isBalanced(root);
        System.out.println("示例3，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int height = getHeight(root);
        return height != -1;
    }
}
