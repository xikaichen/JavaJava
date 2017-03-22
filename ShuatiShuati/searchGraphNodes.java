/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class searchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        /* The difference between graph and tree is graph might have circle
         * so use hashset to avoid same node be added into a queue twice
        */
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (values.get(cur) == target) {
                return node;
            }
            for (UndirectedGraphNode n : cur.neighbors) {
                if (!set.add(n)) {
                    continue;
                }
                if (values.get(n) == target) {
                    return n;
                }
                queue.offer(n);
            }
        }
        return null;
    }
}