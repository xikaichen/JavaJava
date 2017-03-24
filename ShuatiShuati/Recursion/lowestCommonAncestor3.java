public class lowestCommonAncestor3 {
    private class ResultType {
        public boolean a_exist, b_exist;
        public TreeNode node;
        ResultType(boolean a, boolean b, TreeNode n) {
            a_exist = a;
            b_exist = b;
            node = n;
    }
}
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType rt = helper(root, A, B);
        if (rt.a_exist && rt.b_exist)
            return rt.node;
        else
            return null;
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        //think about when root == null, what to return
        if (root == null) {
            return new ResultType(false, false, null);
        }
        
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        

        //think when you get left and right and root what result will you return in the last step 
        boolean a_exist = left.a_exist || right.a_exist || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;
        
        //if root == A or B return root and A exist or B exist?
        if (root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
        }
        //if left.node and right.node are both exist return root
        if (left.node != null && right.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        //if left or right node exist return exist one and the boolean variable to represent it exist
        if(left.node != null) {
            return new ResultType(a_exist, b_exist, left.node);
        }
        
        if(right.node != null) {
            return new ResultType(a_exist, b_exist, right.node);
        }
        
        return new ResultType(a_exist, b_exist, null);
    }
}