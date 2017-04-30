class uglyNumber2 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minheap = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        int[] primes = {2, 3, 5};
        minheap.offer((long) 1);
        set.add((long) 1);
        int index = n;
        long cur = 1;
        while (index > 0) {
            cur = minheap.poll();
            index--;
            for (int i = 0; i < 3; i++) {
                if (!set.contains(cur * primes[i])) {
                    minheap.offer(cur * primes[i]);
                    set.add(cur * primes[i]);
                }
            }
        }
        return (int) cur;
    }
};