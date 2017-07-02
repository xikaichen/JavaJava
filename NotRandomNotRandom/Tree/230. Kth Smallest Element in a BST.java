/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// the inorder traverse of BST is ordered
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        //inorder traverse
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                if (k == 0) {
                    break;
                }
                cur = temp.right;
                res = temp.val;
                k--;
            }
        }
        return res;
    }
}