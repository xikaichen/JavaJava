// sliding window
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(); 
        int res = 0;
        int index = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                index = Math.max(map.get(s.charAt(j)), index);
            }
            res = Math.max(res, j - index + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }
}