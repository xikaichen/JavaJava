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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }
    
    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {  // check if both are null
            return left == right;
        }
        if (left.val != right.val) {  //check val instead of node itself
            return false;
        }
        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);  // check left.left and right.right and left.right and right.left
    }
}