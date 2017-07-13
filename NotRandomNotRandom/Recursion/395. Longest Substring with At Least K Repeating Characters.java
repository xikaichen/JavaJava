public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str,0,s.length(),k);
    }
    private int helper(char[] str, int start, int end,  int k){
        if (end - start < k) {
            return 0; // substring length shorter than k.
        }
        int[] count = new int[26];
        for (int i = start; i < end; i++) { // count the number of every character
            int idx = str[i] - 'a';
            count[idx]++;
        }
        for (int i = 0; i < 26; i++) { // loop throught all 26 character
            if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it. count[i] < k means substring cannot include this letter
                for (int j = start; j < end; j++) {
                    if (str[j] == i + 'a') { // get the character that count[i] < k, split based on it.
                        int left = helper(str, start, j, k);
                        int right = helper(str, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start; // not enter if, then it means all letter appears at least k times.
    }
}