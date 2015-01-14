package leetCode.LinkedList;

//easy one.

import leetCode._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _83_Remove_Duplicates_from_Sorted_List {

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
		ListNode returnHead = deleteDuplicates(firstLink);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode previous = head;
        ListNode current =head;
        
        while(true)
        {
            if(current==previous && current.next == null)
                return head;
            else if (current == previous)
            {
            	previous = current;
        		current = current.next;
            }
        	if(current.val == previous.val)
        	{
        		previous.next = current.next;
        		current = current.next;
        	}
        	else
        	{
        		previous = current;
        		current = current.next;
        	}
        	if(current==null)
        		break;
        }
        
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
