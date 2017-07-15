public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                // 碰到数字，继续找
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) { // continuous number!
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                // 碰到 '[' 把之前的res push进resStack，reset res
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                // 碰到 ']' 从countStack pop出来一个数，重复res这么多次得到新的res
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                // 碰到字母加到res上
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}