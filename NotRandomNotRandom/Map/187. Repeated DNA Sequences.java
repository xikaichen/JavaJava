// 想要更快用Rabin-Karp算法
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> res = new LinkedList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        for (int i = 0; i <= s.length() - 10; i++) {
            String key = s.substring(i, i + 10);
            if (map.containsKey(key)) {
                if (map.get(key) > 1) {
                    continue;
                }
                res.add(key);
                map.put(key, 2);
            } else {
                map.put(key, 1);
            }
        }
        return res;
    }
}

// 把长度为10的子串都存进map里，然后重复就加到res里 加过的就不用再加了ß