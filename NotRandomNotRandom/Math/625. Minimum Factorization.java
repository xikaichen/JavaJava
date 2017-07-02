public class Solution {
    public int smallestFactorization(int a) {
        // Case 1: If number is smaller than 10
        if (a < 9) {
            return a;
        }

        // Case 2: Start with 9 and try every possible digit
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                a = a / i;
                res.add(i);
            }
        }
        // If n could not be broken in form of digits, like a = 11
        if (a != 1) {
            return 0;
        }
        
        // Get the result from the array in reverse order
        long num = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            num = num * 10 + res.get(i);
            if (num > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) num;
    }
}