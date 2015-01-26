package leetCode.Backtracking;
//use dfs with backtraing. recursively to find the next one, mark the visited and unmark it when it's done
//when every one finds solution, stop search and return one level back up.
import java.util.Arrays;

public class _79_Word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{ 
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word ="ABCESEECFSAD";
		System.out.println(exist(board,word));
	}

    public static boolean exist(char[][] board, String word) {

        if(word.length()==0) return false;
        if(board.length*board[0].length<word.length()) return false;
        
        boolean[][]visited = new boolean[board.length][board[0].length];
        for(int i =0; i<board.length; i++)
            for(int j=0; j<board[0].length;j++)
                   if(findS(board,visited,i,j,word,0)==true) return true;
                   
        return false;
    }
    
    public static boolean findS(char[][] board,boolean[][]visited, int i, int j, String word, int index)
    {
        visited[i][j]=true;
        if(board[i][j]==word.charAt(index))
        {
            index++;
            if(index>word.length()-1)
                return true;
            if(j+1<board[0].length)
                if(visited[i][j+1]==false)
                    if(findS(board,visited, i,j+1,word,index)==true) {visited[i][j]=false; return true;}
            
            if(j-1>=0)
                if(visited[i][j-1]==false)
                    if(findS(board,visited, i,j-1,word,index)==true) {visited[i][j]=false; return true;}

            if(i+1<board.length)
                if(visited[i+1][j]==false)
                    if(findS(board,visited, i+1,j,word,index)==true) {visited[i][j]=false; return true;}

            if(i-1>=0)
                if(visited[i-1][j]==false)
                    if(findS(board,visited, i-1,j,word,index)==true) {visited[i][j]=false; return true;}

        }
        visited[i][j]=false;
        return false;
    }
}

