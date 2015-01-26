package leetCode.Array;

//swap up and down first, and swap them diagonally

public class _48_Roate_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]matrix = new int[][]{{1}};
		rotate(matrix);		
	}
	
    public static void rotate(int[][] matrix) {

        int up = 0;
        int down = matrix.length-1;
        //reverse rows
        while(true)
        {
            if(up>=down) break;
            for(int i=0; i<matrix[0].length; i++)
                swap(matrix, up, i ,down, i);
            up++;down--;
        }
        //swap diagonally
        for(int i=0; i<matrix.length; i++)
            for(int j=i; j<matrix[0].length; j++)
                swap(matrix, i,j,j,i);
        
    }
    
    public static void swap(int[][]matrix, int i, int j, int m, int n)
    {
        int temp = matrix[i][j];
        matrix[i][j]=matrix[m][n];
        matrix[m][n]=temp;
    }

}
