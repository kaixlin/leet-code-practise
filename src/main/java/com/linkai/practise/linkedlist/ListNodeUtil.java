package com.linkai.practise.linkedlist;

import java.util.List;
import java.util.stream.Collectors;

public final class ListNodeUtil {

    public static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static boolean isEqual(ListNode actual, ListNode expected) {
        if (actual == null && expected == null) {
            return true;
        }

        if (actual == null || expected == null) {
            return false;
        }

        int actualSize = getSize(actual);
        int expectedSize = getSize(expected);

        if (actualSize != expectedSize) {
            return false;
        }

        while (actual != null) {
            if (actual.val != expected.val) {
                return false;
            }
            actual = actual.next;
            expected = expected.next;
        }
        return true;
    }

    public static ListNode buildLinkedList(List<Integer> arrays) {
        if (arrays.size() == 0) {
            return null;
        }
        List<ListNode> listNodes = arrays.stream().map(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        return listNodes.get(0);
    }

    public static ListNode buildCycleLinkedList(List<Integer> arrays) {
        ListNode head = buildLinkedList(arrays);
        ListNode tail = getTailNode(head);
        tail.next = head;
        return head;
    }

    public static ListNode getTailNode(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static void appendLinkedList(ListNode head, ListNode appendHead) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = appendHead;
    }
}
