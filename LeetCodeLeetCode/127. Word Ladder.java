// 单向BFS 超时 但是代码是对的
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int minLength = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minLength++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if (set.contains(s)) {
                        continue;
                    }
                    if (isConnected(cur, s)) {
                        if (s.equals(endWord)) {
                            return minLength++;
                        }
                        queue.offer(s);
                        set.add(s);
                    }
                }
            }
        }
        return 0;
    }
    
    private boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}


//双向BFS
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>();
        for (int i = 0; i < wordList.size(); i++) {
            dict.add(wordList.get(i));
        }
        if (!dict.contains(endWord)) { // 题目要求 endWord要在wordList里
            return 0;
        }
        Set<String> start = new HashSet<String>(); // 双向BFS，用两个set，start和end
        Set<String> end = new HashSet<String>();
        start.add(beginWord);
        end.add(endWord);
        dict.remove(beginWord);
        dict.remove(endWord);
        int minLength = 2;
        while (!start.isEmpty()) {
            if (start.size() > end.size()) { // 从size比较小的那个开始搜，其实无所谓只要交替搜索就行了，比如也可以让minLength % 2 == 0的时候start和end交换
                Set<String> temp = start;
                start = end;
                end =temp;
            }
            Set<String> neighbors = new HashSet<String>(); // 记录下一层
            for (String cur : start) {
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char prev = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        if (end.contains(String.valueOf(chars))) {
                            return minLength;
                        }
                        if (dict.contains(String.valueOf(chars))) {
                            neighbors.add(String.valueOf(chars));
                            dict.remove(String.valueOf(chars));
                        }
                    }
                    chars[i] = prev; // 记得变回去
                }
            }
            start = neighbors;
            minLength++;
        }
        return 0;
    }
}



