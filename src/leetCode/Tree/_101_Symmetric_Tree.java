package leetCode.Tree;
//easy one// store the sequence of one layer in a var. check the var if it';s symmetric or not. empty(null) put as 0s
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetCode.Tree._112_113_Path_Sum_I_II.TreeNode;

public class _101_Symmetric_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSymmetric(TreeNode root) {
    	if(root==null)
    		return true;
    	Queue<TreeNode> frontier = new LinkedList<TreeNode>();
        Queue<TreeNode> cache = new LinkedList<TreeNode>();
        TreeNode currentRoot = root;
        frontier.add(root);
    	List<Integer> next_level = new ArrayList<Integer>();
    	
        while(true)
        {
	        if(frontier.isEmpty()==false) //level by level
	        {
	        	currentRoot = frontier.poll();
	        	if(currentRoot.left!=null)
	        	{
	        		cache.add(currentRoot.left);
	        		next_level.add(currentRoot.left.val);
	        	}
	        	else
	        	    next_level.add(0);
	        	if(currentRoot.right!=null)
	        	{
	        		cache.add(currentRoot.right);  
	        		next_level.add(currentRoot.right.val);
	        	}
	        	else
	        	    next_level.add(0);
	        }
	        else
	        {
	            int length = next_level.size();
                for(int i=0;i<length/2;i++)
                {
                    if(next_level.get(length/2-1-i)!=next_level.get(length/2-1+1+i))
                        return false;
                }
	        	next_level = new  ArrayList<Integer>();
	        	if(cache.isEmpty()==false)
	        		frontier.addAll(cache);
	        	else	        	
	        		break;
	        	cache = new LinkedList<TreeNode>();
	        }
        }
		return true;
    }

	
	
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
   
}
