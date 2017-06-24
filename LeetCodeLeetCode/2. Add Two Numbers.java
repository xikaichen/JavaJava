/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 == null ? 0 : l1.val; // 注意如何处理null
            int num2 = l2 == null ? 0 : l2.val;
            res.next = new ListNode((num1 + num2 + carry) % 10);
            carry = num1 + num2 + carry >= 10 ? 1 : 0;
            res = res.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return dummy.next;
    }
}