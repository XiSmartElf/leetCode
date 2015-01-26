package leetCode.Array;
//use constant space. trick is to record column 0 separetly since 0,0 have states for both row and col
//first whenever a elem is 0, make their boarder to be 0. clear them in the end.
public class _73_Set_Matrix_Zeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void setZeroes(int[][] matrix) {
        int col0=1; 
        for(int i =0; i< matrix.length; i++)
        {
             //if this row first colm is zero meanning this col needs to be cleared
            if(matrix[i][0]==0) col0=0; 
            //do this to the entire board. if a elem is 0 record the state to the boarder two cells
            //set them to be zero so we can clear the cells later
            //leave col 0 don't check it, we record them in col0 since 0,0 have dup states for row and col
            for(int j=1; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
        //now we start clearing cells by checking the boarder elems.
        //we don't do this to col0 we do them separetly 
        for(int row = matrix.length-1; row>=0; row--)
        {
            for(int col = matrix[0].length-1; col>=1; col--)
            {
                if(matrix[row][0]==0 || matrix[0][col]==0)
                    matrix[row][col]=0;
            }
            //do this in the end since we done with the row.
            if(col0==0) matrix[row][0]=0;
        }
    }

}
