public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        //Arrays.sort(candidates);
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
            temp.add(nums[i]);
            backtrack(res, temp, nums, target - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}