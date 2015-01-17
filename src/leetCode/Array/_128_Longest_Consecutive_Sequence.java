package leetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _128_Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num= new int[]{1,2,0,1};
		System.out.println(longestConsecutive(num));
	}
	
    public static int longestConsecutive(int[] num) {
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        List<Integer>lengths = new ArrayList<Integer>();  
        int currentLength=1;
        if(num.length==1)
        	return 1;
    	for(int n=1; n<num.length;n++)
    	{
    		if(num[n]==num[n-1]+1)
    		{
    			currentLength++;
    			if(n==num.length-1)
    				lengths.add(currentLength);
    		}
    		else if(num[n]==num[n-1]) //if the same then continue with the current length but without adding
    		{
    		    if(n==num.length-1) //if this is the last element add the length and return 
    				lengths.add(currentLength);
    		}
    		else
    		{
    			lengths.add(currentLength);
    			currentLength = 1;
    		}
    	}
    	System.out.println(lengths);
    	if(lengths==null)
    		return 1;
    	return Collections.max(lengths);
    }

}
