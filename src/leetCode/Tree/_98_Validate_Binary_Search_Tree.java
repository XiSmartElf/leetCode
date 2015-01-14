package leetCode.Tree;
//pay attention to the check function and properly hand egdge case is very important.
//the code can be simplified more. check online sol and see the difference. check func can be reduced to 5 lines.
//idea is the same. evaluate a node's left and right. pass proper max and min value.
//realize when every goes to left, the min value doesn't change but the max becomes parent's value. To right, min no change but max us parent's val.
//start with long,maxval and long.minval isn't a good way. check if there is better sol to to it.

import leetCode.Tree._101_Symmetric_Tree.TreeNode;

public class _98_Validate_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    public boolean check(TreeNode node, long max, long min )
    {
        if(node==null)
            return true;
        long limit = node.val;
        
        if(node.left!=null)
            if(node.left.val>=limit || node.left.val<=min)
                return false;
        
        if(node.right!=null)
            if(node.right.val<=limit  || node.right.val>=max)
                return false;
        
        return check(node.left, limit, min) && check(node.right, max, limit);
    }
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

}
