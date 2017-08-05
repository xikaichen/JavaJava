/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        //clone: two steps: step 1: clone value, step 2: clone relationship


        //step1: clone value, need traverse the whole graph, because it is a graph need a set to avoid circle
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.offer(node);
        set.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode n : cur.neighbors) {
                if (set.contains(n)) {
                    continue;
                }
                queue.offer(n);
                set.add(n);
                map.put(n, new UndirectedGraphNode(n.label));
            }
        }

        //step2: clone relationship
        for (UndirectedGraphNode n : map.keySet()) {
            List<UndirectedGraphNode> temp = new LinkedList<UndirectedGraphNode>();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                temp.add(map.get(neighbor));
            }
            map.get(n).neighbors = temp;
        }
        return map.get(node);
    }
}