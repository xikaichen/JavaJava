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
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left); // get left subtree's total sum
        int right = sum(root.right); // get right subtree's total sum
        return Math.abs(left - right) + findTilt(root.left) + findTilt(root.right); // return left - right + tilt of left subtree + tilt of right subtree
    }
    
    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        return root.val + left + right;
    }
}