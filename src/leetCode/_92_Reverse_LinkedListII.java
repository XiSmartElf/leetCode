package leetCode;

import leetCode._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _92_Reverse_LinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		//ListNode test3 = new ListNode(9);
		
		//ListNode test4 = new ListNode(0);
		//ListNode test5 = new ListNode(8);
		//ListNode test6 = new ListNode(4);
		test1.next = test2;
		//test2.next = test3;
		//test3.next = test4;
		//test4.next = test5;
		//test5.next = test6;

		ListNode returnHead = reverseBetween(test1, 1, 2);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}

    public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode node = head;
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		dummy.next = head;
		
		int i =1;
    	for(; i<m;i++)
    	{
    		node = node.next;
    		pre = pre.next;
    	}
    	
		for(int k = 0; k< n-i; k++)
		{
			ListNode temp = node.next;
			node.next = node.next.next;
			temp.next = pre.next ;
			pre.next=temp;
			temp = null;
		}
		return dummy.next;
    }
    
    
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
}
