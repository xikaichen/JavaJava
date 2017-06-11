 public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) { // 迭代的出口
            return 1;
        }
        double temp = myPow(x, n / 2); // 这样就只要算一次myPow(x, n / 2)了
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp; // 3^5 = 3^2 * 3^2 * 3
            } else {
                return (temp * temp) / x; // 3^-5 = (3^-2 * 3^-2) /3
            }
        }
    }
}