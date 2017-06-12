// 一个很麻烦的corner case是k = 0的时候
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mode = prefix; // 处理 k = 0的情况 k = 0不能mod k 所以mode就等于prefix
            if (k != 0) {
                mode = prefix % k;
            }
            if (map.containsKey(mode)) {
                if (i - map.get(mode) > 1) {
                    return true;
                }
            } else {
                map.put(mode, i);
            }
        }
        return false;
    }
}