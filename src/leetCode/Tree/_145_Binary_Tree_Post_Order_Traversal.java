package leetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import leetCode.Tree._105_Construct_BT_From_Preorder_Inorder.TreeNode;
//easy and quick if get the Preoder correctly
//since pre is self- lef-right
//we can do it as self-right -left and simply reverse it at the end

public class _145_Binary_Tree_Post_Order_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        stack.push(root);
    
        while(!stack.isEmpty())
        {
            TreeNode cur_node = stack.pop();
            if(cur_node==null)  break;
            res.add(cur_node.val);
            if(cur_node.left!=null)    stack.push(cur_node.left);
            if(cur_node.right!=null)   stack.push(cur_node.right);

        }
        Collections.reverse(res);
        return res;
        
    }
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	

}
