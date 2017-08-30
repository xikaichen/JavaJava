// 这道题用了一种数据结构：TreeSet
// TreeSet是用红黑树实现的，所以是有序的set，可以在O(1)时间内得到最大最小值
// 这道题用了TreeSet里两个关键函数floor和ceiling, floor可以得到set里比指定int小的最大元素，ceiling可以得到set里比指定元素大的最小元素或者 返回null
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<Long>();
    
        int i = 0;
        while (i < nums.length) {
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]); // 改成nums[i] - t <= floor会报错，interget overflow -2147483648
            if ((floor != null && nums[i] - floor <= t ) || // 检查set和[nums[i] - t, nums[i] + t]是否有交集，防止overflow
                    (ceiling != null && ceiling - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i++]);
            if (i > k) { // 保持set只有留连续的k个数字 这样下标差也不会超过k
                set.remove((long) nums[i - k - 1]);
            }
        }
        return false;
    }
}