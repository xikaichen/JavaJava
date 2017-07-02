/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        
        int maxKey = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        List<Integer> temp = new LinkedList<Integer>();
        for (int key : map.keySet()) { // find max frequency
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
            }
        }
        for (int key : map.keySet()) { // based on max frequency to find the key
            if (map.get(key) == maxFreq) {
                temp.add(key);
            }
        }
        int[] res = new int[temp.size()]; // convert list to array
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
    
    private int getSum(TreeNode root) { // recursion to get every node's sum
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        int subSum = root.val + left + right;
        map.put(subSum, map.getOrDefault(subSum, 0) + 1);
        return subSum;
    }
}