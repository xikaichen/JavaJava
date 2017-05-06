public class Solution {
    public char findTheDifference(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < charsS.length; i++) {
            if (map.containsKey(charsS[i])) {
                map.put(charsS[i], map.get(charsS[i]) + 1);
            } else {
                map.put(charsS[i], 1);
            }
        }
        
        for (int j = 0; j < charsT.length; j++) {
            if (map.containsKey(charsT[j]) && map.get(charsT[j]) > 0) {
                map.put(charsT[j], map.get(charsT[j]) - 1);
            } else {
                map.put(charsT[j], 1);
            }
        }
        
        char res = '0';
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
                res = key;
            }
        }
        return res;
        
    }
}