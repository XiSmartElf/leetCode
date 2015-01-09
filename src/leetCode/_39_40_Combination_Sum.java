package leetCode;

//This is not a straightforward alogorithem. but it's very typical backtracking algorithem.
//draw the graph tree you will understand
//the idea is this:
//let's store the current testing sequence in a stack. store the index of each number in the sequence in another stack(index to the source array)
//sort the source array first so it considers the smallest number always first
//in the while loop, keep adding same number till it exceeds the target(this would start from the smallest number first say 1 in the test case)
//when it is about to exceed(if add the number then it exceeds), it takes the last item out before it exceeds
//record the index of this item and then i++ meaning next time iteration in the while loop would add the number after this item (in the source array)
//say we have 1,1,1.. last ithem is 1 and we take it out, next time it would add 2 (in our test case)
//if 2 is going to exceed, then don't add it but take another 1 out and record it's index then i++ meaning add 2
//this time add 2 let's say we just get the right answer, then we report it and continue without the 2 added.
//continue and take the last item out which is 1 i++ so we add 2 next time. this time we might be short so we keep adding 2 till exceeds.
//same concept applies on the entire process till the very end(the last item in the source array)
//when we have the biggest number(last ithem in the array) and exceeds, whenever we take out. We need to take all of it out 
//since there is no more item after the biggest number in the source array this way we don't get stuck in the loop. by going back and forth
//finally we may reach a point where all numbers left in the sequence is the biggest number. That's when we should stop the game
//no more smaller numbers can be taken out and no more solutions.


//40 is a modification of 39. this time only one used.
//everything stays the same but the smaller case needs to be handled properly.
//since we only use once each item, we need to i++ everytime to let it move to the next number in the source
//however, we may see the last number very soon. after adjustment, adding the total is smaller than the target.
//this time i++ would make the loop terminate early-->(1,5) is smaller than 8 but no more number after 5 i++ make it terminate;
//so whenever this happes, we sees 5(the biggest number) and the total is smaller. then we get rid of 5 and move to 1, replace 1 by 1's next value which is 3 in our test case
//finally we have ex: to get 8 now,we have 1135(too big) for now 
//--> 115(too small)-->13(too small)-->135(toll big)-->15(too small)-->3(too small)-->35(good)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class _39_40_Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum(new int[]{1,2,3,3,3,4},7));
		
		System.out.println(combinationSum2(new int[]{3,3,5,1,1,1},8));
	}

	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> combi = new Stack<Integer>(), indices = new Stack<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum=0;
        int i = 0;
        
        while ( i < candidates.length) 
        {
        	//System.out.println(combi);
            if (sum + candidates[i]>= target) 
            {
                if (sum + candidates[i] == target) 
                {
                    combi.push(candidates[i]);
                    result.add(new ArrayList<Integer>(combi));
                    combi.pop();
                }
                if (!indices.empty())
                {
                    sum -= combi.pop();
                    i = indices.pop();
                    while (i == candidates.length-1 && !indices.empty())
                    {
                        i = indices.pop();
                        sum -= combi.pop();
                    }
                }
                i++;
            } 
            else 
            {
                combi.push(candidates[i]);
                sum +=candidates[i];
                indices.push(i);
            }
            
        }
        return result;
    }
    
    //40 this one modifies the 39 a bit. in the second part
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> combi = new Stack<Integer>(), indices = new Stack<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum=0;
        int i = 0;
        
        while ( i < candidates.length) 
        {

            if (sum + candidates[i]>= target) 
            {
                if (sum + candidates[i] == target) 
                {
                    combi.push(candidates[i]);
                    
                    if(!result.contains(new ArrayList<Integer>(combi)))
                    	result.add(new ArrayList<Integer>(combi));
                    combi.pop();
                }
                if (!indices.empty())
                {
                    sum -= combi.pop();
                    i = indices.pop();
                    
                }
                i++;
            } 
            else 
            {
                combi.push(candidates[i]);
                sum +=candidates[i];
                indices.push(i);
                while (i==candidates.length-1 && !indices.empty())
                {
                    sum -= combi.pop();
                    i = indices.pop();     
                }
                i++;
                
            }
          //System.out.println(i);
      	//System.out.println(combi);
        }
        return result;
    }
}
