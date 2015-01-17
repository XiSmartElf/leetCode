package leetCode.Data_Structure;

import java.util.HashMap;

public class _146_LRU_Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)
		//set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)
		LRUCache test = new LRUCache(2);
		test.set(2,1);
		test.set(1,1);
		test.set(2,3);
		test.set(4,1);
		System.out.println("_____________________so we just removed 1:" + test.get(1));
		System.out.println("_____________________so we just removed 2:" + test.get(2));
//		test.get(2);
//		test.set(2,6);
//		System.out.println("_____________________so we just removed 2:" + test.get(1));
//		test.set(1,5);
//		test.set(1,2);
//		System.out.println("_____________________so we just removed 1:" + test.get(1));
//		System.out.println("_____________________so we just removed 2:" + test.get(2));
	
//		test.set(7,28);
//		test.set(7,1);
//		test.set(8,15);
//		System.out.println("_____________________so we just removed 6:" + test.get(6));
//		test.set(10,27);
//		test.set(8,10);
//		System.out.println("so we just removed 8:" + test.get(8));
//		test.set(6,29);
//		test.set(1,9);
//		test.get(6);
//		test.set(10,7);
//		test.get(1);
//		test.get(2);
//		test.get(13);
//		test.set(8,30);
//		test.set(1,5);
//		test.get(1);
//		test.set(13,2);
//		test.get(12);
//		test.set(2, 2);

	}
	
	public static class LRUCache {
	    public class DLinkNode
	    {
	        int value;
	        int key;
	        DLinkNode pre;
	        DLinkNode post;
	        public DLinkNode(int x, int y){key=x; value = y;}
	    }
	    private int capacity;
	    private HashMap<Integer, DLinkNode> cache;
	    private DLinkNode tail;
	    private DLinkNode head;

	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.cache = new HashMap<Integer, DLinkNode>((int)(capacity));
	        this.tail = new DLinkNode(-1,0);
	        this.head = new DLinkNode(0,0);
	    }
	    
	    public int get(int key) {
	        if(this.cache.containsKey(key))
	        {
		    	DLinkNode pnode2 = this.head;
		    	System.out.print("before get, the cache is: ");
		    	while(pnode2!=null)
		    	{
		    		System.out.print(pnode2.key+","+pnode2.value+"..");
		    		pnode2=pnode2.post;
		    		
		    	}
		    	System.out.println();
		    	if(cache.size()==1)
		    	{
		    		this.head.post=tail;
		    		this.tail.pre = this.head;
		    	}
		    	else
		    	{
		            DLinkNode node = cache.get(key);
		            System.out.println(node.key+","+node.value);
		            node.pre.post = node.post;
		            node.post.pre = node.pre;
		    	}
	            int val = this.cache.get(key).value;
	            cache.remove(key);
	            
		    	DLinkNode pnode = this.head;	
		    	System.out.print("after get,the cache is: ");
		    	while(pnode!=null)
		    	{
		    		System.out.print(pnode.key+","+pnode.value+"..");
		    		pnode=pnode.post;
		    		
		    	}
		    	System.out.println();
	            return val;
	        }
	        else
	        return -1;
	    }
	    
	    public void set(int key, int value) {
	    	DLinkNode pnode = this.head;
	    	System.out.print("the cache is: ");
	    	while(pnode!=null)
	    	{
	    		System.out.print(pnode.key+","+pnode.value+"..");
	    		pnode=pnode.post;
	    		
	    	}
	    	System.out.println();
	    	
	        DLinkNode node = new DLinkNode(key,value);     
	        add(node);
	    }
	    
	    public void remove()
	    {
	        int key = this.tail.pre.key;
            System.out.println("so we remove: "+key+", "+ cache.get(key).value);
	        this.tail.pre.pre.post = this.tail;
	        this.tail.pre = this.tail.pre.pre;
	        this.cache.remove(key);
	    }
	    
	    public void add(DLinkNode node)
	    {
	        if(cache.containsKey(node.key))
	        {
	        	DLinkNode mapNode =cache.get(node.key);
	            mapNode.value = node.value;	 
	            node=mapNode;
	            System.out.println("containsKey of: "+node.key+", so we replace it with "+node.value);
	            mapNode.pre.post=mapNode.post;
	            mapNode.post.pre = mapNode.pre;
	            this.head.post.pre = mapNode;
	            node.post = this.head.post;
	            this.head.post = mapNode;
	            mapNode.pre=this.head;
	        }
	        else
	        {
		        if(this.cache.size()==this.capacity)
		        {
		            System.out.println("exceed size of "+ this.capacity+", the current num of elems in cahce is "+cache.size());
		            remove();		
		            System.out.println("after remove the last elem, the current num of elems in cahce is "+cache.size());
		        }
		        if(this.cache.size()==0)
		        {
		            this.head.post = node;
		            this.tail.pre = node;
		            node.pre=this.head;
		            node.post= this.tail;
		        }
		        else
		        {
		        	System.out.println("we are adding node of: "+node.key+","+node.value);
		            this.head.post.pre = node;
		            node.post = this.head.post;
		            this.head.post = node;
		            node.pre=this.head;
		        }
	        }
	        cache.put(node.key, node);
	    }
	}

}
