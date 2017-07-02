//seems backtrack can solve this problem, but actually it can't because it will stackoverflow. 
// the question allows element appear infinite times
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums); // remember sort. 
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) { // is nums[j] > i, then nums[j] can't be a possible factor of i so just break.
                    break;
                }
                if (nums[j] == i) {
                    res[i] += 1;
                } else {
                    res[i] += res[i - nums[j]];
                }
            }
        }
        return res[target];
    }

}