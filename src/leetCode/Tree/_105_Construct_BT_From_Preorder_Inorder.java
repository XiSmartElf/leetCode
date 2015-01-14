package leetCode.Tree;
//cool idea constructing from info in pre and inorder.
//idea is this:Say we have 2 arrays, PRE and IN. Preorder traversing implies that PRE[0] is the root node.
//Then we can find this PRE[0] in IN, say it's IN[5]. Now we know that IN[5] is root, 
//so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side
//Recursively doing this on subarrays, we can build a tree out of it :)

import leetCode.Tree._144_Binary_Tree_Preorder_Traversal.TreeNode;

public class _105_Construct_BT_From_Preorder_Inorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    	if (preStart > preorder.length - 1 || inStart > inEnd) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int inIndex = 0; // Index of current root in inorder
    	for (int i = inStart; i <= inEnd; i++) {
    		if (inorder[i] == root.val) {
    			inIndex = i;
    		}
    	}
    	root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    	root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    	//index of prestart changes so much becaue it starts from it's right node. it has to skip inIndex-inStart+1 nodes to reach it's right node
    	//inIndex-inStart+1 bc inIndex is absolute index so need to subract it's base and add to prestart
    	return root;
    }  
    
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}
