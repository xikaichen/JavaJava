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
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode pointer1 = head;
        while (pointer1 != null) {
            map.put(pointer1, new RandomListNode(pointer1.label));
            pointer1 = pointer1.next;
        }
        RandomListNode pointer2 = head;
        while (pointer2 != null) {
            map.get(pointer2).next = map.get(pointer2.next);
            map.get(pointer2).random = map.get(pointer2.random);
            pointer2 = pointer2.next;
        }
        
        return map.get(head);
        
    }
}