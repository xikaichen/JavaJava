// 首先permutation一般是不需要排序的，因为反正要从i = 0开始遍历，然后也不需要start
// 这里用一个used去重，可以防止同一个位置被重复添加
// 关键是：if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false)
// 这个条件 保证了像[1, 1, 2]这种 不会把1视为两个，因为在当前位置i，如果used[i - 1] == false意味着i - 1位置的那个1还没有被用到，所以不能用当前位置i的1

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, temp, nums, used);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new LinkedList(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == true) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            backtrack(res, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}