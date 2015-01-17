package leetCode.Two_Pointers;
//same as Q26_but this time we need a flag to track if the number has apperaed more than twice.
//if no, excute just like it is not the same. it is more than twice, ignore it just like Q26;


import java.util.Arrays;

public class _80_Remove_Dup_From_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1,1,2,2,2,3,3,3,4,5,6,9,9,9,10,10,10,10,10}));

	}
	
    public static int removeDuplicates(int[] A) {
        if(A.length==0)  return 0;
        if(A.length==1)  return 1;
        int count = A.length;
        int j=1; int i=0;
        int dupNum=0;
        for(;j<A.length;j++)
        {
            if(A[i]==A[j])
            {
            	if(dupNum<2)
            	{
                    A[i+1]=A[j];
                    i++;
                    dupNum=dupNum+2;
            	}
            	else
            		count--;
        	}
            else
            {
            	dupNum=0;
                A[i+1]=A[j];
                i++;
            }

        }
        System.out.println(Arrays.toString(A));
        return count; 
    }
		

}
