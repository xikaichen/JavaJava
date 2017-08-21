/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 要对head进行操作的一般都要dummy node 比如说删除head，翻转list涉及了head，要返回head（可以返回dummy.next）
//can never delete head if not use dummy
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {    //avoid n bigger than linkedlist's length, but there isn't such case in leetcode
                return null;
            }   
        }
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}




