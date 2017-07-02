/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//step1: flatten left and right;
//step2: root.left = null, root.right = left;
//step3: find last node of root;
//step4: lastNode.left = null, lastNode.right = right;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        root.left = null;
        root.right = left;
        TreeNode lastNode = findLastNode(root);
        lastNode.left = null;
        lastNode.right = right;
    }
    
    private TreeNode findLastNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}