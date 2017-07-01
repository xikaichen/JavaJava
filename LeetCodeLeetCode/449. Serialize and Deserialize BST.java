/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// 因为是一个bst所以inorder用一个排序就可以得到了
// 只要给出preorder就可以用105题的方法重新构造出bst
// 但是如果只是bt就不行了
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preorder(root);
    }
    private String preorder(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                sb.append(cur.val);
                sb.append(",");
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                cur = temp.right;
            }
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1); // last character is a comma, get rid of it
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] strs = data.split(",");
        int[] preorder = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            preorder[i] = Integer.parseInt(strs[i]);
        }
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));