/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// 2k - k = nr
// nr = m + s,(take n = 1, doesn't affect the result)the distance between the start node of cycle and the first meeting node is m,the distance between the start node of list and the start node of cycle is s
// so k = m + s
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // find the position where fast meet slow
                ListNode slow2 = head; // set another slow from the head
                while (slow != slow2) { // when slow meet slow2 this is the begining of circle
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}