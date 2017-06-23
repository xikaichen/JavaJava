public class Trie {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    /** Initialize your data structure here. */
    private TrieNode root = new TrieNode();
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }    
        node.item = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode root, String word, int idx) {
        if (idx == word.length()) {
            return !root.item.equals("");
        }
        if (root.children[word.charAt(idx) - 'a'] != null) {
            return search(root.children[word.charAt(idx) - 'a'], word, idx + 1);
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }
    private boolean startsWith(TrieNode root, String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */