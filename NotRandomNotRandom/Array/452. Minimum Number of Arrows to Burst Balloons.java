// 按照end point排序
// 从第一个气球的end point开始射，看能不能射穿下一个，如果能就在看能不能射穿下下一个，直到找到一个不能被射穿的为止，开始从它的end point继续，count++
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]); // 因为如果end point是从小到大排列的，那么就可以确定shootPos的位置一定是小于或者等于下一个气球的end point的，所以只需要确定shootPos是不是大于或等于下一个气球的start point即可
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