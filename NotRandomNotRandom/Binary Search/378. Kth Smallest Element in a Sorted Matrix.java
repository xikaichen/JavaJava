public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1; // j + 1, where mid should locate
            }
            if (count < k) {
                low = mid + 1; // don't know why
            } else {
                high = mid;
            } 
        }
        return low;
    }
}

// 1. 为什么能保证low一定在matrix里
// 注意count统计的事 matrix里 小于等于mid的值的个数，如果mid不在matrix而count >= k此时，high = mid，idea和first bad version很像
// 我们其实是要找第一个满足count == k的点，而这个点一定在matrix里的，比如low = high = 15是第k小的元素，确实可能有
// 16，17这些不在matrix里的值也满足比他们小的有k个，但是high = mid保证了，我们找到最小的也就是15，14就不可能了，因为
// 15在矩阵里，如果是14的话就不包括15了也就不可能是第k小的了。

//2. 为什么always return low？ 为什么是 low < high 而不是 <=? 
// 因为出循环的条件是low < high，而二分搜索规则是low = mid + 1, high = mid，所以low最多变成了等于high，然后就跳出循环
// 所以return low 或者 return high是一样的。

//3. 为什么要用low = mid + 1
// 因为要配合low < high使用，希望的是low = high的时候返回，如果像之前一样使用low = mid，返回条件变成
// low + 1 < high，那么还需要判断low是第k小的还是high是第k小的 很麻烦