public class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxLength = 0;
        map.put(0, -1); // in case [0, 1]
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                maxLength = Math.max(i - map.get(sum), maxLength);
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}



