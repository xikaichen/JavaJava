public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(num, res, temp, target, 0);
        return res;
    }
    
    private void backtrack(
        int[] num, List<List<Integer>> res, 
        List<Integer> temp, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        if (target < 0 || start == num.length) {
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i-1]) {
                continue;
            }
            temp.add(num[i]);
            backtrack(num, res, temp,target - num[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}