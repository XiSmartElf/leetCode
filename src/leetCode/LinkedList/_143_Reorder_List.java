package leetCode.LinkedList;
//This one is f annoying bc NULL POINTER REF. 
//basic idea is to use fast slow again to find end and mid.
//reverse mid to end
//do 1 by one from the front to insert from value one by one from after mid


public class _143_Reorder_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		//ListNode test5 = new ListNode(5);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		//test4.next = test5;

		ListNode firstLink = test1;
		//reorderList(firstLink);
		reorderList(test1);
		while(true)
		{
			System.out.println(firstLink.val);
			if (firstLink.next==null)
				break;
			else
				firstLink = firstLink.next;
		}
	}
	
    public static void reorderList(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode node = head;
    	
    	if(head == null || head.next == null || head.next.next ==null)
    		return;

    	while(true)
    	{
    		
    		fast=fast.next.next;
    		slow=slow.next;
    		if(fast ==null || fast.next==null)
    			break;
    	}
    	
    	ListNode mid=slow;
    	reverse(mid);
    	while(true)
    	{
			//System.out.println("y");
    		ListNode temp = node.next;
    		ListNode temp2= slow.next.next;
    		node.next = slow.next;
    		slow.next.next =  temp;
    		slow.next = temp2;
    		node = node.next.next;
    		if(temp2==null)
    			break;
    	}      
    }
    
	private static void reverse(ListNode mid) {
		ListNode node = mid.next;
		while(node.next != null)
		{

			ListNode temp = node.next;
			node.next = node.next.next;
			temp.next = mid.next ;
			mid.next=temp;
			temp = null;
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
