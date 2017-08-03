public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int step = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> res = new LinkedList<Integer>();
        int uniqueWord = 0;

        // 统计words里每个词的数量，同时统计有多少个不同的词
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                uniqueWord++;
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        
        // 用map1把最初的map值保存下来 因为之后循环需要初始化map
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.putAll(map);
        
        // 对s建立hashmap
        int[] smapping = new int[s.length()];
        Arrays.fill(smapping, -1);
        int last = s.length() - step + 1;
    
        for (int i = 0; i < last; i++) {
            String segment = s.substring(i, i + step);
            if (map.containsKey(segment)) {
                smapping[i] = 1;
            }
        }
        
        // 开始循环每个i，这里的i < step。因为i >= step会和之前的结果重复
        for (int i = 0; i < step; i++) {
            int left = i, right = i; // 对每个i用minimum window size的方法
            int curUniqueWord = uniqueWord; // 每次循环i的时候初始化uniqueWord和map
            map.putAll(map1);
            while (right < last) {
                // 先移动right
                while (curUniqueWord > 0 && right < last) {
                    if (smapping[right] == 1) {
                        String temp = s.substring(right, right + step);
                        map.put(temp, map.get(temp) - 1);
                        // 当[left, right] window里包含掉了words里temp所有的次数时，这时map.get(temp) = 0，可以去掉一个词
                        if (map.get(temp) == 0) {
                            curUniqueWord--; // 当curUniqueWord到0时说明这个window已经包括了words里所有的词，window的size此时是大于等于words的size的
                        }
                    }
                    right += step;
                    
                    
                } // 当curUniqueWord = 0时，之前已知当前window size 已经包括了words里所有词，但是size有可能大于words，所以开始调节left
                while (curUniqueWord == 0 && left < right) {
                    // 当smapping[left] = 1时，说明s.substring(left, left + step)是words里的词，尝试去掉这个词，看能不能还满足window包括words里所有词
                    if (smapping[left] == 1) {
                        String temp = s.substring(left, left + step);
                        if (map.get(temp) == 0) { // 如果map.get(temp) = 0说明，当前window正好包括了words里的temp这个词，不多不少
                            int length = right - left;
                            if (length / step == words.length) { // 如果正好包括那就添加到结果里
                                res.add(left);
                            }
                            curUniqueWord++; //因为是正好包括temp，不多不少，所以如果跳过，window里就没有words里temp这个词了curUniqueWord++
                        }
                        map.put(temp, map.get(temp) + 1); //因为把temp跳过去了所以temp在map里再加1
                    }
                    left += step;
                }
            }
        }
        return res;
    }
}