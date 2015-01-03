package leetCode;
//good tricky problem. 3 sum! 
//ref: 3 sum problem. three pointers
//first one go through the array from begin to end
//the second one start one step ahead of first one, last one starts from the end (EACH ITERATION)
//each time cal sum. if==0 add to the list and make sure k-- j++ to jump out of the loop! so it doesn't keep using it and add to list
//finally two loops to remove anything duplicated in the list. Then return it.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_Three_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(threeSum(new int[]{1,2,3,4,5, -1, -2 ,-3}));
	}
	
    public static List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> possible = new ArrayList<List<Integer>>();
    	int start = 0;
    	int end = 0;
    	Arrays.sort(num);
    	for(int i=0; i<num.length-2;i++)
    	{
    		start=i+1;
    		end = num.length-1;
    		while(start<end)
    		{
    			int sum=num[i]+num[start]+num[end];
    			if(sum == 0)
    			{
    				List<Integer> temp = Arrays.asList(num[i],num[start],num[end]);
    				possible.add(temp);
    				start++;end--;
    			}    			
    			if (sum > 0)
    				end--;
    		    else if(sum<0)
    		    	start++;
    		}
    	}
    	//remove dup
        for (int i = possible.size() - 1; i >= 1; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (possible.get(i).get(0) == possible.get(j).get(0)
                    && possible.get(i).get(1) == possible.get(j).get(1)
                    && possible.get(i).get(2) == possible.get(j).get(2)) {
                	possible.remove(j);
                    i--;
                }
            }
        }
    	return possible;
    }

}
