public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<String>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) {
                    break;
                }
                count += 1 + words[last].length();
                last++;
            }
            
            String s = "";
            int diff = last - index - 1;
            
            if (last == words.length || diff == 0) {
                // left justified
                s = leftJustified(words, index, last, maxWidth);
            } else {
                s = midJustified(words, index, last, diff, maxWidth, count);
            }
            res.add(s);
            index = last;
        }
        return res;
    }
    
    private String leftJustified(String[] words, int index, int last, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < last; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private String midJustified(String[] words, int index, int last, int diff, int maxWidth, int count) {
        int space = (maxWidth - count) / diff; // space是剩下的空格等分后的长度。
        int rest = (maxWidth - count) % diff; // rest是等分之后 没有除尽的长度。
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < last; i++) {
            sb.append(words[i]);
            if (i < last - 1) {
                for (int j = 0; j <= (space + ((i - index) < rest ? 1 : 0)); j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}