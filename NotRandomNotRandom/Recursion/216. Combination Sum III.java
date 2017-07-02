public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        backtrack(res, temp, k, n, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new LinkedList(temp));
            return;
        }
        if (k == 0 & n != 0) {
            return;
        }
        for (int i = start; i < 10; i++) {
            temp.add(i);
            backtrack(res, temp, k - 1, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}