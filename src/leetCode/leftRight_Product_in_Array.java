package leetCode;

import java.util.Arrays;

public class leftRight_Product_in_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(generateArray(new int[]{1})));
	}
	
	public static int[] generateArray(int[] arr)
	{
	    if(arr.length==0)
	        return new int[0];
	    if(arr.length==1)
	        return new int[]{1};
	    int rightProduct = 1;
	    
	    int[] newArr = new int[arr.length];
	    newArr[0]=1;
	    
	    for(int i=1; i<arr.length; i++)
	    {
	        newArr[i] = newArr[i-1]*arr[i-1];
	    }
	    
	    for(int i = arr.length-1; i>=0; i--)
	    {
	        newArr[i] = newArr[i]*rightProduct;
	        rightProduct*=arr[i];
	    }
	    
	    return newArr;
	}

}
