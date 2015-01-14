package leetCode.Tree;
//same we need to make sure it's is BST and make sure same height, we always split the array half.
//left half give to the left subtree, right half give to the right subtree and assign the middle as the parent node
//keep splitting like this till low = high meaning nothing can be split.
//such way in the end the diff will be only 1 level. when the last array case is even, then it's child node is only one as left subtree node.


public class _108_Convert_Sorted_Array_To_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }
    
    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
    
    
    public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

}
