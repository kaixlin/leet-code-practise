package com.linkai.practise.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 示例 1：
 * ● 输入：root = [1,2,3,4,5,6]
 * ● 输出：6
 *
 * 示例 2：
 * ● 输入：root = []
 * ● 输出：0
 *
 * 示例 3：
 * ● 输入：root = [1]
 * ● 输出：1
 *
 * 提示：
 * ● 树中节点的数目范围是[0, 5 * 10^4]
 * ● 0 <= Node.val <= 5 * 10^4
 * ● 题目数据保证输入的树是 完全二叉树
 */
public class LeetCode222 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        TreeNode root = TreeNodeUtil.buildTree(Arrays.asList(1,2,3,4,5,6), TreeBuildMode.LEVEL);
        int expected = 6;
        int actual = new LeetCode222().countNodes2(root);
        System.out.println("示例1，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example2() {
        TreeNode root = null;
        int expected = 0;
        int actual = new LeetCode222().countNodes(root);
        System.out.println("示例2，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public static void example3() {
        TreeNode root = TreeNodeUtil.buildTree(Collections.singletonList(1));
        int expected = 1;
        int actual = new LeetCode222().countNodes(root);
        System.out.println("示例3，输出结果：" + (actual == expected ? "成功" : "失败"));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCountNodes = countNodes(root.left);
        int rightCountNodes = countNodes(root.right);
        return leftCountNodes + rightCountNodes + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int countNodes = 0;
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            countNodes += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return countNodes;
    }
}
