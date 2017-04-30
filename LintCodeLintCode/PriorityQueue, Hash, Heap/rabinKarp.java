public class rabinKarp {
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }
        int BASE = 1000000;
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = power * 31 % BASE;
        }
        
        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + (target.charAt(i) - 'a')) % BASE;
        }
        
        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + (source.charAt(i) - 'a')) % BASE;
            if (i > m - 1) {
                hashCode = 
                ((hashCode - (source.charAt(i - m) - 'a') * power) % BASE + BASE) % BASE;
            if (i >= m - 1 && hashCode == targetCode) {
                if (source.substring(i - m + 1, i + 1).equals(target)) {
                    return i - m + 1;
                }
            }
            }
        }
        
        return -1;
    }
}