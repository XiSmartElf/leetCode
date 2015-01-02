package leetCode;
//the fast and slow runner problem.
//To determine cycle apprerance
//we let two people run together. one runs faster by two next, the other runs slower by one next only.
//if there is a cyle, the eventually will meet as the faster catches the slower one in the loop
import leetCode._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _141_LinkedList_Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(2);
		ListNode test4 = new ListNode(2);
		ListNode test5 = new ListNode(3);
		ListNode test6 = new ListNode(3);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		test5.next = test4;
		ListNode firstLink = test1;
		System.out.println(hasCycle(firstLink));
	}

	
    public static boolean hasCycle(ListNode head) {
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	if(head == null)
    		return false;
    	
    	while(fast.next!=null && fast.next.next!=null && slow.next!=null)
    	{
    		fast=fast.next.next;
    		slow = slow.next;
    		if(fast == slow)
    			return true;
    	}
    	return false;
    }
}
