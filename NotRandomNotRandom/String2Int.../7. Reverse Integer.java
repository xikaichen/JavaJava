// To avoid overflow check if the newResult equals rev

public class Solution {
    public int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        int rev = 0;
        int pos = 1;
        if ( x < 0) {
            pos = -1;
        }
        x = Math.abs(x);
        while (x != 0) {
            int newResult = rev * 10 + x % 10;
            if ((newResult - x % 10) / 10 != rev) {
                return 0;
            }
            rev = newResult;
            x = x / 10;
        }
        return pos * rev;
    }
}
