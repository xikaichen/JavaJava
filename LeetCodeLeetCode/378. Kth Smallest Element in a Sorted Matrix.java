public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
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

//二分搜索 搜索的是区间
// low = mid + 1 和 high = mid 正好分成了两个区间， 如果count < k就在low区间找，如果count >= k就在high区别找
//为什么always return low？ 为什么是 low < high 而不是 <=? 