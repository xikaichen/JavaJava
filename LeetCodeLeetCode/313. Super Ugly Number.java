public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] factor = primes.clone();
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = findMin(primes);
            res[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j]) {
                    index[j]++;
                    primes[j] = factor[j] * res[index[j]];
                }
            }
            
        }
        return res[n - 1];
    }
    
    private int findMin(int[] primes) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] < min) {
                min = primes[i];
            }
        }
        return min;
    }
}