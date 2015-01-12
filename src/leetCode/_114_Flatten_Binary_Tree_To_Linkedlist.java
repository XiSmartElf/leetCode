package leetCode;
//morris algorithm for binary tree traversal.
//find the left subtree ending point and right subtree  ending point.
//replace right with left and add right node to the left subtree ending point and return the right subtree ending point
//recursively...
//TLE may happen if didn't add(node.left=null)!!!! this is very important!

import leetCode._112_113_Path_Sum_I_II.TreeNode;

public class _114_Flatten_Binary_Tree_To_Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode test1 = new TreeNode(1);
		TreeNode test2 = new TreeNode(2);
		TreeNode test3 = new TreeNode(3);
		TreeNode test4 = new TreeNode(4);
		TreeNode test5 = new TreeNode(5);
		TreeNode test6 = new TreeNode(6);
		TreeNode test7 = new TreeNode(7);
		TreeNode test8 = new TreeNode(8);
		TreeNode test9 = new TreeNode(9);
		
		test1.left = test2;
		test2.left = test3;
		test3.left = test4;
		test3.right = test5;
		test2.right = test6;
		test6.left = test7;
		test6.right = test8;
		test1.right = test9;

		flatten(test1);
		TreeNode start = test1;
		while(start!=null)
		{
			System.out.println(start.val);
			start=start.right;
		}
	}
    public static void flatten(TreeNode root) {
        if(root==null)
            return;
        dfs(root);
        
    }
    
    public static TreeNode dfs(TreeNode node)
    {
        if(node.left==null && node.right==null)
        {
            return node;
        }
        else
        {
            if(node.left!=null && node.right!=null)
            {
                TreeNode tail = dfs(node.left);
                TreeNode final_tail = dfs(node.right);
    
                TreeNode temp = node.right;
                node.right = node.left;
                tail.right = temp;
                return final_tail;
            }
            else if(node.left==null && node.right!=null)
            {
                return  dfs(node.right);  
            }
            else// (node.right==null)
            {
                TreeNode tail = dfs(node.left);
                node.right = node.left;
                return tail;
            }
        }
        
    }
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

}
