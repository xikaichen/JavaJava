// 排序的写法
// check一个string是不是另一个string的substring的写法

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) 
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            if (i == dictWord.length()) {
                return dictWord;
            }
        }
        return "";
    }
}