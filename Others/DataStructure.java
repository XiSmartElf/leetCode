package Others;
public class DataStructure{
    public class Node{
        int val;
        Node next;
        public Node(int x)
        {
            this.val = x;
        }
    }
    /**
    **    stack using LinkedList
    **/
    
    public class Stack{

    	Node top = new Node(0);

    	public boolean isEmpty()
    	{
    		if(top.next==null)
    			return true;
    		else
    			return false;
    	}

    	public Integer pop()
    	{
    		if(isEmpty()==true)
    			return null;
    		else
    		{
    			int value = top.next.val;
    			top.next = top.next.next;
    			return value;
    		}
    	}
    	public void push(int x)
    	{
    		Node newNode = new Node(x);
    		newNode.next = top.next;
    		top.next = newNode;
    	}
    }

    /**
    **    Queue using LinkedList
    **/
    public class Queue
    {
    	Node head = new Node(0);
    	Node tail = head;


    	public boolean isEmpty()
    	{
    		if(head.next==null)
    			return true;
    		else
    			return false;
    	}

    	public Integer pop()
    	{
 			if(isEmpty()==true)
 				return null;
 			else
 			{
 				int value = head.next.val;
    			head.next = head.next.next;
    			if(head.next == null)
    				tail = head;
    			return value;
 			}
    	}
    	public void push(int x)
    	{
    		tail.next = new Node(x);
    		tail = tail.next;
    	}
    }

    /**
    **    Queue using two stacks
    **/

    public class Queue_TwoStack
    {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        public boolean isEmpty()
        {
            if(stack1.isEmpty())
                return true;
            else 
                return false;
        }

        public Integer pop()
        {
            if(stack1.isEmpty()&&stack2.isEmpty())
                return null;
            else
            {
                if(!stack2.isEmpty())
                    return stack2.pop();
                else
                {
                    while(!stack1.isEmpty())
                        stack2.push(stack1.pop());
                    return stack2.pop();
                }
            }
        }
        public void push(int x)
        {
            stack1.push(x);
        }

    }
    /**
    **    Queue using fixed size array
    **/
    public class QueueArray
    {
        int head = 0;
        int tail = 0;
        Integer[] queueArr;
        public QueueArray(int size)
        {
            queueArr = new Integer[size];
        }

        public boolean isEmpty()
        {
            if(queueArr[head]==null)
                return true;
            else
                return false;
        }

        public Integer pop()
        {
            if(isEmpty())
                return null;
            int value = queueArr[head];
            queueArr[head]=null;
            head++;
            if(head>=queueArr.length)
                head = 0;
            return value;

        }
        public void push(int x)
        {
            if(queueArr[tail]==null)
                queueArr[tail] = x;
            else
                return;
            tail++;
            if(tail>=queueArr.length)
                tail = 0;
        }
    }
    /**
    **    Circular Queue using Linkedlist
    **/
    public class QueueCircular
    {
        public Node tail = null;
        public boolean isEmpty()
        {
            if(tail == null)
                return true;
            else
                return false;
        }

        public Integer pop()
        {
            if(isEmpty())
                return null;
            int value = tail.next.val;
            if(tail.next==tail) //last elem in the queue
                tail = null;
            else
                tail.next = tail.next.next;
            return value;
        }
        public void push(int x)
        {
            if(tail==null){
                tail = new Node(x);
                tail.next = tail;
            }
            else
            {
                Node top = tail.next; 
                tail.next = new Node(x);
                tail = tail.next;
                tail.next = top;
            }
        }
    }

    public static void main(String[] args)
    {
        QueueCircular queue = new DataStructure().new QueueCircular();
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.push(8);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(7);
        System.out.println(queue.pop());
        System.out.println(queue.pop());



    }
}