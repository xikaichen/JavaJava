/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
         if (points == null) {
             return 0;
         }
        if (points.length <= 1) {
            return points.length;
        }
        
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int samePoint = 1;
            Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) { // 重叠的点
                    samePoint++;
                    continue;
                }
                int gcd = getGCD(x, y); // 约掉GCD
                if (gcd != 0) { 
                    x = x / gcd;
                    y = y / gcd;  
                }
                
                if (map.containsKey(x)) {
                    map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1); // 固定points[i] 相同斜率的点的数量，必在一条直线上
                } else {
                    Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
                    temp.put(y, 1);
                    map.put(x, temp);
                }
                max = Math.max(m ax, map.get(x).get(y)); // 和点points[i]在同一条线上最多的点
            }
            res = Math.max(res, max + samePoint); // 还要加上和points[i]重合的点
        }
        return res;
    }
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}