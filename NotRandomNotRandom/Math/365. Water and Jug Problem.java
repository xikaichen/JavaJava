// This is a pure Math problem.
// Bézout's identity (also called Bézout's lemma):
// let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers(can be negative) x
// and y such that ax+by=d
// In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by
// every integer of the form ax + by is a multiple of the greatest common divisor d.
// 这道题等价于求x和y的最大公约数。然后看z能不能整除这个数
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) {
            return false;
        }
        //case x or y is zero

        if (x == 0 && y == 0 && z == 0) {
            return true;
        }
        
        //get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }
    
    // 求最大公约数：辗转相除法，
    // 取两个数中最大的数做除数，较小的数做被除数，用最大的数除较小数，如果余数为0，则较小数为这两个数的最大公约数，
    // 如果余数不为0，用较小数除上一步计算出的余数，直到余数为0，则这两个数的最大公约数为上一步的余数。
    // 下面这样写可以保证a > b 因为如果一开始b比较大 b = a % b，b就会等于a，a就会等于b
    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //(7, 5) => (5, 2) => (2, 1) => (1, 0) => 1
    //(18, 12) => (12, 6) => (6, 0) => 6
}


// 模的数不能使0 1 % 0 错 但是 0 % 1是可以的
// 所以x 和 y不能同时为0，他们同时为0的时候 第一个if已经过滤掉大多数情况了 只有一种情况z也是0，这种时候是对的所以需要再加一个判断