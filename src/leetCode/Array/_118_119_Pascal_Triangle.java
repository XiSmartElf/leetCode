package leetCode.Array;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.List;



public class _118_119_Pascal_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		int numRows=5;
		Integer[]lastRow={};
		for(int row=0; row < numRows;row++)
		{
			Integer[] values= new Integer[row+1];
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
			res.add(Arrays.asList(values));
			System.out.println(Arrays.toString(lastRow));
		}
	}
}
