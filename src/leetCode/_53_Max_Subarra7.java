package leetCode;
//O(N)
//go through 
//keep track of the current max
//Divide and conquer

public class _53_Max_Subarra7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxSubArray(int[] A) {
	    int maxSoFar=A[0], maxEndingHere=A[0];
	    for (int i=1;i<A.length;++i){
	        maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
	        maxSoFar=Math.max(maxSoFar, maxEndingHere); 
	    }
	    return maxSoFar;
	}

}
