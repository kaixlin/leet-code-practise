package com.linkai.practise.linkedlist;

import java.util.Arrays;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5] 示例 2：
 *
 * 输入：head = [1], n = 1 输出：[] 示例 3：
 *
 * 输入：head = [1,2], n = 1 输出：[1]
 */
public class LeetCode19 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1,2,3,4,5));
        int n = 2;
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(1,2,3,5));
        ListNode actual = new LeetCode19().removeNthFromEnd(head, n);
        System.out.println("示例1，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1));
        int n = 1;
        ListNode expected = null;
        ListNode actual = new LeetCode19().removeNthFromEnd(head, n);
        System.out.println("示例2，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example3() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1,2));
        int n = 1;
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(1));
        ListNode actual = new LeetCode19().removeNthFromEnd(head, n);
        System.out.println("示例3，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fastNode = dummyHead;
        ListNode slowNode = dummyHead;
        while (n >= 0 && fastNode != null) {
            fastNode = fastNode.next;
            n--;
        }
        if (n >= 0) {
            return dummyHead.next;
        }
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummyHead.next;
    }
}
