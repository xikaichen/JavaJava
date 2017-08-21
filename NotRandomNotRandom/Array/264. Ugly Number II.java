// factor只用于临时存结果，结果是由因子2，3，5乘以res得到的
public class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            res[i] = min;
            if (min == factor2) {
                index2++;
                factor2 = 2 * res[index2]; //1*2, 2*2, 3*2,...
            }
            if (min == factor3) {
                index3++;
                factor3 = 3 * res[index3];
            }
            if (min == factor5) {
                index5++;
                factor5 = 5 * res[index5];
            }
        }
        return res[n - 1];
    }
}
    //index2
// (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
    //index3
// (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
    //index5
// (3) 1×5, 2×5, 3×5, 4×5, 5×5, …