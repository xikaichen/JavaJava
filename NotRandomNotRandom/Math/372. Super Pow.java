// Mainly use three facts"
// 1. Because if we let a = (1337x + c) where c = a mod 1337,
// (1337x + c)(1337x + c)(1337x + c)...(1337x + c) mod 1337 == ccc...c mod 1337.
// 2. a ^ n % b, this is always a pattern. for example 6 ^ n % 7, the pattern is [1, 6, 1, 6, 1, 6, ......]
// 3. a % b = rem, a * a % b = rem * a % b = newrem(new), a * a * a = newrem * a % b....

public class Solution {
    private int DIV = 1337;
    
    List<Integer> findLoop(int a){
        List<Integer> index = new LinkedList<Integer>(); // a * b * c % DIV = (((a % DIV) * b) % DIV) % DIV, 对于很多数字相乘求模 可以用第一个数取模，用模去乘以接下来的数字
        boolean[] set = new boolean[DIV]; // the pattern size would be over DIV
        int rem = a % DIV;
        while (!set[rem]) {
            set[rem] = true;
            index.add(rem);
            rem = (rem * a) % DIV;
        }
        return index;
    }
    
    int modBy(int[] b, int m) { // 找大数字的模 可以这么做
        int rem = 0;
        for (int i = 0; i < b.length; i++) {
            rem = (rem * 10 + b[i]) % m; // example: 99 % 7.  1: 9 % 7 = 2, 2: (2 * 10 + 9) % 7 = 1
        }
        return rem;
    }
    // a ^ b，先把a变成一个小于DIV的数，用fact 1
    // 再用fact 2 找到pattern
    // 再用b去模pattern的size找到结果在pattern中的位置
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
// 步骤
// 1. 用a mod 1337把a变成比1337小的数字c
// 2. 求出c ^ b mod 1337的pattern(findLoop函数)
// 3. 用b mod 1337(modBy函数)确定a ^ b mod 1337在pattern的什么位置