class minSubtree {
	/** two global variable store the global minPath and subtree node 
	 * the idea of traverse*/
	private int minPath = Integer.MAX_VALUE; 
	private TreeNode subtreeNode = null;
	//design API
	public TreeNode findMinSubtree(TreeNode root) {
		helper(root);
		return subtreeNode;
	}

	private int helper(TreeNode root) {
		//the exit of recursion
		if (root == null) {
			return 0;
		}
		//conquer
		int left = helper(root.left);
		int right = helper(root.right);

		//merge
		int result = left + right + root.val;
		if (result < minPath) {
			minPath = result
			subtreeNode = root;
		}
		return result;
	}
}