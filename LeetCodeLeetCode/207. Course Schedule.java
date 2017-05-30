public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) { // if no prerequisites, return true
            return true;
        }
        int[] degree = new int[numCourses]; // build indegree array
        ArrayList[] edges = new ArrayList[numCourses]; // initialize graph
        for (int i = 0; i < numCourses; i++) { // initialize
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) { // build indegree array and graph
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>(); // bfs
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            int size = edges[cur].size();
            for (int i = 0; i < size; i++) {
                degree[(int) edges[cur].get(i)]--;
                if (degree[(int) edges[cur].get(i)] == 0) {
                    queue.offer((int) edges[cur].get(i));
                }
            }
        }
        return count == numCourses;
    }
}