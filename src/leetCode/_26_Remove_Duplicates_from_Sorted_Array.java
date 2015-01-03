package leetCode;
//easy but fun. in order to do in one pass:
//two pointers: i used to assign value one by one; j go through and inform i and assign or not
//if i=j for value; i stays but j jumps to the next
//if i!=j for value; they both jump to the next position
import java.util.Arrays;

public class _26_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1,1,2,2,2,3,3,4,5,6,9,10,10}));
	}
	
    public static int removeDuplicates(int[] A) {
        if(A.length==0)  return 0;
        if(A.length==1)  return 1;
        int count = A.length;
        int j=0; int i=0;
        for(;j<A.length;j++)
        {
            if(A[i]==A[j])
            	count--;
            else
            {
                A[i+1]=A[j];
                i++;
            }

        }
        System.out.println(Arrays.toString(A));
        return count+1; //plus one because they start from 0 together which counts for one so need to be added back
    }

}
