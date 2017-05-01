public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c = stack.pop();
                if (chars[i] == ')' && c != '(') {
                    return false;
                }
                if (chars[i] == ']' && c != '[') {
                    return false;
                }
                if (chars[i] == '}' && c != '{') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}