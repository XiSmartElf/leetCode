package leetCode.Tree;
//this is a cool one. a hard one but idea is simple
//since the longest might be from child to parent and then to another child, we can do liket this using dfs:
//search each node:
//check left max, check right max
//left max+right max+node itself is the node's fitness. basically if we select this node as our turnning node, the fiteness value would be the max
//return node.val+max of(left max, right max) so that we know which path has the max path.
//dont get confused between global max and return value
//return val is to check which side has max val of a node. global max is to check which node has the max value(combine left and right and itself)
import leetCode.Tree._145_Binary_Tree_Post_Order_Traversal.TreeNode;

public class _124_Binary_Tree_Maximum_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        max=root.val;
        dfs(root);
        return max;
    }
    int max = 0;
    
    public int dfs(TreeNode node)
    {
        int left = 0; int right = 0;

        if(node.left!=null)
            left = dfs(node.left);
        if(node.right!=null)
            right = dfs(node.right);
        
        left=left>0? left:0;
        right=right>0? right:0;
        
        if(left+right+node.val>max)
            max=left+right+node.val;
        
        return node.val+Math.max(left,right);
    }
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	

}
