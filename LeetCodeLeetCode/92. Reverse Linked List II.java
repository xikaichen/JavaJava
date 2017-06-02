/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0); // 考虑到只有一个点的情况，需要建一个dummy才能找到两个点把要翻转的链表包裹起来
        dummy.next = head;
        ListNode pointer1 = dummy;
        ListNode pointer2 = head;
        for (int i = 1; i < m; i++) {
            pointer1 = pointer1.next;
        }
        for (int i = 1; i <= n; i++) {
            pointer2 = pointer2.next;
        }
        ListNode prev = pointer1; // prev等于要翻转的前一个
        ListNode cur = pointer1.next;
        while (cur.next != pointer2) { // ！= 要翻转的后一个， 也就是找两个点把要翻转的包裹起来
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }
}