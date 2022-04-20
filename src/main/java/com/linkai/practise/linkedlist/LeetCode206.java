package com.linkai.practise.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 * ● 链表中节点的数目范围是 [0, 5000]
 * ● -5000 <= Node.val <= 5000
 */
public class LeetCode206 {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1,2,3,4,5));
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(5,4,3,2,1));
        ListNode actual = new LeetCode206().reverseList2(head);
        System.out.println("示例1，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1,2));
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(2,1));
        ListNode actual = new LeetCode206().reverseList2(head);
        System.out.println("示例2，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example3() {
        ListNode head = null;
        ListNode expected = null;
        ListNode actual = new LeetCode206().reverseList2(head);
        System.out.println("示例1，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = head;
        ListNode prev = null;
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }
        return prev;
    }

    public ListNode reverseList2 (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode current = head;
        return reverse(prev, current);
    }

    public ListNode reverse(ListNode prev, ListNode current) {
        if (current == null) {
            return prev;
        }
        ListNode nextNode = current.next;
        current.next = prev;
        return reverse(current, nextNode);
    }
}
