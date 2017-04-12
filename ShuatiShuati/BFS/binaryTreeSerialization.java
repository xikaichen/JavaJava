
class binaryTreeSerialization {
    /*
    compare string use equals. Becasue string is an object, == compare the memory location instead of their value
    so if you use s1 = "1", s2 = new String("1").  s1 != s2.  But if you use s1 = "1", s2 = "1" then s1 == s2. This is 
    because java has a string buffer. When you create a new string object, java first find if there is same value in 
    string buffer, if there is s1 and s2 can use the same memory location, but once you use new keyword that means you don't want 
    java use the value in string buffer. So this time s1 and s2 have different memory location s1 != s2, but s1.equals(s2) is true
    */
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null) {
            return str.toString();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        str.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                str.append(",");
                str.append(cur.left.val);
            } else {
                str.append(",#");
            }
            
            if(cur.right != null) {
                queue.offer(cur.right);
                str.append(",");
                str.append(cur.right.val);
            } else {
                str.append(",#");
            }
        }
        
        return str.toString();
    }
    

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode cur = queue.poll();
                if (!vals[index].equals("#")) {
                    cur.left = new TreeNode(Integer.parseInt(vals[index]));
                    queue.offer(cur.left);
                }
                index++;
                if (!vals[index].equals("#")) {
                    cur.right = new TreeNode(Integer.parseInt(vals[index]));
                    queue.offer(cur.right);
                }
                index++;
            }
            
        }
        return root;
        
    }
}
