//solution1: O(n ^ 2)
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] cumSum = new int[nums.length + 1];
        int cum = 0;
        for (int i = 1; i <= nums.length; i++) {
            cum += nums[i - 1];
            cumSum[i] = cum;
        }
        int count = 0;
        for (int i = 0; i < cumSum.length - 1; i++) {
            for (int j = i + 1; j < cumSum.length; j++) {
                if (cumSum[j] - cumSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

//solution2: O(n);
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] cumSum = new int[nums.length + 1];
        int cum = 0;
        for (int i = 1; i <= nums.length; i++) {
            cum += nums[i - 1];
            cumSum[i] = cum;
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < cumSum.length; i++) {
            if (map.containsKey(cumSum[i])) {
                count += map.get(cumSum[i]);
            }
            map.put(cumSum[i] + k, map.getOrDefault(cumSum[i] + k, 0) + 1);
        }
        return count;
    }
}