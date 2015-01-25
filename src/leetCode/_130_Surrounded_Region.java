package leetCode;
//this one isn't like medium. take me few hours
//my method is to search all o using bfs. for each unvisted point do bfs
//when doing bfs, searches all the connected o
//while on the way we may find the edge o(meaning the whole sequence cannot be used and filled), but we still keep going to find all the connected o
//once done that we don't fill them but we make them all visited so they won't be searched again.
//so the max space is m*n
//time is average m*n??

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _130_Surrounded_Region {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{
		        {'X','O','X','O','O','O','O'},
				{'X','O','O','O','O','O','O'},
				{'X','O','O','O','O','X','O'},
				{'O','O','O','O','X','O','X'},
				{'O','X','O','O','O','O','O'},
				{'O','X','O','O','O','O','O'},
				{'O','X','O','O','O','O','O'},
				{'X','O','X','O','O','O','O'},
				{'O','X','O','O','O','O','O'},
		};
		solve(board);
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            	System.out.print(board[i][j]);
            System.out.println();
        }
	}
    public static void solve(char[][] board) {
        Queue<node> q = new LinkedList<node>();
        List<node> res = new ArrayList<node>();
        boolean[][]visited = new boolean[board.length][board[0].length];
        //int count=0;
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
            {
                if(visited[i][j]==false && board[i][j]=='O')
                {
                	//System.out.println(i+", "+j+", "+visited[i][j]);
                    q.add(new node(i,j));
                    visited[i][j]=true;
                    boolean thisResult = true;
                    while(true)
                    {
                    	//System.out.println(++count+", "+q.size());
                        if(q.isEmpty()==true)
                        {
                            for(node pos:res)
                                board[pos.i][pos.j]='X';
                            res.clear();
                            break;
                        }
                        node temp = q.poll();
                        int m = temp.i; 
                        int n = temp.j;
                        if(thisResult==true)
                        	res.add(temp);

                        if(m+1>=board.length || n+1>=board[0].length || m-1<0 || n-1<0)
                        {
                        	res.clear(); 
                        	thisResult = false;
                        }
                        if(n+1<board[0].length)
	                        if(board[m][n+1]=='O' && visited[m][n+1]==false) 
	                        {
	                            visited[m][n+1]=true; //do this here rather than when expand the node bc it may generate dup instered into the Q
	                            q.add(new node(m,n+1));
	                        }
                        
                        if(m+1<board.length)
	                        if(board[m+1][n]=='O' && visited[m+1][n]==false) 
	                        {
	                            visited[m+1][n]=true;
	                            q.add(new node(m+1,n));
	                        }
                        if(m-1>=0)
	                        if(board[m-1][n]=='O' && visited[m-1][n]==false) 
	                        {
	                            visited[m-1][n]=true;
	                            q.add(new node(m-1,n));
	                        }
                        if(n-1>=0)
	                        if(board[m][n-1]=='O' && visited[m][n-1]==false) 
	                        {
	                            visited[m][n-1]=true;
	                            q.add(new node(m,n-1));
	                        }
                        
                    }
                }
            }
        
        
    }
    
    public static class node
    {
        int i;
        int j;
        public node(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }

}
