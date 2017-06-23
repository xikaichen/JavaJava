public class WordDictionary {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    /** Initialize your data structure here. */
    private TrieNode root = new TrieNode();

    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        if (word == null) {
            return;
        }
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }
    
    private boolean match(TrieNode root, String word, int idx) {
        if (idx == word.length()) {
            return !root.item.equals("");
        }
        if (word.charAt(idx) == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    if (match(root.children[i], word, idx + 1)) {
                        return true;
                    }
                }
            }
        } else {
            if (root.children[word.charAt(idx) - 'a'] != null) {
                if (match(root.children[word.charAt(idx) - 'a'], word, idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */