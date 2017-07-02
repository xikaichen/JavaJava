// There are only two equal longest lenghts.
// The non longest lengths are all equal.
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dist = 
            {distance(p1, p2), distance(p1, p3), distance(p1, p4), distance(p2, p3), distance(p2, p4), distance(p3, p4)};
        int max = Integer.MIN_VALUE, edge = dist[0];
        for (int i = 0; i < 6; i++) {
            if (dist[i] > max) {
                max = dist[i];
            }
            if (dist[i] < max) {
                edge = dist[i];
            }
        }
        int countMax = 0, countEdge = 0;
        for (int i = 0; i < 6; i++) {
            if (dist[i] == max) {
                countMax++;
            }
            if (dist[i] == edge) {
                countEdge++;
            }
        }
        return countMax == 2 && countEdge == 4;
        
    }
    
    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}