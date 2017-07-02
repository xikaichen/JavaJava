// THIS IS THE BEST OPTIMAL SOLUTION
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
            int cur = matrix[x][y];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}