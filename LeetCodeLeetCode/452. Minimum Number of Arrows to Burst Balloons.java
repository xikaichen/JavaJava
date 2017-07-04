// 按照end point排序
// 从第一个气球的end point开始射，看能射穿多少，然后再从第一个没有被射穿的气球的end point开始
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int shootPos = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (shootPos >= points[i][0]) {
                continue;
            }
            count++;
            shootPos = points[i][1];
        }
        return count;
    }
}