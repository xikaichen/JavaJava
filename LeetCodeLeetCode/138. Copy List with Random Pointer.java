/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dummy = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        
        for (RandomListNode node : map.keySet()) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(dummy);
    }
}