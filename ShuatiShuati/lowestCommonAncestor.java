public class lowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        //think about when root == null what to return
        if (root == null || root == A || root == B) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        //think about when you get left and right, how you use it along with root to get the return result
        if (left == null && right == null && (root == A || root == B)) {
            return root;
        }
        
        if (left != null && right == null) {
            return left;
        }
        
        if (right != null && left == null) {
            return right;
        }
        
        if (right != null && left != null) {
            return root;
        }
        
        return null;
    }
}