/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 这道题不只是遍历所有的方案那么简单，首先方案不是从头节点开始的，所以不能用普通的backtrack方法。
// 其次，找到一种方案的时候还不能返回，

// 解决方法是 对左右分治使用pathSum，同时对根节点定义另外一个函数findPath，这样findPath考虑的是从根节点开始的，而pathSum则是从左右子节点为根节点的树开始的
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (sum == root.val) {  //找到一种方案了 还不能返回，所以用了一个全局的变量记录
            res++;
        }
        int left = findPath(root.left, sum - root.val);
        int right = findPath(root.right, sum -root.val);
        return res + left + right;
    }
}