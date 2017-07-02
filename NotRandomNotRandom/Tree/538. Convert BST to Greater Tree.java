/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//modified inorder traverse. start from the right
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int totalSum = 0;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                TreeNode temp = stack.pop();
                cur = temp.left;
                temp.val += totalSum;
                totalSum = temp.val;
            }
        }
        return root;
    }
}