package leetCode;


//great example using XOR. two same numbers XOR end up with 0!
//everytime use the first element in the array to XOR the current elem.
//finally what's left in the first element would be the one hasnt been multiplied twice since if it was, then it would be 0.

public class _136_Single_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber(new int[]{1,2,3,4,1,2,3}));
	}

    public static int singleNumber(int[] A) {
    	
    	for(int i=1; i<A.length;i++)
    	{
    		A[0]^=A[i];
    	}
    	
		return A[0];
        
    }
}
