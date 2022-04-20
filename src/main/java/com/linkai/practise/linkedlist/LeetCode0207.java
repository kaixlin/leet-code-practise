package com.linkai.practise.linkedlist;

import java.util.Arrays;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 示例 1：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *
 * 示例 2：
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 * 示例 3：
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 */
public class LeetCode0207 {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    public static void example1() {
        ListNode headA = ListNodeUtil.buildLinkedList(Arrays.asList(4,1));
        ListNode headB = ListNodeUtil.buildLinkedList(Arrays.asList(5,0,1));
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(8,4,5));
        ListNodeUtil.appendLinkedList(headA, expected);
        ListNodeUtil.appendLinkedList(headB, expected);
        ListNode actual = new LeetCode0207().getIntersectionNode(headA, headB);
        System.out.println("示例1，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example2() {
        ListNode headA = ListNodeUtil.buildLinkedList(Arrays.asList(0,9,1));
        ListNode headB = ListNodeUtil.buildLinkedList(Arrays.asList(3));
        ListNode expected = ListNodeUtil.buildLinkedList(Arrays.asList(4,5));
        ListNodeUtil.appendLinkedList(headA, expected);
        ListNodeUtil.appendLinkedList(headB, expected);
        ListNode actual = new LeetCode0207().getIntersectionNode(headA, headB);
        System.out.println("示例2，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public static void example3() {
        ListNode headA = ListNodeUtil.buildLinkedList(Arrays.asList(2,6,4));
        ListNode headB = ListNodeUtil.buildLinkedList(Arrays.asList(1,5));
        ListNode expected = null;
        ListNodeUtil.appendLinkedList(headA, expected);
        ListNodeUtil.appendLinkedList(headB, expected);
        ListNode actual = new LeetCode0207().getIntersectionNode(headA, headB);
        System.out.println("示例3，输出结果：" + (ListNodeUtil.isEqual(actual, expected) ? "成功" : "失败"));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int nodeASize = getSize(headA);
        int nodeBSize = getSize(headB);
        ListNode currentNodeA = headA;
        ListNode currentNodeB = headB;
        if (nodeASize > nodeBSize) {
            int count = nodeASize - nodeBSize;
            while (count > 0) {
                currentNodeA = currentNodeA.next;
                count--;
            }
        } else {
            int count = nodeBSize - nodeASize;
            while (count > 0) {
                currentNodeB = currentNodeB.next;
                count--;
            }
        }

        while (currentNodeA != null & currentNodeB != null) {
            if (currentNodeA == currentNodeB) {
                return currentNodeA;
            }
            currentNodeA = currentNodeA.next;
            currentNodeB = currentNodeB.next;
        }
        return null;
    }

    public int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
