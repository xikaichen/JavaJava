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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> res = new LinkedList<Integer>(); //必须用LinkedList<Integer> res = ...才能用addFirst函数
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                res.addFirst(cur.val);
                cur = cur.right;
            } else {
                TreeNode temp = stack.pop();
                cur = temp.left;
            }
        }
        return res;
    }
}