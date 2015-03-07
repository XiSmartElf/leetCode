package leetCode.String;
//tle!!!
public class _5_Longest_Palindrome_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestPalindrome("ccd"));
	}
    public static String longestPalindrome(String s) {
        
        String longest="";
        if(s.length()==1)
            return s;
        for(int i=0; i<s.length()-1; i++)
        {
            String a = palindrome(s, i, i+1);
            String b = palindrome(s, i, i);
            longest = a.length()>=b.length()? a:b;
            System.out.println(a);
            System.out.println(b);

        }
        return longest;
    }
    
    public static String palindrome(String s, int index1, int index2)
    {
        while(true)
        {
            if(index1<0 || index2>s.length()-1 || s.charAt(index1) != s.charAt(index2) )
                return s.substring(index1+1, index2);
            index1--;
            index2++;
        }

    	
    }

}
