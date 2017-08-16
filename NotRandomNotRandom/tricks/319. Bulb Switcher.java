
//solution 1: O(n ^ 2)
public class Solution {
    public int bulbSwitch(int n) {
        int[] states = new int[n];
        for (int i = 0; i < n; i++) {
            states[i] = -1;
        }
        int round = 1;
        while (round <= n) {
            for (int i = round - 1; i < n; i += round) {
                states[i] *= -1;
            }
            round++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (states[i] == 1) {
                count++;
            }
        }
        return count;
    }
}

//solution 2
// Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
// Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6.
// So bulb i ends up on if and only if i is a square.
// Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n]. 
// And 1 is the smallest root. So you have the roots from 1 to R, that's R roots. 
// Which correspond to the R squares. So int(sqrt(n)) is the answer. (C++ does the conversion to int automatically, because of the specified return type).
public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}