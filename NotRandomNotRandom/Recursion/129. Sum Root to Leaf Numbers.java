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
    public int sumNumbers(TreeNode root) {
        return sumNodes(root, 0);
    }

    private int sumNodes(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        int left = sumNodes(root.left, currentSum);
        int right = sumNodes(root.right, currentSum);
        return left + right;
    }
}


// preorder traversal, don't know how to not use recursion, using stack instead
public class Solution {
    public int total;
    
    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    
    public void helper(TreeNode root, int sum) {
        if (root == null) return;
        
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        
        helper(root.left, sum);
        helper(root.right, sum);
    }
}