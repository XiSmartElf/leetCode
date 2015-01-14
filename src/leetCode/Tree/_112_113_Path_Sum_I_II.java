package leetCode.Tree;
//easy two: use dfs
//112 keep subtracting values from sum when it's 0 . it returns a true meaning find it.
//113 same idea but only excute without returning. it keep path the current path(add current val to it) to the next dfs
//evetually when sum is 0. the current path stored is the final path and it will be stored in the res. same for all possible paths

import java.util.ArrayList;
import java.util.List;

import leetCode.Tree._102_107_104_111_Binary_Tree_Lv_order_Traversal_max_min_depth.TreeNode;

public class _112_113_Path_Sum_I_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//112
    public static boolean hasPathSum(TreeNode root, int sum) {
        
        if(root==null)
            return false;
        return dfs(root, sum);
    }
    
    public static boolean dfs(TreeNode node, int sum)
    {
        if(node==null)
            return false;
        if(node.left==null && node.right==null)
        {
            if(sum-node.val == 0)
                return true;
            else
                return false;
        }
        else
        {
            if(dfs(node.left, sum-node.val)==true || dfs(node.right, sum-node.val)==true ) 
                return true;
            else 
                return false;
        }
        
    }

    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
    
    
    
    
    //113 use dfs recursive
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return res;
        dfs(root, sum, new  ArrayList<Integer>());
        return res;
    }
    
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public void dfs(TreeNode node, int sum, List<Integer> prv_path)
    {
        if(node.left==null && node.right==null)
        {
            if(sum-node.val == 0)
            {
                prv_path.add(node.val);
                res.add(prv_path);
            }
        }
        else
        {
            if(node.left!=null)
            {
                List<Integer> cur_path = new ArrayList<Integer>();
                cur_path.addAll(prv_path);
                cur_path.add(node.val);
                dfs(node.left, sum-node.val, cur_path);
            }
                   
            if(node.right!=null)
            {
                List<Integer> cur_path = new ArrayList<Integer>();
                cur_path.addAll(prv_path);
                cur_path.add(node.val);
                dfs(node.right, sum-node.val, cur_path);
            }
        }
    }
}
