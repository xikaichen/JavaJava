// index记录factor该与哪一个res相乘了，而这里index++之后 又算了primes所以下一步的结果已经在primes中了，故只需要找min
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] factor = primes.clone();
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int min = findMin(primes); // 此时primes里已经有了下一步的结果 所以只需要求min
            res[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j]) { // 在根据min去找，min对应的是哪一个primes，根据primes可以找到factor，然后让这个factor对应的index+1
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