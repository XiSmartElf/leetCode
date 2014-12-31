package leetCode;

import java.util.Arrays;

public class _27_Remove_Element {
	public static void main(String[] args) {
		int[] A = new int[]{1,2,3,4,5,5,3,2,1,1,1};
		int elem = 2;
		System.out.println(removeElement(A, elem));
		
	}
    public static int removeElement(int[] A, int elem) {
    	int length = A.length;
    	int i=0;
    	while(i<length)
    	{
    		if( A[i]==elem)
    		{
    			length--;
    			for(int m=i;m<A.length;m++)
    			{
    				if(m+1<A.length)
    					A[m]=A[m+1];
   				}

    		}
    		else
    			i++;
    	}	
    	System.out.println(Arrays.toString(A));
    	return length;
    }
	
}
