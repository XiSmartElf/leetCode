package leetCode.LinkedList;
//becareful with corner cases.
//two pointers left and right to find the sequence needs to be reversed. if reaches the boundary return
//if found, define another three pointer to do the reverse and do one node at a time
//finally connect the tail and head node to the right nodes, then continue the next sequence

public class _25_Reverse_Nodes_In_K_Group {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test1 =new ListNode(1);
		ListNode test2 = new ListNode(2);
		ListNode test3 = new ListNode(3);
		ListNode test4 = new ListNode(4);
		ListNode test5 = new ListNode(5);
		ListNode test6 = new ListNode(6);
		ListNode test7 = new ListNode(7);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		test5.next = test6;
		//test6.next = test7;
		ListNode run = reverseKGroup(test1,-1);	
		while(run!=null)
		{ System.out.print(run.val); run=run.next;}
		

	}
	
    public static  ListNode reverseKGroup(ListNode head, int k) {
        if(head ==null) return null;
        if(head.next ==null) return head;
        if(k<=1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        ListNode newStart;
        ListNode preNode;

        while(right!=null)
        {
            for(int i =0; i<k; i++)
            {
            	System.out.println("hi");
                right = right.next;
                if(right == null)
                    return dummy.next;
            }
            newStart = right.next;
            preNode = left.next;
            
            ListNode l = preNode;
            ListNode m = preNode.next;
            ListNode r = preNode.next.next;         

            while(true)
            {
                m.next=l;
                l = m ;
                m=r;
                if(r==null || l==right) break;
                r=r.next;
            }
            preNode.next = newStart;
            left.next = right;

            left = preNode;
            right = preNode;

            if(newStart == null)
                break;
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
