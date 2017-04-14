/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy; //set pointer point to the index of dummy
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1; //change pointer's next
                l1 = l1.next; //change index of linkedlist1
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next; //change index
        }
        
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return dummy.next;
    }
}