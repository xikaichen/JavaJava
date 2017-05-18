//扫描
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1; // trick set start = -1, end = -2, then if nums is a sorted array -2 - (-1) + 1 = 0
        int end = -2;
        int max = nums[0]; // set the first element as the max
        int min = nums[nums.length - 1]; // set the last element as the min
        for (int i = 1; i < nums.length; i++) { // scan from 1 to nums.length - 1
            if (nums[i] >= max) { // if nums[i] is bigger or equal to current max, update max. else we find a number need to sort again
                max = nums[i];
            } else {
                end = i;
            }
            if (nums[nums.length - 1 - i] <= min) {
                min = nums[nums.length - 1 - i];
            } else {
                start = nums.length - 1 - i;
            }
        }
        return end - start + 1;
    }
}