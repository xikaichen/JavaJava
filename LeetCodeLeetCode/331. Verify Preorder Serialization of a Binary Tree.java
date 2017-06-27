// At the first begining sum = 1, because root doesn't provide indegree. 
// sum = outdegree - indegree, finally sum will be 0.
public class Solution {
    public boolean isValidSerialization(String preorder) {
        int sum = 1;
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            sum--;
            if (sum < 0) {
                return false;
            }
            if (!node.equals("#")) {
                sum += 2;
            }
        }
        return sum == 0;
    }
}