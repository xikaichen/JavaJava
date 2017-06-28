// 因为只需要找到长度为3的，所以用一个min，和一个max来存前两个点，最后一个点只要大于当前的max就可以返回true了
// 需要用<=，否则等于也反返回了true，例如[1,1,1,1,1,1].
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= max) {
                max = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}