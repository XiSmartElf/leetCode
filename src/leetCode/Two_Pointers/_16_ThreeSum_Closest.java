package leetCode.Two_Pointers;
// 3 sum problem. three pointers
// first one go through the array from begin to end
//the second one start one step ahead of first one, last one starts from the end (EACH ITERATION)
//everytime cal the sum of the three, if the diff btw it and the target smaller than previous diff, replace it with the current one
//if bigger, last --; if smaller, second++;
//if diff==0, break and return. if don't find just wait till the loop is done and turn the clost sum

import java.util.Arrays;

public class _16_ThreeSum_Closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(threeSumClosest(new int[]{0,1,2},  0));
	}

    public static int threeSumClosest(int[] num, int target) {
    	int result = num[0]+num[1]+num[2];
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
    			if(Math.abs(sum - target) < Math.abs( result - target))
    				result = sum;
    			if (sum > target)
    				end--;
    		    else if(sum<target)
    		    	start++;
    		    else
    		    	return result;
    		}
    	}
    	
    	return result;
        
    }
}
