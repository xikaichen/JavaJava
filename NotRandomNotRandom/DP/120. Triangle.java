//top to bottom, ugly code. 因为要处理边界，下面比上面多
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
            int preEnd = triangle.get(i - 1).size() - 1;
            int end = triangle.get(i).size() - 1;
            triangle.get(i).set(end, triangle.get(i).get(end) + triangle.get(i - 1).get(preEnd));
        }
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            for (int j = 1; j < cur.size() - 1; j++) {
                cur.set(j, Math.min(cur.get(j) + triangle.get(i - 1).get(j - 1), 
                            cur.get(j) + triangle.get(i - 1).get(j)));
            }
        }
        List<Integer> temp = triangle.get(triangle.size() - 1);
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size(); i++) {
            minPath = Math.min(minPath, temp.get(i));
        }
        return minPath;
    }
}

//bottom to top, nice code， 不需要处理边界，代码简洁
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}