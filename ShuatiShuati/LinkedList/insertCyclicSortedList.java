public class insertCyclicSortedList {
    public ListNode insert(ListNode node, int x) {
       if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode prev = node;
        ListNode p = node.next;
        while (p != node) {
            //case 1
            if (x <= p.val && x >= prev.val) { 
                break;
            }
            //case 2
            if ((prev.val > p.val) && (x < p.val || x > prev.val)) {
                break;
            }
            prev = p;
            p = p.next;
        }

        ListNode newNode = new ListNode(x);
        prev.next = newNode;
        newNode.next = p;
        return newNode;
    }
}