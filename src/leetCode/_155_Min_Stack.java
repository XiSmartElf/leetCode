package leetCode;

import java.util.Stack;
//design this stack using ONLY ONE STACK great solution


public class _155_Min_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinStack stack = new MinStack();
		stack.push(1);
		System.out.println(stack.top());
	}
	
	public static class MinStack {
	    long min;
	    Stack<Long> stack;

	    public MinStack(){
	        stack=new Stack<Long>();
	    }

	    public void push(int x) {
	        if (stack.isEmpty()){
	            stack.push(0L);
	            min=x;
	        }else{
	            stack.push(x-min);//Could be negative if min value needs to change
	            if (x<min) min=x;
	        }
	    }

	    public void pop() {
	        if (stack.isEmpty()) return;
	        long pop=stack.pop();
	        if (pop<0)  
	        	min=min-pop;//If negative, increase the min value

	    }

	    public int top() {
	        long top=stack.peek();
	        if (top>0){
	            return (int)(top+min);
	        }else{
	           return (int)(min);
	        }
	    }

	    public int getMin() {
	        return (int)min;
	    }
	}
}	

//old one exceeds time limit bc stack created using two stacks


//	static Stack<Integer> stack = new Stack<Integer>();
//	static Stack<Integer> minStack = new Stack<Integer>();
//	
//    public static void push(int x) {
//        stack.push(x);
//        if(!minStack.empty()){
//        	if(x<=minStack.peek())
//        		minStack.push(x);
//        }
//        else{
//        	minStack.push(x);
//        }
//    }
//
//    public static void pop() {
//    	int x = stack.pop();
//    	if(!minStack.empty())
//        {
//        	if(minStack.peek()==x)
//        		minStack.pop();
//        }
//        
//    }
//
//    public static int top() {
//        return stack.peek();
//    }
//
//    public static int getMin() {
//        return minStack.peek();
//    }

