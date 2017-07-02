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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> temp = new LinkedList<Integer>();
        List<String> result = new LinkedList<String>();
        if (root == null) {
            return result;
        }
        temp.add(root.val);
        backtrack(res, temp, root);
        
        for (int i = 0; i < res.size(); i++) {
            result.add(convertToString(res.get(i)));
        }
        return result;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(new ArrayList(temp));
            return;
        }
        
        if (root.left != null) {
            temp.add(root.left.val);
            backtrack(res, temp, root.left);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            backtrack(res, temp, root.right);
            temp.remove(temp.size() - 1);
        }
    }
    
    private String convertToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append("->");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString(); 
    }
}