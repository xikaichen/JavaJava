/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middlePoint = findMid(head);
        reverse(middlePoint);
        ListNode p1 = head;
        ListNode p2 = middlePoint.next;
        while  (p1 != middlePoint) {
            middlePoint.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = middlePoint.next;
        }
    }
     
    private ListNode findMid(ListNode head) {   //standard find middle point
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private void reverse(ListNode head) {   //standard reverse
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
    }
}