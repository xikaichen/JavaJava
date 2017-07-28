// sort it first to avoid 1 - 3 = -2 and 3 -5 = 2
// use a set to avoid the duplicate like [1,1,1,1,3,3,3,3]
public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (set.contains(nums[i])) {
                    continue;
                }
                count++;
                set.add(nums[i]);
                map.put(nums[i] + k, nums[i]);
            } else {
                map.put(nums[i] + k, nums[i]);
            }
        }
        return count;
    }
    
}