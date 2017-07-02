public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //calculate frequency of each character
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        
        //odd frequency or even frequency
        int length = 0;
        int onemore = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                length += map.get(c);
            } else {
                length += 2 * (map.get(c) / 2);
                onemore = 1;
            }
        }
        return length + onemore;
        
    }
}