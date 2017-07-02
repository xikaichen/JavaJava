public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }
    
    private int countOnes(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += ((num >> i) & 1);
        }
        return count;
    }
}
public class Solution {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1); // even number they have same 1, odd number like 5 have one more 1 than 3.
        return f;
    }
}