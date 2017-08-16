public class Solution {
	// more than half of the number is majority number
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

//O(n) solution, Boyer-Moore algorithm
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else if (count == 0) {
                candidate = nums[i];
                count++;
            } else {
                count--;
            }
        }
        //因为candidate唯一所以不需要在检查一遍了
        return candidate;
    }
}