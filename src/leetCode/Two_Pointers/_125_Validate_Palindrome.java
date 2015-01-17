package leetCode.Two_Pointers;
//easy one 
//convert to array after clear unneccssary elems
//go from both sides to meet and check if same for each elem
public class _125_Validate_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
    public static boolean isPalindrome(String s) {
    	s = s.toLowerCase();
    	s = s.replaceAll("[^0-9a-zA-Z]", "");
    	
    	char[] c = s.toCharArray();
    	
    	int start = 0; int tail = c.length-1;
    	while(start<=(c.length)/2 && tail>=(c.length)/2)
    	{
    		if(c[start]!=c[tail])
    			return false;
    		tail--; start++;
    	}
    	return true;
    	
    	
    }

}
