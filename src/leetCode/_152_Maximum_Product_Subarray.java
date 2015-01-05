package leetCode;
//diff btw this one and Maximun subarray is that this one you go from left you need to think about min value as value
//since a negative value * a negative can become a very big value. so you don't want to miss that.
//keep updating gobalbest and finally return it

public class _152_Maximum_Product_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProduct(new int[]{1,2,-1,-2,3,-4}));
	}
	
    public static int maxProduct(int[] A) {
        if(A.length==0)
            return 0;
        if(A.length==1)
            return A[0];
            
        int globalBest = A[0];
        int max = A[0];
        int min = A[0];
        for(int i=1;i<A.length;i++)
        {
            int temp=max;
            max = Math.max(Math.max(min*A[i],max*A[i]),A[i]);
            min = Math.min(Math.min(min*A[i],temp*A[i]),A[i]);
            
            globalBest = Math.max(max, globalBest);
        }
        
        return globalBest;
    }

}
