package leetCode;
//easy one. differ than one. so recursively check each node's left and right see if they get heights differ more than 1
//
public class _110_Balanced_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public static boolean isBalanced(TreeNode root) {
        int unbalanced = -99;
        return getHeight(root)!=unbalanced;    
    
    }
    public static int getHeight(TreeNode root)
    {
        int unbalanced = -99;
        
        if(root == null)
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left==unbalanced || right==unbalanced || Math.abs(left-right)>1)
            return unbalanced;
            
        return 1+Math.max(left,right);
    }
    
    
    public static class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    	 }

}
