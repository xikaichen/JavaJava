public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(candidates, res, temp, target, 0);
        return res;
    }
    
    private void backtrack(
        int[] candidates, List<List<Integer>> res, List<Integer> temp,
        int target, int start) {
            if (target == 0) {
                res.add(new ArrayList(temp));
                return;
            }
            if (target < 0 || start == candidates.length) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                backtrack(candidates, res, temp, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
}