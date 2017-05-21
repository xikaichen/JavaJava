public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        backtrack(res, temp, n, k, 1);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (k == 0) {
            res.add(new LinkedList(temp));
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(res, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}