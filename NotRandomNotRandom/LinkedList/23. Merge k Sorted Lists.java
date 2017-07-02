/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(100, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val > b.val) {
                    return 1;
                } else if (a. val < b.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                pq.offer(cur);
                cur = cur.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            head.next = new ListNode(pq.poll().val);   //must use new, else it connect to this node and all node after it
            head = head.next;
        }
        return dummy.next;
    }
}