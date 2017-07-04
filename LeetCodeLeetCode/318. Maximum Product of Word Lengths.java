public class Solution {
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a'); // 关键：1. 因为只有26个字母，而int可以表示2 ^ 32位，所以可以用int来存不同的字母状态，2. abcabc和abc会是一样的value 3. 这样写就是在不断在不同位置添1
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct)) // 没有一个字母相同的话 AND起来就会是0
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }
}