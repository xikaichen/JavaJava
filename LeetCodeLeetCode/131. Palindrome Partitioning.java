public class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        List<List<String>> res = new LinkedList<List<String>>();
        List<String> temp = new LinkedList<String>();
        backtrack(res, temp, s);
        return res;
    }
    
    private void backtrack(List<List<String>> res, List<String> temp, String s) {
        if (s.equals("")) { // use equals, not == !!!!
            res.add(new LinkedList(temp));
            return;
        }

        for (int j = 1; j <= s.length(); j++) {
            if (isPalindrom(s.substring(0, j))) {
                temp.add(s.substring(0, j));
                backtrack(res, temp, s.substring(j, s.length()));
                temp.remove(temp.size() - 1);
            }
        }
        
    }
    
    private boolean isPalindrom(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}