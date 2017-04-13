public class wordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null) {
            return 0;
        }
        
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int path = 1;
        
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            for (int i  = 0; i < size; i++) {
                String cur = queue.poll();
                for (String neighbor : getNext(cur, dict)) {
                    if (set.contains(neighbor)) {
                        continue;
                    }
                    if (neighbor.equals(end)) {
                        return path;
                    }
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return 0;   
    }
    
    private ArrayList<String> getNext(String cur, Set<String> dict) {
        ArrayList<String> neighbors = new ArrayList<String>();
        for (int i = 0; i < cur.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String replaceWord = replace(cur, i, c);
                if (dict.contains(replaceWord)) {
                    neighbors.add(replaceWord);
                }
            }
        }
        return neighbors;
    }
    
    private String replace(String cur, int i, char c) {
        char[] chars = cur.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}