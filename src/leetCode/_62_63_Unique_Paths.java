package leetCode;

public class _62_63_Unique_Paths {
//simple one using DP. since we do chess board. so make a array with m+1 x n+1 size. +1 for filling 0 for handling out of bound
//problem since indx has a j-1 i-1 in it.
//filling board row by row col by col. 	table[i][j]=table[i-1][j]+table[i][j-1];
//table[1][1] where started must be 1 to start with.

	
//63
//same idea but with obstacle
//in order to handle it:
//just when search through table[i][j]where has a obstacle. put it as 0 so future positions will add 0 to the sum
//same as nothing would come from that way
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3,3));

		System.out.println(uniquePathsWithObstacles(new int[][]{{0},{0}}));
	}
	
	
	//62
    public static int uniquePaths(int m, int n) {
    	int[][] table = new int[m+1][n+1];
    	
    	for(int i =1; i< m+1;i++)
    	{
    		for(int j=1; j<n+1; j++)
    		{
    			if(i==1&&j==1) table[1][1]=1;
    			else
    			table[i][j]=table[i-1][j]+table[i][j-1];
    			System.out.println(i+","+j+":"+table[i][j]);
    		}
    	}
    	
    	return table[m][n];
    }
    
    
    //63 
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m=obstacleGrid.length+1;
    	int n=obstacleGrid[0].length+1;
    	
    	int[][] table = new int[m][n];  
    	
    	for(int i =1; i< m;i++)
    	{
    		for(int j=1; j<n; j++)
    		{
    			//System.out.println(i+","+j+":");
    			if(i==1&&j==1) 
    			{
    				if(obstacleGrid[i-1][j-1]==1)
    					table[1][1]=0;
    				else
    					table[1][1]=1;
    			}
    			else
    			{
    				if(obstacleGrid[i-1][j-1]==1)
    					table[i][j]=0;
    				else
    				{
    	    			table[i][j]=table[i-1][j]+table[i][j-1];
    	    			System.out.println(i+","+j+":"+table[i][j]);
    				}
    			}
    		}
    	}
    	
    	return table[m-1][n-1];
    	
    	
    }
}
