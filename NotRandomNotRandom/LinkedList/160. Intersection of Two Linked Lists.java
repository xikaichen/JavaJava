/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        if (pointerA == pointerB) { // in case pointerA and pointerB point to the same point at the first begining
            return pointerA;
        }
        while (pointerA != null || pointerB !=null) {
            if (pointerA != null) {
                pointerA = pointerA.next;
            } else {
                pointerA = headB;
            }
            if (pointerB != null) {
                pointerB = pointerB.next;
            } else {
                pointerB = headA;
            }
            if (pointerA == pointerB) {
                return pointerA;
            }
        }
        return null;
    }
}