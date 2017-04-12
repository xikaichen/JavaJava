
public class cloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return node;
        }
        
        List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        nodes = getNodes(node);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
        new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        for (UndirectedGraphNode n : nodes) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                //cannot use this because if you create a new node,
                // then the new node doesn't store information
                //map.get(n).neighbors.add(new UndirectedGraphNode(neighbor.label));
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    private ArrayList getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                //one thing I'm not sure is that why
                //set know neighbor exists in set, because 
                //neighbor is a self-defined object
                if(set.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList(set);
    }
}