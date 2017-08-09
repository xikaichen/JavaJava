// 螺旋遍历矩阵的模板写法
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int num = 0;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                num++;
                res[rowBegin][i] = num;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                num++;
                res[i][colEnd] = num;
            }
            colEnd--;
            if (rowBegin > rowEnd || colBegin > colEnd) {
                break;
            }
            for (int i = colEnd; i >= colBegin; i--) {
                num++;
                res[rowEnd][i] = num;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) {
                num++;
                res[i][colBegin] = num;
            }
            colBegin++;
        }
        return res;
    }
}

// 更喜欢的一种写法 因为是遍历矩阵 所以当矩阵遍历完就结束循环 比较无脑
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int num = 0, count = 0;
        while (count < n * n) {
            for (int i = colBegin; i <= colEnd; i++) {
                num++;
                res[rowBegin][i] = num;
                count++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                num++;
                res[i][colEnd] = num;
                count++;
            }
            colEnd--;
            if (count >= n * n) {
                break;
            }
            for (int i = colEnd; i >= colBegin; i--) {
                num++;
                res[rowEnd][i] = num;
                count++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) {
                num++;
                res[i][colBegin] = num;
                count++;
            }
            colBegin++;
        }
        return res;
    }
}

