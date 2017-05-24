// Mainly use two facts"
// 1. Because if we let a = (1337x + c) where c = a mod 1337,
// (1337x + c)(1337x + c)(1337x + c)...(1337x + c) mod 1337 == ccc...c mod 1337.
// 2. a ^ n % b, this is always a pattern. for example 6 ^ n % 7, the pattern is [1, 6, 1, 6, 1, 6, ......]


public class Solution {
    private int DIV = 1337;
    
    List<Integer> findLoop(int a){
        List<Integer> index = new ArrayList<Integer>();
        boolean[] set = new boolean[DIV];
        int rem = a % DIV;
        while (!set[rem] ) {
            set[rem] = true;
            index.add(rem);
            rem = (rem * a) % DIV;
        }
        return index;
    }
    
    int modBy(int[] b, int m){
        int rem = 0;
        for (int i = 0; i < b.length; i++) { // how to compute large number's mod. 
            rem = (rem * 10 + b[i]) % m; // example: 99 % 7.  1: 9 % 7 = 2, 2: (2 * 10 + 9) % 7 = 1
        }
        return rem;
    }

    public int superPow(int a, int[] b) {
        if (a == 0 || a == DIV || b == null || b.length == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        if (a > DIV) {
            return superPow( a % DIV, b);
        }
        List<Integer> index = findLoop(a);
        int loopsize = index.size();
        int rem = modBy(b, loopsize);
        rem = rem == 0 ? loopsize : rem;
        return index.get(rem - 1);
    }
}