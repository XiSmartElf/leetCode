package leetCode.LinkedList;
// cool idea. inorder to find the intersection. we let A and B (new copies to leave the orignial structure) traverse
//A travers to it's end then travers B's path. B does the same thing.
//If they have same length before intersection. they shall meet when they traverse their own way
//if they have diff length, they should meet when they traverse the other's way (the second way)
//count =2 meaning they both have started traverse the other's way
//so they should meet in the intersec when traverse the other's way bc they both travse the same total distance
//if they don't meet in the second time when count==2. then they don't have intersection


public class _160_Intersection_Two_LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ListNode test1 = new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(2);
		ListNode test5 = new ListNode(3);
		ListNode test6 = new ListNode(3);
		ListNode test7 = new ListNode(99);
		ListNode test8 = new ListNode(100);
		test1.next = test2;
		test2.next = test3;
		test3.next = test7;
		
		test4.next = test5;
		test5.next = test6;
		test6.next = test7;
		
		test7.next = test8;

		ListNode returnHead = getIntersectionNode(test1, test4);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
		
	}

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode pA = headA;
    	ListNode pB = headB;
    	
    	if(pA ==null || pB==null)
    		return null;
    	int count = 0;
    	while(count<=2)
    	{
    		if(pA==pB) //if they meet
    			return pA;
    		//else they keep travsing along the path
    		pA = pA.next;
    		pB = pB.next;
    		//if pA travers to the end then start going from headB's path //// same for pB but start goingA's path
    		if(pA==null)
    		{
    			pA = headB;
    			count++;
    		}
    		if(pB == null)
    		{
    			pB = headA;
    			count++;
    		}  		
    	}
    	 return null;
 	
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
