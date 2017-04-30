public class graphValidTree {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        Queue<Integer> queue = new LinkedList<Integer>();
        if (edges.length == 0 && n - 1 != 0) {
            return false;
        } else if (edges.length == 0 && n - 1 == 0) {
            return true;
        }
        
        if (edges.length != n -1) {
            return false;
        }
        
        
        Set<Integer> set = new HashSet<Integer>();
        
        queue.offer(edges[0][0]);
        set.add(edges[0][0]);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < edges.length; j++) {
                    if (edges[j][0] == cur || edges[j][1] == cur) {
                        int toAdd = edges[j][0] == cur ? edges[j][1]:edges[j][0];
                        if (!set.add(toAdd)) {
                            continue;
                        }
                        queue.offer(toAdd);
                    }
                    
                }
            }
        }
        if (set.size() == n) {
            return true;
        }
        return false;
    }
}