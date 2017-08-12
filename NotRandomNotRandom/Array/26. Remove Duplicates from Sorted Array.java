public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                continue;
            } else {
                swap(nums,j + 1, i);   //index = j record the last location of no-duplicated array. so swap j + 1 and i.
                j++;
            }
        }
        return j + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// more clever answer, and it is very similar to question No. 80 
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 1 || n != nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
// i左边的都是只有一个且sorted的，所以是当前数字n是和nums[i - 1]比较如果不一样就可以让nums[i] = n因为是sorted的所以只需要和最后一个比
// 如果不是sorted的就不行[1,1,1,2,3,1]