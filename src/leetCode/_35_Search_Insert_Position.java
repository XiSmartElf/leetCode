package leetCode;
//easy but tricky
//handle when len=0 or 1;
public class _35_Search_Insert_Position {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[]{1,2,3},4));
	}

    public static int searchInsert(int[] A, int target) {
        if(A.length==0)
            return 0;
        if(A.length==1)
            return A[0]>=target? 0:1;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]>=target) 
                return i;
            if(i == A.length-1) //handle last one case. if all not found and smaller meaning we should insert it in the very end
                return i+1;
        }
        return 0;
    
    }
}
