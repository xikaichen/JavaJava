public class LRU {
    public class Node {   // key point: double linked list
        int val;
        int key;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    public int capacity = 0;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node dummyHead = new Node(0, 0);
    private Node dummyTail = new Node(-1, -1);
    

    // @param capacity, an integer
    public Solution(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    // @return an integer
    public int get(int key) { // key point: if get, move to tail
        if (!map.containsKey(key)) {
            return -1;
        }
        int res = map.get(key).val;
        removeNode(map.get(key));
        insertToTail(map.get(key));
        return res;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) != -1) {   // key point: if double linkedlist contains this key, needn't remove dummyHead.next, only move this node to tail
            map.get(key).val = value;
            return;
        }
        Node insertion = new Node(key, value);
        
        if (map.size() == capacity) {
            map.remove(dummyHead.next.key);
            removeNode(dummyHead.next);
        }
        map.put(key, insertion);
        insertToTail(insertion);
        return;
    }
    
    private void insertToTail(Node node) {
        dummyTail.prev.next = node;
        node.prev = dummyTail.prev;
        node.next = dummyTail;
        dummyTail.prev = node;
    }
    
    private void removeNode(Node node) {
        Node temp = node.next;
        node.prev.next = node.next;
        temp.prev = node.prev;
    }
}