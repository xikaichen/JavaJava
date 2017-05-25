//solution 1: but use long: O(log(n))
public class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = (int) mid;
            } else {
                left = (int) mid;
            }
        }

        if (left * left == num || right * right == num) {
            return true;
        }
        return false;
    }
}

//solution2: A square number is 1+3+5+7+....  O(sqrt(n))
public boolean isPerfectSquare(int num) {
     int i = 1;
     while (num > 0) {
         num -= i;
         i += 2;
     }
     return num == 0;
 }