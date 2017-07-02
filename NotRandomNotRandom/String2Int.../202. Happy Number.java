public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (set.add(n)) { // add the result
            int digit = 0;
            int res = 0;
            while (n > 0) {  // this while loop get the result
                digit = n % 10;
                res += digit * digit;
                n = n / 10;
            }
            if (res == 1) {
                return true;
            }
            n = res;
        }
        return false;
    }
}