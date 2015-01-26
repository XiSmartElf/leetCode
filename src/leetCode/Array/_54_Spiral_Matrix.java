package leetCode.Array;
//easy by using state machine

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0) return res;
        String state = "goRight";
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(true)
        {
            if(right<left || down < up)
               break;
            switch (state)
            {
                case "goRight":
                   for(int col=left; col<=right;col++)
                       res.add(matrix[up][col]);
                   up++;    
                   state = "goDown";
                   break;
                    
                case "goDown":
                   for(int row=up; row<=down; row++)
                       res.add(matrix[row][right]);    
                   right--;    
                   state = "goLeft";
                   break;
                    
                case "goLeft":
                   for(int col=right; col>=left; col--)
                       res.add(matrix[down][col]);  
                   down--;
                   state = "goUp";
                   break;      
                
                case "goUp":
                   for(int row=down; row>=up; row--)
                       res.add(matrix[row][left]);  
                   left++;
                   state = "goRight";
                   break; 
            }
        }
       return res;
   }

}
