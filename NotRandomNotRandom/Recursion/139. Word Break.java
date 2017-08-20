//solution 1: 
// this solution doesn't work for case: "aaaaa......", dict["a", "aa", "aaa",....] because this is a recursion 
// solution, it will stack overflow, because it always check from "a";

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (isInDict(s, wordDict)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isInDict(s.substring(0, i + 1), wordDict) && wordBreak(s.substring(i+1, s.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isInDict(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.equals(wordDict.get(i))) {
                return true;
            }
        }
        return false;
    }
}

//solution 2(dp):
// no recursion solution, use a boolean[] breakable to store the states

public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean [] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && dict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
}