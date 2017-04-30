public class wordLadder2 {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        //BFS + DFS
        //use BFS find shortest path and presuccessor of every node
        //distance map
        //preNeighbors map
        //res 
        //temp
        Map<String, Integer> distance = new HashMap<>();
        Map<String, ArrayList<String>> preNeighbors = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<>();
        temp.add(end);
        
        dict.add(start);
        dict.add(end);
        for (String str : dict) {
            preNeighbors.put(str, new ArrayList<String>());
        }
        BFS(distance, preNeighbors, dict, start, end);
        
        //then use DFS find all result based on the distance
        DFS(distance, preNeighbors, dict, res, temp, end, start);
        return res;
    }
    
    private void BFS(
        Map<String, Integer> distance,
        Map<String, ArrayList<String>> preNeighbors,
        Set<String> dict,
        String start, String end) {
            Queue<String> queue = new LinkedList<String>();
            queue.offer(start);
            distance.put(start, 0);
            
            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    for (String n : getNext(cur, dict)) {
                        if (!distance.containsKey(n)) {
                            distance.put(n, distance.get(cur) + 1);
                            queue.offer(n);
                        }
                        preNeighbors.get(n).add(cur);
                    }
                }
            }
            
        }
        
        private ArrayList<String> getNext(String cur, Set<String> dict) {
            ArrayList<String> neighbors = new ArrayList<String>();
            for (int i = 0; i < cur.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String replaceWord = replace(cur, c, i);
                    if (dict.contains(replaceWord)) {
                        neighbors.add(replaceWord);
                    }
                }
            }
            return neighbors;
        }
        
        private String replace(String cur, char c, int i) {
            char[] chars = cur.toCharArray();
            chars[i] = c;
            return new String(chars);
        }
        
        private void DFS(
            Map<String, Integer> distance,
            Map<String, ArrayList<String>> preNeighbors,
            Set<String> dict,
            List<List<String>> res,
            List<String> temp,
            String end, String start) {
                if (temp.get(temp.size() - 1).equals(start)) {
                    Collections.reverse(temp);
                    res.add(new ArrayList<String>(temp));
                    Collections.reverse(temp);
                    return;
                }
                for (String n : preNeighbors.get(end)) {
                    if (distance.get(end) == distance.get(n) + 1) {
                        temp.add(n);
                        DFS(distance, preNeighbors, dict, res, temp, n, start);
                        temp.remove(temp.size() - 1);
                    }
                }
            }
}