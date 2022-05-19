package com.linkai.practise.tree;

import java.util.*;

/**
 * 给定一个 n 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 示例1：
 *
 * 给定一个 3叉树 :
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 *
 * 示例2：
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 */
public class LeetCode559 {

    public static void main(String[] args) {
        example1();
        example2();
    }

    public static void example1() {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node11 = new Node(5);
        Node node12 = new Node(6);
        node1.children = Arrays.asList(node11, node12);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        root.children = Arrays.asList(node1, node2, node3);
        int expected = 3;
        int actual = new LeetCode559().maxDepth2(root);
        System.out.println("示例1，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public static void example2() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node21 = new Node(6);
        Node node22 = new Node(7);
        Node node221 = new Node(11);
        node22.children = Collections.singletonList(node221);
        Node node2211 = new Node(14);
        node221.children = Collections.singletonList(node2211);
        node2.children = Arrays.asList(node21, node22);
        Node node3 = new Node(4);
        Node node31 = new Node(8);
        Node node311 = new Node(12);
        node31.children = Collections.singletonList(node311);
        node3.children = Collections.singletonList(node31);
        Node node4 = new Node(5);
        Node node41 = new Node(9);
        Node node411 = new Node(13);
        node41.children = Collections.singletonList(node411);
        Node node42 = new Node(10);
        node4.children = Arrays.asList(node41, node42);
        root.children = Arrays.asList(node1, node2, node3,node4);
        int expected = 5;
        int actual = new LeetCode559().maxDepth2(root);
        System.out.println("示例2，输出结果：" + (expected == actual ? "成功" : "失败"));
    }

    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                depth = Math.max(depth, maxDepth2(root.children.get(i)));
            }
        }
        return depth + 1;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null && node.children != null) {
                    queue.addAll(node.children);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
