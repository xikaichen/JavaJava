public class buildOffice2 {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    
    private int[] deltaX = {0, 0, 1, -1};
    private int[] deltaY = {1, -1, 0, 0};
    
    private class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
    private ArrayList<Coordinates> getCoordinates(int[][] grid, int type) {
        ArrayList<Coordinates> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == type) {
                    list.add(new Coordinates(i,j));
                }
            }
        }
        return list;
    }
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] access = new int[grid.length][grid[0].length];
        //step 1: 统计房子数量
        List<Coordinates> houses = new ArrayList<>();
        houses = getCoordinates(grid, 1);
        for (Coordinates house : houses) {
            bfs(grid, house, distance, access);
        }
        //step2: 对房子进行bfs 算出每一个空格的到该房子的距离
        List<Coordinates> empties = new ArrayList<>();
        empties = getCoordinates(grid, 0);
        //System.out.println(empties.size());
        int minPath = Integer.MAX_VALUE;
        for (Coordinates empty : empties) {
            if (access[empty.x][empty.y] != houses.size()) {
                continue;
            }
            minPath = Math.min(minPath, distance[empty.x][empty.y]);
        }
        
        if (minPath == Integer.MAX_VALUE) {
            return -1;
        }
        return minPath;
        //step3 统计空格数量 找出最小的哪一个
        
        
    }
    
    private void bfs(int[][] grid, Coordinates house, int[][] distance, int[][] access) {
        int step = 1;
        Queue<Coordinates> queue = new LinkedList<>();
        int[][] visited= new int[grid.length][grid[0].length];
        queue.offer(house);
        visited[house.x][house.y] = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinates cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinates adj = new Coordinates(cur.x + deltaX[j], cur.y + deltaY[j]);
                    if (!inBound(grid, adj)) {
                        continue;
                    }
                    if (visited[adj.x][adj.y] == 1) {
                        continue;
                    }
                    if (grid[adj.x][adj.y] == 0) {
                        distance[adj.x][adj.y] += step;
                        access[adj.x][adj.y]++;
                        queue.offer(adj);
                        visited[adj.x][adj.y] = 1;
                    }
                }
            }
            step++;
        }
    }
    
    private boolean inBound(int[][] grid, Coordinates adj) {
        if (adj.x < 0 || adj.x > grid.length - 1) {
            return false;
        }
        if (adj.y < 0 || adj.y > grid[0].length - 1) {
            return false;
        }
        return true;
    }
}