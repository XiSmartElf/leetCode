package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// find the minmin path from top to bottom can be solved by filling up arrays from bottom up
//since it can also go to ajacent meaning index is either same or plus on.
// then we do filling cell in each row by writing in single array a. it is repeatly used to finally get a[0] while is the top value
public class _120_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(1));
		triangle.add(Arrays.asList(2,3));
		triangle.add(Arrays.asList(4,5,6));
		triangle.add(Arrays.asList(7,8,9,10));
		System.out.println(minimumTotal(triangle));		
	}

    public static int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();

        int[] a = new int[rows+1]; //length is the longest row length+1 (+1 incase out of bound for the bottom row)

        for(int i= rows-1; i>=0; i--) //start from the bottom row then up
            for(int j=0; j<i+1; j++)
                a[j] = Math.min(a[j], a[j+1]) + triangle.get(i).get(j);

        return a[0];
    	
    	}
}
