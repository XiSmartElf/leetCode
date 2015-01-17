package leetCode.HashTable;

import java.util.Arrays;
import java.util.HashMap;

// created a hashmap that records all the numbers and it's index in the array from the set.
//each time it cals the diff between the target and the current number and look for the diff in the hashmap
//if there is a match, it means that match val in the map is another number that makes their sum to be the target.
//this way reduces the time.

public class _1_Two_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Arrays.toString(twoSum(new int[]{3,2,4},6)));
	}
	
    public static int[] twoSum(int[] numbers, int target) {
        int index1 = -1; int index2 = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<numbers.length;i++)
        {
        	int diff = target - numbers[i];
        	if(map.containsKey(diff))
        	{
        		index1 = map.get(diff);
        		index2 = i;
        		break;
        	} 
        	map.put(numbers[i],i);
        }
    	
    	return new int[]{index1+1, index2+1};
    }

}
