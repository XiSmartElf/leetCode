package leetCode.Stack;
// OJ tell me my answer is wrong?  but it works here in eclipse
import java.util.Stack;

public class _150_Evaluate_Reverse_Polish_Notation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(evalRPN(new String[]{"3","-4","+"}));
	}
	
    public static int evalRPN(String[] tokens) {
        Stack<Integer>values = new Stack<Integer>();
        
        for(int i=0; i<tokens.length;i++)
        {
            if(tokens[i].matches("[-]?+[0-9]+")==true)
            {
                values.push(Integer.parseInt(tokens[i]));
            }
            else
            {
                int B = values.pop();
                int A = values.pop();
                int C = 0;
                if(tokens[i]=="+")
                     C= A + B;
                else if(tokens[i]=="-")
                     C= A - B;
                else if(tokens[i]=="*")
                     C= A * B;
                else if(tokens[i]=="/")
                     C= A / B;
                
                values.push(C);
            }
        }
        int val =values.pop();
        return (int)val;
    }

}
