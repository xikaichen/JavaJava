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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {  // if root is null return false no matter sum equals to what even 0
            return false;
        }
        if (root.val == sum && (root.left == null && root.right == null)) {  // if root.val == sum, we also need root.left = root.right = null to end this
            return true;
        }

        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}