package leetCode;
//simple and easy. 10mins made it work no error at all. 409ms

public class _86_Partition_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        if(head.next==null) return head;
            
        ListNode dummy=new ListNode(0);
        ListNode dummy2=new ListNode(0);
        dummy.next=head;
        ListNode node1 = dummy;  //used to connect smaller #
        ListNode node2 = dummy2; //used to connect greater or equal #
        
        while(node1.next !=null)
        {
            if(node1.next.val < x) //when it's smaller connect to node1
                node1 = node1.next; 
            else   //when it's bigger or equal, connect to node2
            {
                node2.next = node1.next; //connect it to node2
                node2 = node2.next; //node2 move to next one
                node1.next = node1.next.next; //node1 deletes the next node(
            }
        }
        node2.next=null; //don't forget this. it is the last node in the link
        node1.next = dummy2.next; //connect the two parts together
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
