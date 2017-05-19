// you can't traverse the array after you flip every number. Because the number that doesn't show in the array will not flip the number just like flip it twice.
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        
        return res;
    }
}