package leetCode.LinkedList;
//simple Q but need to think carefully on handling the null exception
//When add them up bit by bit from left to right, one may be null earlier than the other if one has shorter length
//need to handle this properly
//define carry and use it along the calculation
//define two dummy and use to scan two list
//define a result node for returning result.next
//define a previous node for storing value for result along the path

import leetCode._19_Remove_Nth_Node_From_EndofList;
import leetCode._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _2_Add_Two_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test1 = new ListNode(0);
		ListNode test2 = new ListNode(7);
		ListNode test3 = new ListNode(9);
		
		ListNode test4 = new ListNode(0);
		ListNode test5 = new ListNode(8);
		//ListNode test6 = new ListNode(4);
		test1.next = test2;
		test2.next = test3;
		
		test4.next = test5;
		//test5.next = test6;

		ListNode returnHead = addTwoNumbers(test1, test4);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode previous = result ;
        
        int carry=0;
        while( l1!= null || l2!= null)
        {
	        ListNode sumNode = new ListNode(0);
	        if(carry==0)
	        {
		        sumNode.val=((l1==null? 0:l1.val) + (l2==null? 0:l2.val))%10;
		        carry =((l1==null? 0:l1.val) + (l2==null? 0:l2.val))>=10? 1 : 0;
	        }
	        else
	        {
		        sumNode.val=((l1==null? 0:l1.val) + (l2==null? 0:l2.val)+1)%10;
		        carry =((l1==null? 0:l1.val) + (l2==null? 0:l2.val))+1>=10? 1 : 0;
	        } 
	        l1=l1==null? l1:l1.next;
	        l2=l2==null? l2:l2.next;

	        previous.next = sumNode;
	        previous = sumNode;
        }
    	if(carry!=0)
    	{
    		ListNode mostBit = new ListNode(1);
    		previous.next = mostBit;
    	}
    	return result.next;
    	
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
