package leetCode.Tree;
//simplied code much easier now.
//easy idea.
//add itself. push left and right child to stack if they are available
//next time pop one as cur node do the same thing.
//unlike preorder traversal you have to push the node itself to the stack since left node has higher priority

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import leetCode.Tree._94_Binary_Tree_Inorder_Traversal.TreeNode;

public class _144_Binary_Tree_Preorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        stack.push(root);
    
        while(!stack.isEmpty())
        {
            TreeNode cur_node = stack.pop();
            if(cur_node==null)  break;
            res.add(cur_node.val);
            if(cur_node.right!=null)   stack.push(cur_node.right);
            if(cur_node.left!=null)    stack.push(cur_node.left);
        }
        return res;
    }
    
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

}
