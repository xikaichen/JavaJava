// 二维情况的 prefixSum，关键在于prefixsum的构造方法
public class NumMatrix {
    private int[][] prefixMatrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixMatrix = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixMatrix[i][j] = prefixMatrix[i - 1][j] 
                    + prefixMatrix[i][j - 1] 
                    + matrix[i - 1][j - 1] - prefixMatrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixMatrix[row2 + 1][col2 + 1] 
            - prefixMatrix[row2 + 1][col1] 
            - prefixMatrix[row1][col2 + 1] 
            + prefixMatrix[row1][col1];    
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */