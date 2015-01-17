package leetCode.LinkedList;


// define two nodes. fast node go first. Since it's in reverse order. we let first go first by n steps.
// then slow one goes. slow and fast both go from their postions and keep goinging till fast one reaches the end(at the last node)
//Where next value of fast is null, then slow one is at the deleting position's previous node
//Note if fast goes outof bound, slow would be at the deleting position, so let the fast one sits in the last node


public class _19_Remove_Nth_Node_From_EndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(2);
		ListNode test4 = new ListNode(2);
		ListNode test5 = new ListNode(3);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		ListNode firstLink = test1;
		ListNode returnHead = removeNthFromEnd(firstLink, 210);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0; i< n; i++)
        {
        	fast = fast.next;
        	if(fast==null)
        		return slow.next;
        }
        
        while(fast.next !=null)
        {
        	fast=fast.next;
        	slow=slow.next;
        }
        slow.next = slow.next.next;
        return head;

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