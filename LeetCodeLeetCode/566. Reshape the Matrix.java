// traverse original matrix add element one by one to the new matrix
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int rows = nums.length;
        int cols = nums[0].length;
        if (rows * cols != r * c) {
            return nums;
        }
        int[][] newMatrix = new int[r][c];
        int rowIndex = 0;
        int colIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (colIndex < c) {
                    newMatrix[rowIndex][colIndex] = nums[i][j];
                    colIndex++;
                } else {
                    rowIndex++;
                    colIndex = 0;
                    newMatrix[rowIndex][colIndex] = nums[i][j];
                    colIndex++;
                }
            }
        }
        return newMatrix;
    }
}