public class twoSumLessOrEqual {
    public int twoSum5(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int num = 0;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] <= target) {
                num += j - i;
                i++;
                // while (i < j && nums[i] == nums[i + 1]) {  //original question count even duplicates as a pair, I think this is not right.
                //     i++;
                // }
            } else {
                j--;
                // while(i < j && nums[j] == nums[j - 1]) {
                //     j--;
                // }
            }
        }
        return num;
    }
}