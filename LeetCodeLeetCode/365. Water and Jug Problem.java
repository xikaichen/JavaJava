// This is a pure Math problem.
// Bézout's identity (also called Bézout's lemma):
// let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
// and y such that ax+by=d
// In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by
// every integer of the form ax + by is a multiple of the greatest common divisor d.
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if (x + y < z) {
            return false;
        }
        //case x or y is zero
        if ( x == z || y == z || x + y == z ) {
            return true;
        }
        
        //get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }
    
    // 求最大公约数：辗转相除法，
    // 取两个数中最大的数做除数，较小的数做被除数，用最大的数除较小数，如果余数为0，则较小数为这两个数的最大公约数，
    // 如果余数不为0，用较小数除上一步计算出的余数，直到余数为0，则这两个数的最大公约数为上一步的余数。
    // 下面这样写可以保证a > b 因为如果一开始b比较大 b = a % b，b就会等于a，a就会等于b
    public int GCD(int a, int b){
        while (b != 0 ){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}