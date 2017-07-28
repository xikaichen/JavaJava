public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>(); // check map s to t
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        
        Map<Character, Character> map1 = new HashMap<Character, Character>(); // check map t to s 
        for (int i = 0; i < t.length(); i++) {
            if (map1.containsKey(t.charAt(i))) {
                if (map1.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                map1.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}

// a more elegant way is 
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(b)){
                   map.put(a,b);
                } else {
                    return false;
                }
            }
        }
        return true;
        
    }
}