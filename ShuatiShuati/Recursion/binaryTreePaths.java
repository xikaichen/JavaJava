public class binaryTreePaths {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        List<Integer> temp = new ArrayList<Integer>();
        if (root == null) { //here we check root == null
            return result;
        }
        temp.add(root.val);  
        helper(result, temp, root);
        return result;
    }
    
    private void helper(List<String> result, List<Integer> temp, TreeNode root) {
        //出口
        if (root.left == null && root.right == null) {  //so here we just need to check root's children
            result.add(convertToString(new ArrayList(temp)));
        }
        
        //traverse
        if (root.left != null) {    //similar to for-loop
            temp.add(root.left.val);
            helper(result, temp, root.left);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            helper(result, temp, root.right);
            temp.remove(temp.size() - 1);
        }
    }
    
    private String convertToString(List<Integer> temp) {
        String res = "";
        for(int i = 0; i < temp.size() - 1; i++) {
            res += temp.get(i) + "->";
        }
        res += temp.get(temp.size() - 1);
        return res;
    }
}