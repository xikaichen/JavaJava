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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = toBST(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode toBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(nums[(start + end) / 2]);
        root.left = toBST(nums, start, (start + end) / 2 - 1);
        root.right = toBST(nums, (start + end) / 2 + 1, end);
        return root;
    }
}