// wiki what is gray code
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}