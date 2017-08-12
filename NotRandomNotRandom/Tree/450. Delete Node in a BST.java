/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 如果key小于root.val去左边删点，如果key大于root.val去右边删点
// 如果key = root.val说明要删除root这个点了
// 这个时候如果root没有左子树或者右子树，就可以返回有的那一边
// 如果都有 去右子树里找最小的，然后root.val = 这个点的val
// 然后去右子树里删掉这个点
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root =root.left;
        }
        return root;
    }
}