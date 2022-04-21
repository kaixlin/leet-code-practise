package com.linkai.practise.linkedlist;

import java.util.Arrays;
import java.util.Objects;

/**
 * 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 * 示例 2：
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例2：
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例3：
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 */
public class LeetCode142 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(3));
        ListNode expected = ListNodeUtil.buildCycleLinkedList(Arrays.asList(2,0,-4));
        ListNodeUtil.appendLinkedList(head, expected);
        ListNode actual = new LeetCode142().detectCycle(head);
        System.out.println("示例1，输出结果：" + (expected.equals(actual)  ? "成功" : "失败"));
    }

    public static void example2() {
        ListNode expected = ListNodeUtil.buildCycleLinkedList(Arrays.asList(1,2));
        ListNode actual = new LeetCode142().detectCycle(expected);
        System.out.println("示例2，输出结果：" + (expected.equals(actual)  ? "成功" : "失败"));
    }

    public static void example3() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1));
        ListNode expected = null;
        ListNodeUtil.appendLinkedList(head, expected);
        ListNode actual = new LeetCode142().detectCycle(head);
        System.out.println("示例3，输出结果：" + (Objects.equals(expected, actual)  ? "成功" : "失败"));
    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode index1 = head;
        ListNode index2 = null;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                index2 = fast;
                break;
            }
        }

        if (fast == null || slow == null) {
            return null;
        }

        while (index1 != null && index2 != null) {
            if (index1 == index2) {
                return index1;
            }
            index1 = index1.next;
            index2 = index2.next;
        }
        return null;
    }
}
