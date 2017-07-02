// find position, then find next greater element from this position
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null) {
            return findNums;
        }
        for (int i = 0; i < findNums.length; i++) {
            int position = findPosition(findNums[i], nums);
            findNums[i] = findNextGreaterElement(position, nums);
        }
        return findNums;
    }
    
    private int findPosition(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                return i;
            }
        }
        return -1;
    }
    
    private int findNextGreaterElement(int position, int[] nums) {
        for (int i = position + 1; i < nums.length; i++) {
            if (nums[i] > nums[position]) {
                return nums[i];
            }
        }
        return -1;
    }
}