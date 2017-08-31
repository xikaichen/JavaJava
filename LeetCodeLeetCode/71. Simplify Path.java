/*

"///abc" split("/")之后会变成["", "", "", "abc"]


*/
public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].equals("")) { // case: /./ or ///abc
                continue;
            }
            if (!stack.isEmpty() && strs[i].equals("..")) { 
                stack.pop();
                continue;
            } else if (stack.isEmpty() && strs[i].equals("..")) { // case: /../
                continue;
            }
            stack.push(strs[i]);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}

