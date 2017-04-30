/**
 * Definition for ListNode
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
    public ListNode[] rehashing(ListNode[] hashTable) {
        int size = hashTable.length;
        int newSize = size * 2;
        ListNode[] newHashTable = new ListNode[newSize];
        for (int i = 0; i < size; i++) {
            ListNode head = hashTable[i];
            while (head != null) {
                ListNode dummy = head;
                head = head.next;
                int newIndex = (dummy.val % newSize + newSize) % newSize;
                if (newHashTable[newIndex] != null) {
                    ListNode tail = getTail(newHashTable[newIndex]);
                    tail.next = new ListNode(dummy.val);
                } else {
                    newHashTable[newIndex] = new ListNode(dummy.val);
                }
                
            }
        }
        return newHashTable;
    }
    
    private ListNode getTail(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
};
