/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null && pointer.next.next != null) {
            swap(pointer);
            pointer = pointer.next.next;
        }
        return dummy.next;
    }
    
    private void swap(ListNode node) {
        ListNode cur = node.next;
        ListNode temp = cur.next;
        cur.next = temp.next;
        temp.next = node.next;
        node.next = temp;
    }
}