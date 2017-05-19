
// brute force solution is n^4
// this is a n^2 algorithm



// getOrDefault replace
// if (map.containsKey()) {
//     map.put(key, map.get(key) + 1);
// } else {
//     map.put(key, 0);
// }

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                res += map.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return res;
    }
}