/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


//my idea is find the insertion position and insert it!
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;
            ListNode insertPosition = findPosition(dummy, temp);
            if (insertPosition != null) {
                insert(insertPosition, cur, temp);
            } else {
                cur = cur.next; // this is important: when the insertPosition is null, it means the cur ListNode doesn't change, so you need to go the next node. But if the cur ListNode changes, you needn't do that
            }
        }
        return dummy.next;
        
    }
    
    private ListNode findPosition(ListNode start, ListNode temp) {
        while (start.next != temp) {
            ListNode prev = start;
            start = start.next;
            if (temp.val < start.val) {
                return prev;
            }
        }
        return null;
    }
    
    private void insert(ListNode insertPosition, ListNode cur, ListNode temp) {
        ListNode temp1 = insertPosition.next;
        ListNode temp2 = cur.next.next;
        insertPosition.next = temp;
        temp.next = temp1;
        cur.next = temp2;
    }
}



//another solution use the same idea
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            pre = dummy;
            while (pre.next != null && pre.next.val < current.val) { // find the insertion position
                pre = pre.next;
            }
            ListNode temp = current.next; // insert
            current.next = pre.next;
            pre.next = current;
            current = temp;
        }
        return dummy.next;
    }
}

//a suggestion from google interview: for god sake, never try to sort a linked list. 
//That means if allows extra space, always convert linkedlist to array and then sort the array, then convert the array to linked list
