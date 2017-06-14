// 因为h-Index最多不会超过citations.length所以可以用array来做hashmap，同时第二步从后往前统计
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int[] hIndex = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                hIndex[len]++;
            } else {
                hIndex[citations[i]]++;
            }
        }
        // from the tail to head
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += hIndex[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}