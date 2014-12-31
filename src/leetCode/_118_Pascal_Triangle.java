package leetCode;
import java.util.Arrays;


public class _118_Pascal_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRows=5;
		int[]lastRow={};
		for(int row=0; row < numRows;row++)
		{
			int[] values= new int[row+1];
			if(lastRow!=null)
			{
				for(int i=0;i<values.length;i++)
				{
					if(i-1<0 || i+1>lastRow.length)
						values[i]=1;
					else
					{
						values[i]=lastRow[i-1]+lastRow[i];
					}
				}			
			}
			lastRow= values.clone();		
			System.out.println(Arrays.toString(lastRow));
		}
	}
}
