/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


// The idea is to sort the intervals by their starting points. 
// Then, we take the first interval and compare its end with the next intervals starts. 
// As long as they overlap, we update the end to be the max end of the overlapping intervals. 
// Once we find a non overlapping interval, we can add the previous "extended" interval and start over.

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort((i, j) -> Integer.compare(i.start, j.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}