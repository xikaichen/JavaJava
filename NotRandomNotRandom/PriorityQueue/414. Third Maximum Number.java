public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> (3, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                } else if (a < b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = pq.peek();
        int thirdMax = -1;

        while (!pq.isEmpty() && set.size() < 3) {
            int temp = pq.poll();
            thirdMax = temp;
            set.add(temp);
        }

        if (set.size() >= 3) {
            return thirdMax;
        }
        
        return max;
    }
}