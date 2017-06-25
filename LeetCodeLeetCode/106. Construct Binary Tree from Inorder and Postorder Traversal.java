/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//和105题很类似，但是注意是postorder 所以是从后朝前，所以要算的也是右子树有多少个数numRight
//然后用postStart - numRight - 1得到了左子树的root，需要自己画图分析
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
		    return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1, map);
        return root;
    }
    
    private TreeNode buildTree(int[] inorder, 
                            int inStart, 
                            int inEnd, 
                            int[] postorder, int postStart, Map<Integer, Integer> map) {
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int rootIdx = map.get(root.val);
        int numRight = inEnd - rootIdx;
        root.left = buildTree(inorder, inStart, rootIdx - 1, postorder, postStart - numRight - 1, map);
        root.right = buildTree(inorder, rootIdx + 1, inEnd, postorder, postStart - 1, map);
        return root;
    }
}