public class Solution {
    public String minWindow(String S, String T) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) { // 用字典存好T里字符的个数
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }
        
        int start = 0; int end = 0; // 一个start 一个end
        int count = 0; // count用来计算start到end之间有多少个T的元素 如果和T的长度相等了，就说明这个window里包含了T
        int minWinSize = Integer.MAX_VALUE;
        String res = "";
        while (end < S.length()) { // 外层循环end
            if (map.containsKey(S.charAt(end))) { // 想找到一window包含T
                int n = map.get(S.charAt(end)) - 1;
                map.put(S.charAt(end), n);
                if (n >= 0) {
                    count++;
                }
            }
            while (count == T.length()) {  // 里层循环start， 在想办法缩小start，同时更新minWinSize
                int curWinSize = end - start + 1;
                if (curWinSize < minWinSize) {
                    minWinSize = curWinSize;
                    res = S.substring(start, end + 1);
                }
                if (map.containsKey(S.charAt(start))) {
                    int n = map.get(S.charAt(start)) + 1;
                    map.put(S.charAt(start), n);
                    if (n > 0) {
                        count--;
                    }
                }
                start++;
            }
            end++;
        }
        return res;
    }
}