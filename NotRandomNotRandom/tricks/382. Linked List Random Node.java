/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// if we know the length, this is easy, just need generate a random int from 1 to the length.
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ListNode list;
    private Random random;
    public Solution(ListNode head) {
        list = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = list;
        int cur = list.val;
        int count =1;
        while (temp.next != null) {
            temp = temp.next;
            if (random.nextInt(count + 1) == count) { // very clever way, if you don't know the length of the linkedlist
// When we read the first node head, if the stream ListNode stops here, we can just return the head.val. The possibility is 1/1.
// When we read the second node, we can decide if we replace the result r or not. The possibility is 1/2. So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace r as the value of the current node, otherwise we don't touch r, so its value is still the value of head.
// When we read the third node, now the result r is one of value in the head or second node. We just decide if we replace the value of r as the value of current node(third node). The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3. So we just generate a random number between 0 ~ 2, and if the result is 2 we replace r.
                cur = temp.val;
            }
            count++;
        };
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */