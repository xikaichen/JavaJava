public class binaryTreeLongestConsecutivePath {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private class ReturnType {
        int maxFromRoot;
        int maxInSubtree;
        public ReturnType (int maxFromRoot, int maxInSubtree) {
            this.maxFromRoot = maxFromRoot;
            this.maxInSubtree = maxInSubtree;
        }
    }
    public int longestConsecutive(TreeNode root) {
        ReturnType result = helper(root);
        return Math.max(result.maxFromRoot, result.maxInSubtree);
    }
        
        
    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        
        
        //递归的拆解
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        ReturnType result = new ReturnType(1, 0);
        
        //merge
        if (root.left != null && root.val + 1 == root.left.val) {
            result.maxFromRoot = Math.max(result.maxFromRoot, 
                left.maxFromRoot + 1);
        }
        
        if (root.right != null && root.val + 1 == root.right.val) {
            result.maxFromRoot = Math.max(result.maxFromRoot, 
                right.maxFromRoot + 1);
        }
        
        result.maxInSubtree = Math.max(result.maxFromRoot, 
            Math.max(left.maxInSubtree, right.maxInSubtree));
        
        return result;
    }
}