package leetCode;
//sort algor. use two pointer idea. one keeps track of the 2, one tracks the 0. start from the end and the beginning respectively
//2's pointer -- everytime after swap, 0's pointer++ everytime after swap.
//i stays in the middle all the time and check if it's 2 or 0 if yes swap if no move to the next i which is in between of two pointers

import java.util.Arrays;

public class _75_Sort_Colors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{2,1};
		sortColors(test);
		System.out.println(Arrays.toString(test));
	
	}
	
    public static void sortColors(int[] A) {
    	int n=A.length;
    	int second = n-1;
    	int zero = 0;
    	for(int i=0; i<n;i++)
    	{
    		while(A[i]==2 && i<second)
    		{
    			swap(A, i, second);
    			second--;
    		}
    		while(A[i]==0 && i>zero)
    		{
    			swap(A, i, zero);
    			zero++;
    		}
    	}   	
    }
    
    public static void swap(int[]A, int a, int b)
    {
    	int temp=A[a];
    	A[a]=A[b];
    	A[b]=temp;
    }

}
