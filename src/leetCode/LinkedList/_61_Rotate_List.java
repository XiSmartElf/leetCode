package leetCode.LinkedList;
//make a dummy infront because head will not be head after swap so we need to return listnode for ref.
//first define two nodes: fast and slow
//let the fast go along the path reaches the end to find the ACTUAL length of the list
//length-n%/length is where is node "m" is to start split--> m | m.next
//let slow goes from dummy to reaches m at m.
//swap: fast node(end) points to the dummy.next or head. slow points to null. dummy.next is then slow.next;

import leetCode._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _61_Rotate_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(3);
		ListNode test3 = new ListNode(4);
		ListNode test4 = new ListNode(5);
		ListNode test5 = new ListNode(6);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;

		ListNode firstLink = test1;
		ListNode returnHead = rotateRight(firstLink, 5);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
		
	}
	//0, 1 2 3 4 5 | 6 (n=7=> 7%6=1 => 6-1=5)
	
    public static ListNode rotateRight(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        if ( head == null) return null;
        
        int len = 0;
        while(fast.next!=null)
        {
        	fast = fast.next;
        	len++;
        }
        //System.out.println(len-n%len);
        for(int i =0; i< len-n%len ;i++)
        {
        	slow = slow.next;
        }
        fast.next = head;
        dummy.next = slow.next;
        slow.next =null;
    	
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
