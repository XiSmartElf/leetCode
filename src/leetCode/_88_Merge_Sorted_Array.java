package leetCode;
//easy one but tricky
//go from the end of A first where is m+n-1
//start filling big values
//each time make comparsion btw A and B and fill in the bigger one and  whichever one is big then moves to former position 
//whenever one has been go through entirely: i<0 or j<0. fill the rest with the other array.
public class _88_Merge_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		merge(new int[]{},1, new int[]{1}, 2);
	}

    public static void merge(int A[], int m, int B[], int n) {
        if(A.length==0 || B.length==0) return;
        int i = m-1;
        int j = n-1;
        //backwards putting values
        for(int k = m+n-1; k>=0; k--)
        {
            if(i<0) //meanning A has been go through entirely, only B left
                A[k]=B[j--];
            else if(j<0)
                A[k]=A[i--];
            else if(A[i]<B[j])
                A[k]=B[j--];
            else
                A[k]=A[i--];
        }
    }
}
