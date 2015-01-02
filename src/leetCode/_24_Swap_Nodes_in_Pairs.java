package leetCode;
//make a dummy listnode and add infront of the linkedlist to avoid first special case
//swap involves three nodes each time. node1,2,3
//node1 links to 3, 3 links to 2, 2links to 3.next (to swap 2 and 3 )
//keep doing till no more than 2 available next values for swap
//return the dummy.next as the result

import leetCode._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _24_Swap_Nodes_in_Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		ListNode test5 = new ListNode(5);
		ListNode test6 = new ListNode(6);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		test5.next = test6;
		ListNode firstLink = test1;
		ListNode returnHead = swapPairs(firstLink);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}
	
	
    public static ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
    	if(head == null)
    		return null;
    	
    	for(ListNode cur = start; cur.next!=null && cur.next.next!=null; cur = cur.next.next)
    	{	
    		ListNode next1 = cur.next;
    		ListNode next2 = cur.next.next;
    		cur.next = next2;
    		swap(next1,next2);
    	}
        return start.next;
    	
    }
    public static void swap(ListNode next1, ListNode next2)
    {
    	next1.next = next2.next;
    	next2.next = next1;
    }
   
    public static class ListNode 
    {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	 }
}
