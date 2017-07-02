public class Solution {
    public int findNthDigit(int n) {
        n = n - 1; // very trick
        int digits = 1;
        int first = 1;
        while (n / (9 * digits * first) >= 1) { //to see if n is in this range. like if n ~(100,999) then n / (9*10*2) >= 1 but n / (9*100*3) < 1, so n is in three digits number's range
            n -= 9 * digits * first;
            digits++;
            first *= 10;
        }
        return (first + n / digits + "").charAt(n % digits) - '0';
        // n / digits表示多少个数，比如n / digits = 3表示第三个数，那么就是100, 101, 102。 所以表示的是102 但是first + n / digits已经把第一个数包括了
        // 这样算出来会是103 所以要使用n = n - 1;
    }
}

