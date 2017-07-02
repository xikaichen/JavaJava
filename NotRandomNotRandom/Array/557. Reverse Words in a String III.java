public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, j, i - 1);   //it is i - 1, because chars[i] is a blank space.
                j = i + 1;
            }
        }
        reverse(chars, j, chars.length - 1);
        return new String(chars);   //do not use chars.toString();  this will convert chars' address to a string
    }
    
    private void reverse(char[] chars, int j, int i) {
        while (j < i) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            j++;
            i--;
        }
    }
}

