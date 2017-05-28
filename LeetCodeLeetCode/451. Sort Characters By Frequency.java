public class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        //bucket sort
        List<Character>[] bucket = new List[len + 1];
        for (Character c : map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<Character>();
            }
            bucket[freq].add(c);
        }
        
        String res = "";
        for (int i = len; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    char[] repeat = new char[i];
                    Arrays.fill(repeat, bucket[i].get(j));
                    res += new String(repeat);
                }
            }
        }
        return res;
    }
}