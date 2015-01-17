package leetCode.LinkedList;
//Still two runner solution. But! two runner once the faster catches the slower in the loop.
//Fast restart from the begining node with one step normally speed just like slow one, 
//then they start going and will soon meet at the node where starts the cycle
//doing the math you will know! say we start and meet in the loop point m.
//then faster will go 2S, slower goes S. say distance between starting point and node where starts the cyle is X
//then S-X would be the distance beyound the node starting the cycle
//then S-(S-X) = X which is the meeting point away from the node starting the cyle
//then keep going will soon meet 
//
import leetCode.LinkedList._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _142_LinkedList_Cycle_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		test6.next = test4;
		ListNode firstLink = test1;
		System.out.println(detectCycle(firstLink).val);
	}

	
    public static ListNode detectCycle(ListNode head) {
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	if(head == null)
    		return null;
    	
    	while(true)
    	{
    		if(fast.next!=null && fast.next.next!=null && slow.next!=null)
    		{
	    		fast=fast.next.next;
	    		slow = slow.next;
	    		if(fast == slow)
	    			break;		
    		}
    		else
    			return null;
    	}
    	fast = head;
    	while(true)
    	{
    		fast=fast.next;
    		slow=slow.next;
    		if(slow==fast)
    			return slow;
    	}
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
