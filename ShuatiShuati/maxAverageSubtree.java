class maxAverageSubtree {
	//return type
	private class ReturnType {
		public int sum;
		public int size;
		public ReturnType (int sum, int size) {
			this.sum = sum;
			this.size = size;
		}
	}
	/**two global variable to store the golobal maximum subtreevalue and subtree node
	 * idea of traverse. **/
	private TreeNode subtreeNode = null;
	private ResultType subtreeResult = null;

	/**main body function, design the API. We want to return a TreeNode, if we want to use recursion, it is
	 * not enough just return a TreeNode. We need return ResultType which include sum and size so need a helper */
	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return subtreeNode;
	}
	//helper funtion, the idea of divide and conquer
	private ResultType helper(TreeNode root) {
		// the exit of recursion
		if (root == null) {
			return new ResultType(0, 0);
		}

		//conquer
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		//merge
		ResultType result = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);  //local value
		if (subtreeNode == null || result.sum * subtreeResult.size > subtreeResult.sum * result.size) {
			subtreeNode = root;
			subtreeResult = result;
		}
		return result;
	}
}