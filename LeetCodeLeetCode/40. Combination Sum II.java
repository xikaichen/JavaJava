public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(res, temp, candidates, target, 0);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        if (target < 0 || start > nums.length - 1) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(res, temp, nums, target - nums[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}