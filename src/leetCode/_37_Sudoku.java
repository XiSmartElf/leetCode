package leetCode;
//this one is hard but idea is straightfoward.recursively check each node and determine 
//i don't see backtracking in it though. it's just dfs
//change the valid func may bcome a backtrackin sol. configure it to prune childnodes. but could be challenging

public class _37_Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board = { 
		        { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
		        { '.', '7', '.', '.', '2', '.', '.', '.', '.' },
		        { '.', '.', '.', '.', '.', '.', '.', '5', '.' },
		        { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
		        { '.', '.', '.', '.', '9', '.', '.', '.', '.' },
		        { '.', '.', '.', '.', '.', '.', '.', '4', '.' },
		        { '1', '.', '.', '.', '.', '.', '.', '.', '.' },
		        { '.', '.', '.', '.', '8', '.', '.', '.', '.' },
		        { '.', '3', '.', '.', '.', '.', '6', '.', '.' }
		        };
		solveSudoku(board);
		for(int i=0; i<9; i++)//suduko is 9*9
		{
			for(int j=0; j<9; j++)//suduko is 9*9
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
    public static void solveSudoku(char[][] board) {
    	dfs(board, 0);
	}
	private static boolean dfs(char[][] board, int pos)
	{
	    int n = board.length;
	    if (pos == n*n)
	        return true;	    
	    
	    int x = pos / n;
	    int y = pos % n;
	    if (board[x][y] == '.')
	    {
	        for (char c='1'; c<='9'; ++c)
	        {
	            board[x][y] = c;
	            if (validate(board, x, y))
	            {
	            	if(dfs(board, pos+1)==true)
	            		return true;
	            }            
	            board[x][y] = '.';
	        }
	    }
	    else
	    {
	        if (dfs(board, pos+1))
	            return true;
	    }
	    return false;
	}
	private static boolean validate(char[][] board, int x, int y)
	{
	    char c = board[x][y];
	    for (int i=0; i<9; ++i)
	    {
	        if (y != i && board[x][i] == c)
	            return false;
	        
	        if (x != i && board[i][y] == c)
	            return false;

	    }
	    int xx = x / 3 * 3;
	    int yy = y / 3 * 3;
	    
	    for (int i=xx; i<xx+3; ++i)
	        for (int j=yy; j<yy+3; ++j)
	            if (x != i && y != j && board[i][j] == c)
	                return false;

	    return true;
	}

}
