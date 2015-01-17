package leetCode.LinkedList;


//define a previous listNode to record next values for result
//list1 and list2 keep being checked each loop
//always get smaller one and put in previous.next and make list(1 or 2)=list(1 or2).next.
//as l1 l2 moves along, one would end first, the result would be leftover for the one with bigger values
//add the leftover to the previous.next to link them together.
//finally return result which preivious did all the work for it
//Note: all the tes1,2,3,4 are not linked like before. They are modified after the function as linkedlist is static

import leetCode.LinkedList._19_Remove_Nth_Node_From_EndofList.ListNode;

public class _21_Merge_Two_Sorted_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode test1 = new _21_Merge_Two_Sorted_Lists().new ListNode(1) ;
		ListNode test2 = new _21_Merge_Two_Sorted_Lists().new ListNode(2) ;
		ListNode test3 = new _21_Merge_Two_Sorted_Lists().new ListNode(2) ;
		
		ListNode test4 = new _21_Merge_Two_Sorted_Lists().new ListNode(1) ;
		ListNode test5 = new _21_Merge_Two_Sorted_Lists().new ListNode(2) ;
		ListNode test6 = new _21_Merge_Two_Sorted_Lists().new ListNode(3) ;
		ListNode test7 = new _21_Merge_Two_Sorted_Lists().new ListNode(4) ;
		
		test1.next = test2;
		test2.next = test3;

		test4.next = test5;
		test5.next = test6;
		test6.next = test7;

		ListNode returnHead = new _21_Merge_Two_Sorted_Lists().mergeTwoLists(test1, test4);
		//System.out.println(test5.next.val);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}
	
	
    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 ==null && l2 ==null)
    		return null;
    	else if(l1==null)
    		return l2;
    	else if(l2==null)
    		return l1;
    	
    	ListNode result = new _21_Merge_Two_Sorted_Lists().new ListNode(0) ;
    	ListNode previous = result;
    	
    	while(l1!=null && l2!=null)
    	{
    		if(l1.val<=l2.val)
    		{
    			previous.next=l1;
    			l1=l1.next;
    		}
    		else
    		{
    			previous.next=l2;
    			l2=l2.next;
    		}
    		previous=previous.next;
    	}
    	//add the rest that didn't join in comparsion part preiviously: it's what's left 
    	if(l1!=null)
    		previous.next=l1;
    	if(l2!=null)
    		previous.next=l2;  	
    	
		return result.next;
        
    }
	
	
	 public  class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }

}
