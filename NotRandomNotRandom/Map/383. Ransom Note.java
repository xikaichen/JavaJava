// 从杂志上剪字下来拼成赎金条
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            map[ransomNote.charAt(j) - 'a']--;
        }
        for (int k = 0; k < map.length; k++) {
            if (map[k] < 0) {
                return false;
            }
        }
        return true;
    }
}