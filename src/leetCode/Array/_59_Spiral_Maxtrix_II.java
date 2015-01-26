package leetCode.Array;
//easy as 54 using state machine
public class _59_Spiral_Maxtrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==0) return matrix;
        
        String state = "goRight";
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        int number = 1;
        while(true)
        {
            if(right<left || down < up)
               break;
            switch ( state)
            {
                case "goRight":
                   for(int col=left; col<=right;col++)
                   {
                       matrix[up][col] = number;
                       number++;
                   }
                   up++;    
                   state = "goDown";
                   break;
                    
                case "goDown":
                   for(int row=up; row<=down; row++)
                   {
                       matrix[row][right]=number; 
                       number++;
                   }                    
                   right--;    
                   state = "goLeft";
                   break;
                    
                case "goLeft":
                   for(int col=right; col>=left; col--)
                   {
                       matrix[down][col]=number;  
                       number++;
                   }                       
                   down--;
                   state = "goUp";
                   break;      
                
                case "goUp":
                   for(int row=down; row>=up; row--)
                   {
                       matrix[row][left]=number;  
                       number++;
                   }
                   left++;
                   state = "goRight";
                   break; 
            }
        }
       return matrix;
   }

}
