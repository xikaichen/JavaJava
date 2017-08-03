public class Solution {
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }
    
    public TrieNode buildTree(TrieNode root, List<String> dict) {
        for (String s : dict) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.word = s;
        }
        return root;
    }
        
    public String replaceShortest(String s, TrieNode root) {
        StringBuilder sb = new StringBuilder();
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return s;
            }
            sb.append(c);
            temp = temp.children[c - 'a'];
            if (temp.word.equals(sb.toString())) {
                return sb.toString();
            }
        }
        return s;
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        root = buildTree(root, dict);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String str : words) {
            sb.append(replaceShortest(str, root));
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length()-1);
    }
}