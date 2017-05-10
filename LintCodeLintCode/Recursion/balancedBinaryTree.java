public class balancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private class ReturnType {
        boolean isBalanced;
        int height; 
        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        ReturnType res = helper(root);
        return res.isBalanced;
    }
    
    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        boolean isBalanced = false;
        int height = -1;
        if (left.isBalanced && right.isBalanced) {
            if (Math.abs(left.height - right.height) <= 1) {
                isBalanced = true;
                height = Math.max(left.height, right.height) + 1;
            }
        }
        return new ReturnType(isBalanced, height);
    }
}