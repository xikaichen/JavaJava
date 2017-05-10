/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// because want all solution, so try DFS
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new LinkedList<Integer>();
        temp.add(root.val);
        backtrack(res, temp, root, sum);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum) {
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new LinkedList<>(temp));
        } 
        if (root.left != null) {    // standard DFS will search all (usually use for-loop, but this is a binary tree, so only left and right)
            temp.add(root.left.val);
            backtrack(res, temp, root.left, sum - root.val);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            backtrack(res, temp, root.right, sum - root.val);
            temp.remove(temp.size() - 1);
        }
    }
}