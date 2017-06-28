// 分成四个盒子，先把第一个数字放进第一个盒子，剩下的变成了子问题。如果剩下的子问题不成立，
// 把这个数字从第一个盒子拿出来放进第二个盒子，backtrack的方法解
public class Solution {
    public boolean makesquare(int[] nums) {
    	if (nums == null || nums.length < 4) {
    	    return false;
    	}
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        
    	return backtrack(nums, new int[4], 0, sum / 4);
    }
    
    private boolean backtrack(int[] nums, int[] sums, int index, int target) {
    	if (index == nums.length) {
    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {
    		    return true; // only need check the first three
    	    }
    	    return false;
    	}
    	
    	for (int i = 0; i < 4; i++) {
    	    if (sums[i] + nums[index] > target) {
    	        continue;
    	    }
    	    sums[i] += nums[index];
            if (backtrack(nums, sums, index + 1, target)) {
                return true;
            }
    	    sums[i] -= nums[index];
    	}
    	
    	return false;
    }
}
// a very good optimization: 
// Sorting the input array DESC will make the DFS process run much faster. 
// Reason behind this is we always try to put the next matchstick in the first subset. 
// If there is no solution, trying a longer matchstick first will get to negative conclusion earlier. 