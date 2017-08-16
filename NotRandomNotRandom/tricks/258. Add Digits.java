// the hidden parttern
// if num = 0 return 0
// if num % 9 == 0 return 9
// if num % 9 != 0 return num % 9
public class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }
}