package leetCode.Heap;
// use priority queue to sort all the k lists 
//then use a new node to link to them one by one by poll one out each time and set as the next
//there is one thing i don't understand.. check the comment below!!!!
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _23_Merge_K_Sorted_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
    public static ListNode mergeKLists(List<ListNode> lists) {
    	int len = lists.size();
    	
        if (lists==null||lists.size()==0) return null;
        
    	PriorityQueue<ListNode>  queue = new PriorityQueue<ListNode>(len,new Comparator<ListNode>(){
        public int compare(ListNode o1,ListNode o2){
            if (o1.val<o2.val)
                return -1;
            else if (o1.val==o2.val)
                return 0;
            else 
                return 1;
        }
    });
    	
    	ListNode dummy = new ListNode(0);
    	ListNode previous = dummy;
    	for(ListNode node:lists)
    	{
    	    if(node!=null)
    		    queue.add(node);
    	}
    	
    	while(!queue.isEmpty())
    	{
    		previous.next = queue.poll();
    		previous = previous.next;
    		
    	    if (previous.next!=null) //idk why need to add the next one to da queue
                queue.add(previous.next);
    	}
    	//previous.next=null;
		return dummy.next;  	
    }	
    
	public  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }

}
