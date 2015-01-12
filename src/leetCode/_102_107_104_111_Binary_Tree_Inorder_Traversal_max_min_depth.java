package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetCode._110_Balanced_Binary_Tree.TreeNode;
//easy one. i used two queue. one stores the current level nodes. one stores next level nodes.
//when this level is done(empty), move to the next level.

public class _102_107_104_111_Binary_Tree_Inorder_Traversal_max_min_depth {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode test = new TreeNode(1);
		System.out.println(levelOrder(test));
	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> frontier = new LinkedList<TreeNode>();
        Queue<TreeNode> cache = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root==null)
    		return res;
        TreeNode currentRoot = root;
        frontier.add(root);
    	List<Integer> cur_level = new ArrayList<Integer>();
        
        while(true)
        {
	        if(frontier.isEmpty()==false) //level by level
	        {
	        	currentRoot = frontier.poll();
	        	cur_level.add(currentRoot.val);
	        	if(currentRoot.left!=null)
	        		cache.add(currentRoot.left);
	        	if(currentRoot.right!=null)
	        		cache.add(currentRoot.right);  
	        	//for 111 here is if(both==null) return res; make sure res is initialized with 1;
	        }
	        else
	        {
	        	res.add(cur_level); // for 107 question change this to res.add(0,cur_level) so we don;t need to collection.reverse it in the end
	        	//for 104, 111 here is res++;
	        	cur_level = new  ArrayList<Integer>();
	        	if(cache.isEmpty()==false)
	        		frontier.addAll(cache);
	        	else	        	
	        		break;
	        	cache = new LinkedList<TreeNode>();
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
