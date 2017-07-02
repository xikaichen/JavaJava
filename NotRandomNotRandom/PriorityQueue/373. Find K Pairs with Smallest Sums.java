public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] + a[1] > b[0] + b[1]) {
                    return 1;
                } else if (a[0] + a[1] < b[0] + b[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }
        
        while (k != 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(new int[] {cur[0], cur[1]});
            k--;
            if (cur[2] + 1 < nums2.length) {
                pq.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
            } else {
                continue;
            }
        }
        return res;
    }
}