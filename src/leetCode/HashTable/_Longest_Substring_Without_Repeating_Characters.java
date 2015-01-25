package leetCode.HashTable;

import java.util.HashMap;
//build a hashmap and record the element and it's index location.
//right pointer keep going right all the time
//left pointer sits there till right finds a dup one that previous exsits in the hashmap
//get that elem location and we move left pointer to that location+1;
//remove all the left elements// record global length best.


public class _Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        if(s.length()==0) return 0;
        if(s.length()==1)
            return 1;
            
        int bestLen = 0;
        int left = 0;
        for(int i=0; i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                int index  =  map.get(s.charAt(i));
                for(int m=left; m<=index; m++)
                    map.remove(s.charAt(m));
                map.put(s.charAt(i),i);  //don't forget to push this dup backin with the new location index
                bestLen = bestLen<(i-left)?(i-left):bestLen;
                left=index+1; 
            }
            else
            {
                map.put(s.charAt(i),i);
                if(i==s.length()-1)
                  bestLen = bestLen<(i-left+1)?(i-left+1):bestLen;
            }
        }
        return bestLen;
    }

}
