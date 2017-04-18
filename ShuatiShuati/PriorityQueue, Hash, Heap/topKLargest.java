class topKLargest {
    public int[] topk(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length < k) {
            return res;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(k, 
            new Comparator<Integer>() {
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
            maxheap.offer(nums[i]);
        }
        
        for (int i = 0; i < k; i++) {
            res[i] = maxheap.poll();
        }
        return res;
    }
};

