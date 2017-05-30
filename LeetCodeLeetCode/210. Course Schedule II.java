// the only difference with course schedule 1 is in this question it requires one solution
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> temp = new LinkedList<Integer>();
        int[] degree = new int[numCourses];
        ArrayList[] edges = new ArrayList[numCourses];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            temp.add(cur);
            int size = edges[cur].size();
            for (int i = 0; i < size; i++) {
                int pointer = (int) edges[cur].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        int[] res = new int[numCourses];
        if (temp.size() == numCourses) {
            for (int i = 0; i < temp.size(); i++) {
                res[i] = temp.get(i);
            }
        } else {
            return new int[0];
        }
        return res;
    }
}