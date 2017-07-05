/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// 扫描线
// 关键：排序规则：val从小到大，val一样end在钱，start在后
class Point implements Comparable<Point> {
	int val;
    int flag; // start = 1, end = 0
    int index;
    public Point(int val, int flag, int index) {
        this.val = val;
        this.flag = flag;
        this.index = index;
    }
    public int compareTo(Point o) {
        if (this.val == o.val) {
            return this.flag - o.flag;
        }
        return this.val - o.val;
    }
}
public class Solution {
    
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        List<Point> list = new LinkedList<Point>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Point(intervals[i].start, 1, i));
            list.add(new Point(intervals[i].end, 0, i));
        }
        Collections.sort(list);
        List<Integer> temp = new LinkedList<Integer>();
        for (Point point : list) {
            if (point.flag == 1) {
                for (Integer idx : temp) {
                    res[idx] = point.index;
                }
                temp = new LinkedList<Integer>();
            } else {
                temp.add(point.index);
            }
        }
        return res;
    }
}