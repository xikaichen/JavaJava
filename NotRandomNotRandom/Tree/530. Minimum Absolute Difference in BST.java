/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 因为这是一个BST 所以可以用inorder去求，因为inorder后是sorted的
// min difference 只有可能出现在相邻的两个点中，time complexity O(N), space complexity O(1).
// 容易一点的写法可以是 先inorder存起来， 然后两两相减求min
public class Solution {
    private int min = Integer.MAX_VALUE;
    private Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
// 如果不是BST 有更通用的解法 time complexity O(NlgN), space complexity O(N).
// 用treeset
public class Solution {
    TreeSet<Integer> set = new TreeSet<Integer>();
    int min = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) { // 取离root.val最接近的两个 算最短距离
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }
        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        return min;
    }
}