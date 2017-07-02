public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        int time = 1;
        while (time != n) {
            str = generateFrom(str);
            time++;
        }
        return str;
    }
    
    private String generateFrom(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count));
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}