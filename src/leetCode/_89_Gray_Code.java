package leetCode;

//idea is this:
//we shift 1 to left one more time loop by loop
//each time we get every values from the arraylist and add the shiffted 1 to them. say we have shifted 1 by 2 times 100=4
//then we get first value(start from the end! the order is important for OJ evalution) say 11=3, then we have 7 which is 111
//then we do next 10=2 then we have 6 which is 110. put them back to the array.

import java.util.ArrayList;

public class _89_Gray_Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public ArrayList<Integer> grayCode(int n) {
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    arr.add(0);
	    for(int i=0;i<n;i++){
	        int inc = 1<<i;
	        for(int j=arr.size()-1;j>=0;j--){
	            arr.add(arr.get(j)+inc);
	        }
	    }
	    return arr;
	}
}
