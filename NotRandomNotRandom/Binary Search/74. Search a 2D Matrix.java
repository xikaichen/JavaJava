//solution 1: O(m + n) problem: if m is very big and n = 1...
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

//solution 2: binary search: view matrix as an array
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / matrix[0].length][mid % matrix[0].length]; // the way change matrix coordinate to array cooridiante
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (matrix[left / matrix[0].length][left % matrix[0].length] == target || 
            matrix[right / matrix[0].length][right % matrix[0].length] == target) {
                return true;
            }
        return false;
    }
}