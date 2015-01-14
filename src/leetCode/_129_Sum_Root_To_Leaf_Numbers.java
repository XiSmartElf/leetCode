package leetCode;
///A question must need to think later: when does varible passed to here change!
import leetCode.Tree._101_Symmetric_Tree.TreeNode;

public class _129_Sum_Root_To_Leaf_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public  int sumNumbers(TreeNode root) {
		if(root==null)
			return res;
		res=0;
		dfs(root, 0);
		return res;
	}

	public  int res = 0;

	public  void dfs(TreeNode node, int prv_value)
	{
		if(node.left==null && node.right==null)
		{
			prv_value =prv_value*10+node.val;//A question must need to think later: when does varible passed to here change if change over here, would it affect later use of prv_value. not in this case since we pass constant each time. what if we pass a varible?
			res+=prv_value;
		}
		else
		{
			prv_value=prv_value*10+node.val;
			if(node.left!=null)
			{
				dfs(node.left, prv_value);
			}

			if(node.right!=null)
			{
				dfs(node.right, prv_value);
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