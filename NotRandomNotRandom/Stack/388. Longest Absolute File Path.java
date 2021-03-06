public class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while (lev + 1 < stack.size()) { 
                stack.pop(); // find parent, pop until the stack.peek() is the parent
            }
            int len = stack.peek() + s.length() - lev + 1; // remove "\t" ("\t" length = 1, not 2), add"/"
            stack.push(len);
            // check if it is file
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1); 
            }
        }
        return maxLen;
    }
}

// stack里每一级只留一个。
