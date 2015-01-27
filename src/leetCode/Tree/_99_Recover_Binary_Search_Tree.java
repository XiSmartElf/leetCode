package leetCode.Tree;
//use inorder traversal to dicover the two diff elems
//I previously needed preorder which didn't consider the root could be one of the elems as well

import java.util.ArrayList;
import java.util.HashMap;

public class _99_Recover_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode test1 = new TreeNode(0);
		TreeNode test2 = new TreeNode(1);
		TreeNode test3 = new TreeNode(1);
		TreeNode test4 = new TreeNode(4);
		TreeNode test5 = new TreeNode(5);
		test1.left=test2;
		//test1.right=test3;
		//recoverTree(test1);
		//System.out.print(test1.val+", "+test1.left.val);//+", "+test1.right.val);

		
	}
	

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

}
