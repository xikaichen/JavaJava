public class Solution {
    public String[] findWords(String[] words) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        List<String> res = new LinkedList<String>();
        map.put(1, "qwertyuiop");
        map.put(2, "asdfghjkl");
        map.put(3, "zxcvbnm");
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toLowerCase().toCharArray();
            if (checkSameRow(chars, map)) {
                res.add(words[i]);
            }
        }
        return res.toArray(new String[0]);   //when you don't know the size of Array, you can use List store the result, then use toArray() convert it to array
    }                                        // notice there used new String[0], will convert object[] to string[], remember this. Don't know why for now.
    
    private int findRow(char c, HashMap<Integer, String> map) {
        for (int i = 1; i <= 3; i++) {
            for (char w : map.get(i).toCharArray()) {
                if (w == c) {
                    return i;
                }
            }
        }
        return 0;
    }
    
    private boolean checkSameRow(char[] chars, HashMap<Integer, String> map) {
        int row = findRow(chars[0], map);
        for (int j = 1; j < chars.length; j++) {
            if (findRow(chars[j], map) != row) {
                return false;
            }
        }
        return true;
    }
}