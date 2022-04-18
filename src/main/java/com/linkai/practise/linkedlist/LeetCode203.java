package com.linkai.practise.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 * ● 列表中的节点数目在范围 [0, 104] 内
 * ● 1 <= Node.val <= 50
 * ● 0 <= val <= 50
 */
public class LeetCode203 {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(1,2,6,3,4,5,6));
        int val = 6;
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(1,2,3,4,5));
        ListNode actual = new LeetCode203().removeElements(head, val);
        System.out.println("示例1，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
         ListNode head = null;
         int val = 1;
         ListNode expected = null;
         ListNode actual = new LeetCode203().removeElements(head, val);
        System.out.println("示例2，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example3() {
        ListNode head = ListNodeUtil.buildLinkedList(Arrays.asList(7,7,7,7));
        int val = 7;
        ListNode expected = null;
        ListNode actual = new LeetCode203().removeElements(head, val);
        System.out.println("示例3，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode currentNode = dummyHead;
        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return dummyHead.next;
    }
}
