package com.linkai.practise.linkedlist;

import java.util.Arrays;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
public class LeetCode24 {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1,2,3,4));
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(2,1,4,3));
        ListNode actual = new LeetCode24().swapPairs(head);
        System.out.println("示例1，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
        ListNode head = null;
        ListNode expected = null;
        ListNode actual = new LeetCode24().swapPairs(head);
        System.out.println("示例2，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example3() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1));
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(1));
        ListNode actual = new LeetCode24().swapPairs(head);
        System.out.println("示例3，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode currentNode = dummyHead;
        while (currentNode.next != null && currentNode.next.next != null) {
            ListNode leftNode = currentNode.next;
            ListNode rightNode = currentNode.next.next;
            currentNode.next = rightNode;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            currentNode = leftNode;
        }

        return dummyHead.next;
    }
}
