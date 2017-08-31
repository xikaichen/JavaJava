/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//高度从0开始，null节点高度是-1
//如果右子树高度是h - 1表示左子树完整，2 ^ h = 1 << h = 左子树节点个数 + root，跳转到右子树，h--
//如果右子树高度小于h - 1，只有可能是h - 2，而且右子树一定是完整的, 所以加上2 ^ (h - 1)跳转到左子树，h--
//recursion
class Solution {
    private int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0) {
            return 0;
        }
        if (height(root.right) == h - 1) {
            return (1 << (h - 1)) + countNodes(root.right);
        } else {
            return (1 << (h - 2)) + countNodes(root.left);
        }
    }
}

//最简单的写法 超时
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }
}

// iterative
class Solution {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h-1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }
}