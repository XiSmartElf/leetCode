package leetCode.Array;
//idea is compare it's index+1 with it's value and swap them to the right place in one pass
//scan them again to find the unmatched one.
//expalination is inline comments
public class _41_First_Missing_Positive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstMissingPositive(new int[]{2}));
	}
	
    public static int firstMissingPositive(int[] A) {
        int lastPositive = 0;
        for(int i=0; i<A.length; i++)
            //when it's diff from it's index+1 and it's a positive number and its swap target is within the range
            while(A[i]!=i+1 && A[i]>0 && A[i]-1<A.length)
        	{//if they are diff, then swap them otherwise don't keep swaping
	            if(A[i]!=A[A[i]-1]) swap(A, i, A[i]-1);
	           	else break;
            }
        //scan one more time, the first invalid diff from its index+1 is the target
        //if not found, last posititve number+1 is the first one missing
        for(int i=0; i<A.length; i++)
        {
            if(A[i]!=i+1) return i+1;
            else lastPositive = i+1;
        }
        return lastPositive+1;
    }
    public static void swap(int[]A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
