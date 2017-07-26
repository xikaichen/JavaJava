public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        String str = "";
        backtrack(res, str, 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, String str, int leftNum, int rightNum, int n) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        if (leftNum < n) {
            backtrack(res, str + "(", leftNum + 1, rightNum, n);
        }
        if (rightNum < leftNum) {
            backtrack(res, str + ")", leftNum, rightNum + 1, n);
        }
    }
}