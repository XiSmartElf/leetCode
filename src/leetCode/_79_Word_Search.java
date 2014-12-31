package leetCode;

import java.util.Arrays;

public class _79_Word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{ 
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word ="SFCSECBAS";
		System.out.println(exist(board,word));
	}

    public static boolean exist(char[][] board, String word) {
    	boolean[][] visited = new boolean[board.length][board[0].length];
    	boolean found = false;
    	for(int i=0;i<board.length;i++)
    		for(int j=0; j<board[0].length;j++)
    		{
    			if(board[i][j]==word.charAt(0))
    				found=found|search(board,word,1,i,j, visited);
    		}
    	return found;
    }
    
    public static boolean search(char[][] board, String word, int startIndex, int m, int n, boolean[][] visited)
    {
    	//System.out.println(visited[0][0]);
    	boolean found1 = false;
    	boolean found2 = false;
    	boolean found3 = false;
    	boolean found4 = false;
    	if(startIndex<word.length())
    	{
    		if(m-1>=0 )
    		{	
    			if(board[m-1][n]==word.charAt(startIndex) && visited[m-1][n]==false)
    			{
        			boolean[][]visited1=visited.clone();
        			visited1[m][n]=true;
    				found1 = search(board,word,startIndex+1, m-1, n, visited1);
    			}
    		}
    		if(m+1<board.length)
    		{
    			if(board[m+1][n]==word.charAt(startIndex) && visited[m+1][n]==false)
    			{
        			boolean[][]visited1=visited.clone();
        			visited1[m][n]=true;
        			found2 = search(board,word,startIndex+1, m+1, n, visited1);
    			}

    		}
    		if(n-1>=0)
    		{
        		if(board[m][n-1]==word.charAt(startIndex) && visited[m][n-1]==false)
        		{
        			boolean[][]visited1=visited.clone();
        			visited1[m][n]=true;
        			found3 = search(board,word,startIndex+1, m, n-1, visited1);      			
        		}
    		}
    		if(n+1<board[0].length)
    		{
        		if(board[m][n+1]==word.charAt(startIndex) && visited[m][n+1]==false)
        		{
        			boolean[][]visited1=visited.clone();
        			visited1[m][n]=true;
        			found4 = search(board,word,startIndex+1, m, n+1, visited1);  
        		}
 
    		}
    	}
    	else
    		return true;    	
    	return (found1|found2|found3|found4);	
    }
}

