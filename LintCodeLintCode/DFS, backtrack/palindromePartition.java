public class palindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        backtrack(s, res, temp, 0);
        return res;
    }
    
    private void backtrack(String s, List<List<String>> res, List<String> temp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s.substring(start, i + 1))) {
                temp.add(s.substring(start, i + 1));
                backtrack(s, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}