package leetCode.Binary_Search;
//handle edge cases such as only one elem, only one elem in each row.
//idea is same. mid choose left right go mid chose left righ...
//2D can be treated as a sorted array with proper index. so index is the key but easy to mess up
public class _74_Search_a_2D_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchMatrix(new int[][]{{1,2,3},{4,5,6}},4));
	}
	
    public static  boolean searchMatrix(int[][] matrix, int target) {
       //matrix is m x n
    	int m = matrix.length;
        int n = matrix[0].length;
        if(m==1 && n==1)
        {
        	if(matrix[0][0]==target)
        		return true;
        	else
        		return false;
        }
    	int start =  0;
        int end = m*n-1;
        while(start<=end)
        {
        	int mid = (start+end)/2;
	        int start_val = matrix[(start+1)%n==0 && (start+1)/n!=0?(start+1)/n-1:(start+1)/n][(start+1)%n==0?n-1:(start+1)%n-1];
	        int mid_val = matrix[(mid+1)%n==0 && (mid+1)/n!=0?(mid+1)/n-1:(mid+1)/n ][(mid+1)%n==0?n-1:(mid+1)%n-1];
	        int end_val = matrix[(end+1)%n==0 && (end+1)/n!=0?(end+1)/n-1:(end+1)/n][(end+1)%n==0?n-1:(end+1)%n-1];
	        if(start_val==target || mid_val==target || end_val==target ) return true;

	        System.out.println(start+","+end+";"+start_val+":"+((start+1)%n==0 && start>n-1?(start+1)/n-1:(start+1)/n)+","+((start+1)%n==0?n-1:(start+1)%n-1));

	        if(start_val <=target && mid_val >=target)
        		end=mid-1;
        	else
        		start=mid+1;
        }
    	return false;
    }

}
