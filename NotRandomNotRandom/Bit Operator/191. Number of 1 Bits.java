public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) { // take i from 0 to 31
            count += (n >> i) & 1;
        }
        return count;
    }
}