package leetCode.DP;
//takes forver. idea is simple though
// use stack to record the position of ( and ). everytime checks the new mark with the peak value. 
//if match. pop that one and measure the length with i-peak();
//update global best and return.
//note: must insert index of ) as well.


import java.util.Stack;

public class _32_Longest_Valid_Parenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("((())()(()"));
	}

	public static int longestValidParentheses(String s) {
    	Stack<Integer> stack = new Stack<Integer>();

    	int cur_length = 0;
    	int best_length = 0;
    	for(int i=0;i<s.length();i++)
    	{  
    	    if(s.charAt(i) == '(')
    	         stack.push(i);
    	    else
    	    {//if it is')'
    	        if(!stack.isEmpty()&& s.charAt(stack.peek()) == '(')
    	        {
    	            stack.pop();
    	            if(!stack.isEmpty())
        	            cur_length = i - stack.peek();
        	        else
        	            cur_length = i+1;
        	        best_length = Math.max(best_length,cur_length);

    	        }else
	                stack.push(i);
    	            
    	    }
    	}
        return best_length;
    }

}

