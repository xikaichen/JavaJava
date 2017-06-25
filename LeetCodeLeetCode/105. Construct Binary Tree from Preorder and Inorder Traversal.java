/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//preorder的作用是确定root
//inorder的作用是确定了root后找到root所在的位置，根据这个位置划分left和right然后递归build tree
//找root的位置，对于preorder而言一开始root就是preorder[0], 然后左右两个root位置分别为preStart + 1, preStart + numsLeft + 1
//numLeft就是左边有多少个元素
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.length; i++) { // 用来存 inorder每个值得索引 这样可以O(1)的时间找到rootIdx
            map.put(inorder[i], i);
        }
    
        TreeNode root = buildTree(preorder, 0, inorder, 0, inorder.length - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = map.get(root.val);
        int numsLeft = rootIdx - inStart;
        
        root.left = buildTree(preorder, preStart + 1, inorder, inStart, rootIdx - 1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, inorder, rootIdx + 1, inEnd, map);
        
        return root;
    }
}