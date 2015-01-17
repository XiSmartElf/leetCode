package leetCode.DP;
//easy one using DP. good way to solow problem than DFS which doesn't consider overlap
//DP breaks down problem into subproblem and takes/combines previous information
//from each subset in assiting cal the higher level problem

public class _70_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(climbStairs(1));
	}
	
    public static int climbStairs(int n) {
        
        if(n==0)  return 0;
        if(n==1)  return 1;
        
        int[] sum = new int[n+1];
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        
        for(int i=3; i<= n; i++)
        {
            sum[i]=sum[i-1]+sum[i-2];   
        }
        return sum[n];
    }
    
    

}
