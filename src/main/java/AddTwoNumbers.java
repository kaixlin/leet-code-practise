//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode  {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode l3Header = null;
        boolean upperFlag = false;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            if (upperFlag) {
                sum += 1;
                upperFlag = false;
            }
            if (sum >= 10) {
                upperFlag = true;
            }
            if (l3Header == null) {
                l3Header = new ListNode(sum % 10);
                l3 = l3Header;
            } else {
                l3.next = new ListNode(sum % 10);
                l3 = l3.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        l3.next = l1 != null ? l1 : l2;
        while(l3.next != null) {
            sum = l3.next.val;
            if (upperFlag) {
                sum += 1;
                upperFlag = false;
            }

            if (sum >= 10) {
                upperFlag = true;
            }
            l3.next.val = sum % 10;
            l3 = l3.next;
        }
        if (upperFlag) {
            l3.next = new ListNode(1);
        }
        return l3Header;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
