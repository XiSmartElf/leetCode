package leetCode.Sort;
//merge sort basically. mergesort left and right, and make compare between the two make them in a right order and always return
//the head of the list.

public class _148_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode sortList(ListNode head) {
        if(head ==null) return null;
        int count =1;
        ListNode dummy=head;
        while(dummy.next!=null)
        {
            dummy = dummy.next;
            count++;
        }
        return mergeSort(head, dummy, count);
    }
    
    public ListNode mergeSort(ListNode head, ListNode end, int length)
    {
        if(head==end)
            return head;
        ListNode midNode = head;
        ListNode preNode = head;
        int mid = length/2;
        for(int i =0; i<mid; i++)
        {
            preNode = midNode;
            midNode = midNode.next;
        }
        preNode.next = null;
        
        ListNode left = mergeSort(head,preNode,mid);
        ListNode right = mergeSort(midNode, end, length-mid);
        return compare(left, right);

    }
    
    public ListNode compare(ListNode leftHead, ListNode rightHead)
    {
        ListNode run = new ListNode(0);
        ListNode dummy = run;
        while(true)
        {
            if(leftHead!=null && rightHead!=null)
            {
                if(leftHead.val<rightHead.val)
                {
                    dummy.next = leftHead;
                    leftHead = leftHead.next;
                    dummy = dummy.next;
                }
                else
                {
                    dummy.next = rightHead;
                    rightHead = rightHead.next;
                    dummy = dummy.next;
                }
            }
            else if(leftHead==null && rightHead!=null)
            {
                dummy.next = rightHead;
                break;
            }
            else if(rightHead==null && leftHead!=null)
            {
                dummy.next = leftHead;
                break;
            }
            else //all null
            {
                dummy.next=null; //there is nothing after the last node
                break;
            }
        }
        return run.next;
    }
    
    class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) {
    	         val = x;
    	         next = null;
    	     }
    }

}
