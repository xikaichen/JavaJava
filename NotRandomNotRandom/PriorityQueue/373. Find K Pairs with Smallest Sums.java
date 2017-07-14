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

        for (int i = 0; i < nums1.length && i < k; i++) {
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
// nums1 = [1, 7, 11, 16], nums2 = [2, 9, 10, 15].
// 先把[1, 2], [7, 2], [11, 2], [16, 2]加入，每一个给一个启示点0，然后按照起始点开始添加nums2里的数
// 每次从pq里弹出来的数，往pq里添加在nums2里位于起始点的后一个的一个数字，pq对他进行排序
// 一开始最多加k个数字，然后之后要排k次序，所以时间是O(KlogK)