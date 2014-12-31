package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//two stacks one is used for storing all the uncompleted substrings. another is to store corresponding suceesful pair
//each time a substring is poped and add a ( or ) depending on the 2 validation functions. if able to add then add, if not, then 
//the substring popped is gone/discarded. if able to add, push the validation facter back with same value if ( but +1 if ) since
//it completes a bracket

public class _22_Generate_Parentness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(generateParenthesis(3));
	}
	
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        Stack<Integer> validationStack = new Stack<Integer>();
        stack.push("(");
        validationStack.push(0);
        while(stack.size() != 0)
        {
            String s = stack.pop();
            int v = validationStack.pop();
            if(s.length() == n * 2)
            {
                list.add(s);
                continue;
            }
            if(2 * v < s.length())
            {
                stack.push(s + ")");
                validationStack.push(v+1);
            }
            if(s.length() - v < n)
            {
                stack.push(s + "(");
                validationStack.push(v);
            }

        }
        return list;
        
    }

}
