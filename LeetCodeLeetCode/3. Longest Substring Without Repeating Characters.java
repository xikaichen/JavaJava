// sliding window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                index = Math.max(index, map.get(s.charAt(i)) + 1); // index到发现重复的字母的下一个去
            }
            res = Math.max(res, i - index + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}