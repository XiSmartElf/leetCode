package leetCode;

import java.util.Stack;

//put character to stack and check the first elem in stack compare with the next elem from the string, if 
//they match like(), then cancel by pop if not then push this elem in. finally if stack empty then cool else meaning there is a
//extra element doesn't have a pair

public class _20_Validate_Parenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "{()[]}";
		System.out.println(isValid(s));
	}
	
    public static boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	Character c;
    	for(int i=0; i<s.length();i++)
    	{	
    		c= s.charAt(i);
    		if(stack.isEmpty())
    			stack.push(c);
    		else
    		{
    			if(isMatched(stack.peek(), c))
    				stack.pop();
    			else
    				stack.push(c);
    		}	
    	}
    	if(stack.isEmpty()) return true;
    	else return false;  	
    }
    
    public static boolean isMatched(Character s, Character c)
    {	
    	if(s=='(' && c ==')') return true;
    	else if(s=='[' && c==']') return true;
    	else if(s=='{' && c=='}') return true;
    	else return false;   	
    }

}
