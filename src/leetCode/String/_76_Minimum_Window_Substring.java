package leetCode.String;
//dups?!!
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _76_Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC","ABC"));
	}
	
	public static String minWindow(String S, String T) {
		if(T.length()>S.length())  return "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//build the map containing all dictionary chars with specific number of appearances in the dict.
		for(int i = 0; i<T.length(); i++)
		{	
			if(map.containsKey(T.charAt(i)))
				map.put(T.charAt(i), map.get(T.charAt(i))+1);
			else
				map.put(T.charAt(i), 1);
		}
		//totalCount used for finding the first window which contains all dict chars
		int totalCount = 0;
		int left = 0; 
		int right=0;
		String best = "";

		//find the first appearing elem in the string
		for(int i=0; i<S.length(); i++)
		{
		    //if map contains it, then we find the first elem break the loop
			if(map.containsKey(S.charAt(i))){
				left = i;   
				break;
			}
			//if cannot find the first elem, then return unfound the string
			if(i==S.length()-1)
				return "";
		}
		right = left;

		//search the first window containing all the dict chars
		for(int i=right; i<S.length(); i++)
		{
			char cur_char = S.charAt(i);
			if(map.containsKey(cur_char))
			{
			    //subtract one for this char in the map if appear
				map.put(cur_char, map.get(cur_char)-1);
				//if it's greater or equal to 0 meanning it's appreance should be counted and neccessart
				//if it's less than 0, it means it appears more than the number of times it's supposed to
				if(map.get(cur_char)>=0)
					totalCount++; 
				//if total is the dict size then meaning we have found all elems in the window
				//notice the left stays the same place, we only move right pointer
				if(totalCount==T.length())
				{
					right = i;
					break;
				}
			}
		}
		//if total is less than the dict size, meaning nothing can be found return null
		if(totalCount<T.length())
			return "";
		
        //optimize the first window by moving the left pointer
        //it's possible that the left pointer elem has appeared more than what it should
		while(left<right)
		{
			if(map.containsKey(S.charAt(left)))
			{
				if( map.get(S.charAt(left))<0)
				{
					map.put(S.charAt(left),  map.get(S.charAt(left))+1);
					left++;
				}
				else
					break;
			}
			else
				left++;
		}
		//find the first best window after optimizing this window
		best = S.substring(left, right+1);
		right++; //move one step don't forget this. we continue to check the rest of the string
        
		while(right<S.length())
		{
		    //when left and right have same value meaning it can be replaced, we found a window that can be optimzed!
		    ///otherwise we moving forward and increment occurances of dict chars along the way.
			if(S.charAt(left)==S.charAt(right))
			{
				left++;
				//after replacing, we check the rest in the current window see if we can optmize
				while(left<right)
				{
				    //if left is in the dict and apear more than what it's supposed to then we move left one step to right
				    //if it doesn't contain, then it's useless we still move one step 
				    //if it contains but appear equal to what's suposed to, then we cannot move further. check ###
					if(map.containsKey(S.charAt(left)))
					{
						if( map.get(S.charAt(left))<0) //###
						{
							map.put(S.charAt(left),  map.get(S.charAt(left))+1);
							left++;
						}
						else
							break;
					}
					else
						left++;
				}
				//each time after we optimize the current window, we shall update our best window string
				best = best.length()>(right-left+1)? S.substring(left, right+1):best;
			}
			else
			{
				if(map.containsKey(S.charAt(right)))
					map.put(S.charAt(right),  map.get(S.charAt(right))-1);
			}
			right++;
		}

		return best;
	}
	
}
