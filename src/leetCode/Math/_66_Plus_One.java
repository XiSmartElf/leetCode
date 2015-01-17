package leetCode.Math;

import java.util.Arrays;

public class _66_Plus_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = new int[]{9,9,9,9};
		System.out.println(Arrays.toString(plusOne(digits)));

	}
	
    public static int[] plusOne(int[] digits) {
     
    	if (digits[digits.length-1]+1>9)
    	{
    		for(int m = digits.length-1; m >=0; m--)
    		{
    			if(digits[m]+1>9)
    			{
    				digits[m]=0;
    			}
    			else
    			{
    				digits[m]++;
    				break;
    			}
    		}
    		if(digits[0]==0)
    		{
    			int[] returnDigits = new int[digits.length+1];		
    			returnDigits[0]=1;
    			return returnDigits;
    		}
    		else
    			return digits;
    	}
    	else
    	{
    		digits[digits.length-1] = digits[digits.length-1]+1;
    		return digits;
    	}

    }
}
