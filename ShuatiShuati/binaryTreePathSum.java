//version 1
public class binaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        temp.add(root.val);
        helper(result, temp, root, target - root.val);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> temp, 
        TreeNode root, int target) { 
        //exit of recursion
        if (target == 0 && (root.left == null && root.right == null)) {
            result.add(new ArrayList(temp));
        }
        //trimming
        if (target != 0 && (root.left == null && root.right == null)) {
            return;
        }
        //traverse
        if (root.left != null) {
            temp.add(root.left.val);
            helper(result, temp, root.left, target - root.left.val);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            helper(result, temp, root.right, target - root.right.val);
            temp.remove(temp.size() - 1);
        }
    }
}

//version 2 use global variable
public class binaryTreePathSum {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();  //use global variable
    private List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        temp.add(root.val);
        helper(root, target - root.val);
        return result;
    }
    
    private void helper(TreeNode root, int target) {  //no need to design API
        if (target == 0 && (root.left == null && root.right == null)) {
            result.add(new ArrayList(temp));
        }
        //trimming, just for saving time
        if (target != 0 && (root.left == null && root.right == null)) {
            return;
        }
        
        if (root.left != null) {
            temp.add(root.left.val);
            helper(root.left, target - root.left.val);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            helper(root.right, target - root.right.val);
            temp.remove(temp.size() - 1);
        }
    }
}
