public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // trick: String.valueOf(chars) change char[] to string
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                map.put(key, new LinkedList<String>());
                map.get(key).add(strs[i]);
            }
        }
        List<List<String>> res = new LinkedList<List<String>>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}