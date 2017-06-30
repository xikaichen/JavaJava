public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            //向右
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            //向下
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            //这里要检测一下 还满足条件否因为rowBegin, colEnd都变了，针对只有一行matrix的corner case
            if (rowBegin > rowEnd || colBegin > colEnd) {
                break;
            }
            //向左
            for (int i = colEnd; i >= colBegin; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            //向上
            for (int i = rowEnd; i >= rowBegin; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
}

// similar 59