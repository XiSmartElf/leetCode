package leetCode.Tree;
//this one no recursion, two ways doing it. 
//easy one but kinda hard to imagine as you cannot do recursion
//two methods both good but little hard to think of it.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetCode.Tree._114_Flatten_Binary_Tree_To_Linkedlist.TreeNode;

public class _94_Binary_Tree_Inorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//method one. traditional method doing DFS iteratively no recursion! but with a stack
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        stack.push(root);

        while(!stack.isEmpty())
        {
           TreeNode cur_node = stack.pop();

            if(cur_node == null)
            {//go one step up in the stack must be it's parent which is for sure not a null so you can add it to res.
                if(stack.isEmpty()==false)
                    res.add(stack.pop().val);
            }
            else
            {
                stack.push(cur_node.right);
                stack.push(cur_node);
                stack.push(cur_node.left);
            }
            
        }
        return res;
    }
    //method 2: iterative not recursion 
    //same idea but no stack. move to left and keep moving left add.
    //when nothing on left. add the one step above val(the middle) and then move to right do the same thing
    //this one is more intuitive than the fist method. same idea but not pushing everything to it.it leads the direction
    //not pushing to the stack
    
    public ArrayList<Integer> inorderTraversal2(TreeNode curr) {
        Stack<TreeNode> todo = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!todo.isEmpty() || curr != null){
            if(curr != null){
                todo.add(curr);
                curr = curr.left;
            }
            else{
                curr = (TreeNode)todo.pop();
                res.add(new Integer(curr.val));
                curr = curr.right;
            }
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
