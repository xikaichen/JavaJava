public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves  = new LinkedList<Integer>();
        for (Integer i : map.keySet()) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<Integer>();
            for (int i = 0; i < leaves.size(); i++) {
                int integer = leaves.get(i);
                int neighbor = map.get(integer).iterator().next(); // 或得hashset里的元素
                map.get(neighbor).remove(integer);
                if (map.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}


// 遍历hashset中元素的方法
// Iterator<String> iterator=set.iterator();
// while(iterator.hasNext()){
//     System.out.println(iterator.next());
// }