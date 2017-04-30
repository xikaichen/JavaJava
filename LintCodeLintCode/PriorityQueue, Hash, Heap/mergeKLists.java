public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {  
        PriorityQueue<ListNode> minheap = 
        new PriorityQueue<ListNode>(100, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val > b.val) {
                    return 1;
                } else if (a.val < b.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        for (ListNode list : lists) {
            while (list != null) {
                minheap.offer(list);
                list = list.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (!minheap.isEmpty()) {
            pointer.next = minheap.poll();
            pointer = pointer.next;
        }
        
        return dummy.next;
    }
}
