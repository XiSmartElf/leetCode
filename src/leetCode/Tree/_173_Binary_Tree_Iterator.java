package leetCode.Tree;
//this one is O(1)time complexity. notice it's average case since O(n)/n
//basic idea is simliar to inorder traversal and validate BST.
//keep going left till nothing on left. that;s your smallest.
//next time start from it's first right node to look for the left most deepest left node(keep going left as last step). if null return this right node. 
//keep doing the same for the rest/
//average time complxity is o1
import java.util.Stack;

import leetCode.Tree._101_Symmetric_Tree.TreeNode;

public class _173_Binary_Tree_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public class BSTIterator {

	    TreeNode cur_node;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    public BSTIterator(TreeNode root) {
	         cur_node = root;      
	         while(cur_node !=null)
	         {
	             stack.push(cur_node);
	                cur_node = cur_node.left;
	         }
	         
	    }
	    
	    /** return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** return the next smallest number */
	    public int next() {
	        cur_node = stack.pop();
	        TreeNode node = cur_node;
	        if(node.right!=null)
	        {
	            node = node.right;
	            while(node!=null)
	            {
	                stack.push(node);
	                node = node.left;
	            }
	        }
	        return cur_node.val;
	    }
	    
	    public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	}

	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
}
