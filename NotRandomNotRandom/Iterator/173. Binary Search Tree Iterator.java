/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// not O(h) space, but can pass the test case
// can use Morris inorder traversal, first construct a threaded tree, it cost O(n) time, then set the pointer to left-most node.
// remember recover the original tree after interation
public class BSTIterator {
    private Deque<Integer> inorder = new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                inorder.addLast(temp.val);
                cur = temp.right;
            } 
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (inorder.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return inorder.removeFirst();
    }
}


//solution2: Morris iteration
public class BSTIterator {

    private TreeNode curr;
    public BSTIterator(TreeNode root) {
        TreeNode prev;
        //Do a morris in-order traversal, to construct a threaded binary tree
        curr = root;
        while(curr != null){
            if(curr.left == null){
                curr = curr.right;
            }
            else{
                prev = curr.left;
                while(prev.right != null && prev.right != curr)
                    prev = prev.right;

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    curr = curr.right;
                }
            }
        }

        //get the left-most child of root, i.e. the smallest TreeNode
        curr = root;
        while(curr != null && curr.left != null)
            curr = curr.left;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null;
    }

    /** @return the next smallest number */
    public int next() {

        //copy the value we need to return
        int result = curr.val;

        TreeNode next = curr.right;
        if(next == null)
            curr = next;
        //the right child relationship is a normal one, find left-most
        //child of "next"
        else if(next.left == null || next.left.val > curr.val){
            curr = next;
            while(curr.left != null)
                curr = curr.left;
        }
        //the right child relationship is made when we
        //construct the threaded binary tree
        else{
            curr.right = null;//we recover the original tree structure
            curr = next;
        }

        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */