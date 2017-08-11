// divide and conquer
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        if (input == null || input.length() == 0) {
            return res;
        }
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*' || c == '-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer i1 : left) {
                    for (Integer i2 : right) {
                        if (c == '+') {
                            res.add(i1 + i2);
                        } else if (c == '*') {
                            res.add(i1 * i2);
                        } else {
                            res.add(i1 - i2);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) { // corner case like: "2", or "2 - 1"
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}