// 用recursion 因为要求所有可能 应该想到DFS
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        String temp = "";
        backtrack(res, temp, s, 0, 0);
        return res;
    }
    
    private void backtrack(List<String> res, String temp, String s, int start, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && start == s.length()) {
            res.add(new String(temp));
        }
        for (int i = 1; i < 4; i++) {
            if (start + i > s.length()) {
                break;
            }
            String tokens = s.substring(start, start + i);
            if (tokens.length() > 1 && tokens.charAt(0) == '0' || Integer.parseInt(tokens) > 255) {
                continue;
            } // 如果有连续的0 只加一个0
            backtrack(res, temp + tokens + (count == 3 ? "" : "." ), s, start + i, count + 1);
        }
    }
}