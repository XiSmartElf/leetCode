package leetCode.Backtracking;
//this avoids lots of subtrees by creating the table so that some childnodes are pruned
//if checking one by one then every single childnode needs to run the scan to determine if it's valid which is a 
//headache for time complexity
import java.util.ArrayList;
import java.util.List;

public class _51_N_Queens {

	public static void main(String[] args) {
		//ok a test case to see if 4*4 results in 2 settings
		int N = 5;
		List<String[]> res =solveNQueens(N);
		for(int j=0;j<res.size();j++){
		for(int i=0;i<res.get(0).length;i++)
		{
			System.out.println(res.get(j)[i]);
		}
		System.out.println();}
		
	}
	//we start define the key method, as we are trying to know how many ways of placements
	//we need an int return type, and we need three input parameters, the board, the current row info
	//and the N (though optional, because it can be computed from board size)
	//board: 0 means unset, positive means set, negative means invalid!
    public static List<String[]> solveNQueens(int n) {

    	List<String[]> _final = new ArrayList<String[]>();;
  	  	if(n==1)
	    {
	        _final.add(new String[]{"Q"});
	        return _final;
	    }
    	GetNQueenSettings(new int[n][n],0,n);   
    	for(int[][]board:res)
    	{
    		String[]_finalBoard = new String[n];
    		for(int i=0;i<_finalBoard.length;i++)
    			_finalBoard[i]="";
    		for(int i=0;i<board.length;i++)
    			for(int j=0;j<board[0].length;j++)
    			{
    				if(board[i][j]>0)
    					_finalBoard[i]+="Q";
    				else
    					_finalBoard[i]+=".";
    			}
    		_final.add(_finalBoard);
    	}
    	return _final;
    
    }
	static ArrayList<int[][]> res = new ArrayList<int[][]>();

	static void GetNQueenSettings(int[][] board, int currentRow, int N) {
		//firstly decide when the recursion stops
		if(currentRow == N) {

			int[][]temp = new int[N][N];
			//have to copy this manually since board will be changed later so adding it would only add ref but not the stable current values
			for(int i=0;i<board.length;i++)
				for(int j=0;j<board[0].length;j++)
					temp[i][j]=board[i][j];
			res.add(temp);
			return;
		}
		//otherwise, we try to set column by column in this row and continue
		for(int i=0; i<N; i++) {
			//firstly make sure it can be set (it is unset at that moment)
			if(board[currentRow][i] == 0) {
				board[currentRow][i] = 1+currentRow;//we use row-related info for settings!
				//now we need set invalid positions for remaining rows
				
				//assume we have such a method accepting an additional column index as parameter
				setInvalid(board, currentRow, N, i);
				
				//oh god, forget the most important recursive calling
				GetNQueenSettings(board, currentRow+1, N);
				
				
				//after that. we need recover everything before trying next one!
				board[currentRow][i] = 0;
				//similarly we assume we have such a method to recover the board as we discussed in slide
				recoverBoard(board, currentRow, N);//column index is not needed for recovery
			}
		}

	}
	
	static void setInvalid(int[][] board, int currentRow, int N, int i) {
		//as we discussed in slides, we need set vertical and diagonal positions!
		for(int row=currentRow+1; row<N; row++) { //start from next line
			//firstly make sure the board can be set
			if(board[row][i] == 0)//vertical position
				board[row][i] = -(1+currentRow);
			//now check diagonal positions
			int rowGap = row - currentRow;
			if(i-rowGap>=0 && board[row][i-rowGap] == 0) {//left bottom diagonal position
				board[row][i-rowGap] = -(1+currentRow);
			}
			if(i+rowGap<N && board[row][i+rowGap] == 0) {//right bottom diagonal position
				board[row][i+rowGap] = -(1+currentRow);
			}
		}
	}
	
	static void recoverBoard(int[][] board, int currentRow, int N) {
		//recover is to check all remaining rows to see if index is higher than currentRow (setters)
		//OR less than -currentRow (invalids)
		for(int row=currentRow+1; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(board[row][col] > currentRow || board[row][col] < -currentRow)
					board[row][col] = 0;
			}
		}
	}
}
