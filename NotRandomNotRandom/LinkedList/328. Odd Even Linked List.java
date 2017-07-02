/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


// 1-2-3-4-5-6
// evenHead always = 2
// step1: 1-3-4-5-6 and 2-4-5-6
// step2: 1-3-5-6 and 2-4-6;
// now even = 6, odd = 5, even.next == null 
// odd.next = evenHead, it becomes 1-3-5-2-4-6