package leetCode.LinkedList;
//this question like clone graph using hashtable to store and retrive if exits
//don't forget to connect linkedlist to next node each time!!! this is important and i missed it at the first time

import java.util.HashMap;

public class _138_Copy_List_With_Random_Pointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode res = null;
        boolean first = true;
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode preNode = null;
        while(head!=null)
        {
            RandomListNode node = null;
            if(map.containsKey(head.label))
                node = map.get(head.label);
            else
            {
                node = new RandomListNode(head.label);
                if(first==true){
                    res=node;
                    first=false;
                }
            }
            if(head.random!=null)
            {
                if(map.containsKey(head.random.label))
                    node.random = map.get(head.random.label);
                else
                    node.random = new RandomListNode(head.random.label);
            }
            if(preNode !=null) 
                preNode.next = node; //link them! important         
            preNode = node;
            head = head.next;
        }
        return res;
    }

    
    class RandomListNode {
    	     int label;
    	     RandomListNode next, random;
    	     RandomListNode(int x) { this.label = x; }
     }
}
