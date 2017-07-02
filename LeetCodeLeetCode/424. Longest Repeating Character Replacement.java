// The initial step is to extend the window to its limit, that is, the longest we can get to with maximum number of modifications. 
// Until then the variable start will remain at 0.
// Then as end increase, the whole substring from 0 to end will violate the rule, so we need to update start accordingly (slide the window). 
// We move start to the right until the whole string satisfy the constraint again. 
// Then each time we reach such situation, we update our max length.
// AAABBBA k = 2
// when end = 5, break the rule, start++, window contains "AABBB"
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) { // when break the rule
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
				count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}