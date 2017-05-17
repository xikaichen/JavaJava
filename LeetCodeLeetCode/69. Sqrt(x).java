public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid > 46340) { // avoid overflow
                right = mid;
            } else if (x > mid * mid) {
                left = mid;
            } else if (x < mid * mid) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (right * right == x) { // the question's requirement unless right * right == x, else return left anyway;
            return right;
        }
        return left;
    }
}