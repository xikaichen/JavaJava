//point 1: string can plus character, "hell" + 'o' = "hello"
//point 2: string is not like list, list is more like a global variable but string is not, so don't need remove

public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(res, "", digits, 0);
        return res;
    }
    
    private void backtrack(List<String> res, String temp, String digits, int start) {
        if (start >= digits.length()) {
            res.add(temp);
            return;
        }
        for (int i = 0; i < KEYS[digits.charAt(start) - '0'].length(); i++) {
            backtrack(res, temp + KEYS[digits.charAt(start) - '0'].charAt(i), digits, start + 1);
        }
    }
}