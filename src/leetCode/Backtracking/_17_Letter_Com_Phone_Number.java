package leetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;
//loop digits, then do combination one by one(one abc by one abc then next abc)since they order by order of number


public class _17_Letter_Com_Phone_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String digits ="";
		System.out.println(letterCombinations(digits));
	}

	
    public static List<String> letterCombinations(String digits) {
    	List<String> comb = new ArrayList<String>();
    	String[] charmap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	List<String> previousComb = new ArrayList<String>();
    	
    	if(digits.length()==0)
    		return new ArrayList(){{add("");}};
    		
    	for(int i=0;i<digits.length();i++)
    	{
    		String nextString = charmap[Character.getNumericValue(digits.charAt(i))];
    		System.out.println(nextString);

    		//for the very first digit then just do this
    		if(previousComb.size()==0)
    		{
    			for(int n=0;n<nextString.length();n++)
    			{
    	    		//System.out.println("y");
    				comb.add(Character.toString(nextString.charAt(n)));
    			}
    		}
    		//for the second and later digits do combination
    		for(int m=0;m<previousComb.size();m++)
    			for(int n=0;n<nextString.length();n++)
    			{
    				String stringToAdd = previousComb.get(m)+nextString.charAt(n);
    				comb.add(stringToAdd);
    			}
    		previousComb.clear();
    		previousComb.addAll(comb);
    		comb.clear();
    	}
    	
    	return previousComb;
    }
}
