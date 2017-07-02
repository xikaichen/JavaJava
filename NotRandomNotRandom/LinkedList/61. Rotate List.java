/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 翻转array或者string可以用三步翻转法，但是对于linkedlist可以让linkedlist首尾相接，然后在断开一个点这样更方便
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        tail.next = head;
        int offset = len - (k % len);
        for (int i = 0; i < offset - 1; i++) {
            head = head.next;
        }
        tail = head.next;
        head.next = null;
        return tail;
    }
}
// 1-2-3-4-5
// k = 2
// 应该是在5 - 2 = 3的地方断开
// 4-5-1-2-3
// k也有可能很大所以用k % len
// 另外因为一开始就位于head所以其实只需要移动两步而不是三步 所以i < offset - 1


