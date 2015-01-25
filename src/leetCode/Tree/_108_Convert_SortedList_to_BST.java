package leetCode.Tree;
// binary approach. preorder traversal method.
//get the middle record it and find the left and right sublist and recursively keep going do, return the cur node;
public class _108_Convert_SortedList_to_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
         ListNode run = head;
         int count=1;
         while(run.next!=null)
         {
            run = run.next;
            count++;
         }
         ListNode begin = head;
         return bfs(begin, run, count);
    }
    public TreeNode bfs(ListNode begin, ListNode end, int length)
    {
        //when only two node left
        if(begin.next==end)
        {
            TreeNode node = new TreeNode(end.val);
            node.left = bfs(begin, begin, 1);
            return node;
        }    
        //if only one node left
        if(begin==end)
            return new TreeNode(end.val);
            
        int mid=length/2;
        ListNode midNode = begin;
        ListNode preNode = begin;
        //find the middle of the sublist
        for(int i=0; i<mid;i++)
        {
            preNode = midNode;
            midNode=midNode.next; //now midNode is sitting in the middle now
        }
         //find the life list and right list of the cur node 
        TreeNode node = new TreeNode(midNode.val);
        node.left = bfs(begin, preNode, mid);
        node.right = bfs(midNode.next, end, length-(mid+1));
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
