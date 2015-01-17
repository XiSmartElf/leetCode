package leetCode.Backtracking;
//recursive did it. easy.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _131_Palindrome_Partitioning_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<String>> partition(String s) {
        List<String> res = new  ArrayList<String>();
        return findP(s,res);
    }
    
    public static  List<List<String>> findP ( String s, List<String>prevString)
    {
        List<List<String>> res = new  ArrayList<List<String>>();
        for(int i=1; i<=s.length(); i++)
        {
            List<String>set = new  ArrayList<String>();
            if(isPalindrome(s.substring(0,i)))
            {
                set.addAll(prevString);
                set.add(s.substring(0,i));
                if(i==s.length())
                    res.add(set);
                else
                    res.addAll(findP(s.substring(i),set));
            }
        }
        return res;
    }
    
    public static boolean isPalindrome(String s)
    {
        if(s.length()==1)
            return true;
        for(int i=0; i<s.length()/2;i++)
        {
            if(s.charAt(s.length()-1-i)!=s.charAt(i))
                return false;
        }
        return true;
    }

}
