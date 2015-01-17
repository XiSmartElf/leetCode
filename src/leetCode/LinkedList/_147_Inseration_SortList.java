package leetCode.LinkedList;
//get confused few times on linkedlist reference.
// this one is not hard but easy to make mistake
//used inseration sort
import leetCode.LinkedList._24_Swap_Nodes_in_Pairs.ListNode;

public class _147_Inseration_SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode test1 = new ListNode(100);
		ListNode test2 = new ListNode(0);
		ListNode test3 = new ListNode(11);
		ListNode test4 = new ListNode(7);
		ListNode test5 = new ListNode(5);
		ListNode test6 = new ListNode(0);
		test1.next = test2;
		test2.next = test3;
		test3.next = test4;
		test4.next = test5;
		test5.next = test6;
		
		ListNode returnHead = insertionSortList(test1);
		while(true)
		{
			System.out.println(returnHead.val);
			if (returnHead.next==null)
				break;
			else
				returnHead = returnHead.next;
		}
	}

	
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode move = head;
        ListNode preNode = dummy;

        while(move !=null)
        {
            if(move.val<preNode.val)
            {
                ListNode insert = dummy;
                ListNode move_node = new ListNode(move.val);
                
                while(insert.next!=move)
                {
                    if(insert.val<=move_node.val && insert.next.val >=move_node.val)
                    {
                    	move_node.next = insert.next;
                        insert.next = move_node;
                        preNode.next= move.next;
                        move=preNode;
                        move_node=null; //this part is interesting. it's the unique node. but even if you delete this object. the linkedlist still exits.
                        break;
                    }
                    else
                        insert=insert.next;
                }
            }
            preNode=move;
            move=move.next;
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
