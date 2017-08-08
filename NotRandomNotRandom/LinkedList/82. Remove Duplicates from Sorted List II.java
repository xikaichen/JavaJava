/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 这道题的难度就在于需要删掉重复的点，不能留一个
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) { // 这一步cur位于重复值的点的最后一个
                cur = cur.next;
            }
            if (prev.next == cur) { // 关键的一步prev.next == cur 而不是val相等，这样对于 dummy - 1 - 2 可以让prev从dummy跳到1。而不会让 dummy - 1 - 1跳
                prev = prev.next;
            } else {
                prev.next = cur.next; // 删掉所有重复的点
            }
            cur = cur.next; // 最后cur = cur.next让循环继续下去
        }
        return dummy.next;
    }
}

