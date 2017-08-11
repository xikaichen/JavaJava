/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BST的inorder traversal是有序的
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                cur = temp.right;
                list.add(temp.val);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}

// recursion
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

//inorder but just one traverse, no need for list
public boolean isValidBST (TreeNode root){
           Stack<TreeNode> stack = new Stack<TreeNode>();
           TreeNode cur = root ;
           TreeNode prev = null ;   // store the previous node        
           while (!stack.isEmpty() || cur != null) {               
               if (cur != null) {
                   stack.push(cur);
                   cur = cur.left ;
               } else {                
                   TreeNode temp = stack.pop() ;
                   if (prev != null && temp.val <= prev.val) {                      
                       return false ;
                   }                   
                   prev = temp ;                       
                   cur = temp.right ;
               }
           }
           return true ; 
       }

