public class courseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[count] = cur;
            count++;
            int n = edges[cur].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int) edges[cur].get(i);
                indegree[pointer]--;
                if (indegree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        
        if (count == numCourses) {
            return order;
        }
        
        return new int[0];
    }
}