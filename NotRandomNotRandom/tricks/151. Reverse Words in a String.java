//1. trim
//2. split + regex
//3. join
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        reverse(words);
        return String.join(" ", words);
    }
    
    private void reverse(String[] words) {
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
    }
}