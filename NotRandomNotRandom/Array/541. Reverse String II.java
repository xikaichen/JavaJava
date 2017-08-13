public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1); //key point：If there are less than k characters left, reverse all of them
            reverse(chars, i, j);
            i += 2 * k;
        }
        return new String(chars);
    }
    
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}