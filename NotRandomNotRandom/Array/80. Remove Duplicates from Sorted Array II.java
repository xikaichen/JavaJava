public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2]) // use i - 2 to store at least two duplicates
                nums[i++] = n;
        return i;
    }
}
// the similar question refers to No. 26