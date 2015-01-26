package leetCode.HashTable;
//key: sort the string first and store the sorted in the hashmap.along with a arraylist which contain all antagrams for this one
//keep updating the hashmap along the way
//finally loop trhough the map and find all lists with more than one string in it(anagram), add them to the res and return
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String,  ArrayList<String>>();
        List<String> res = new ArrayList<String>();
        
        for(int i=0; i<strs.length; i++)
        {
            char[] strC = strs[i].toCharArray();
            Arrays.sort(strC);
            String s = String.valueOf(strC);
            if(map.containsKey(s))
            {
                ArrayList<String> temp = map.get(s);
                temp.add(strs[i]);
                map.put(s,temp);
            }
            else
            {
            	ArrayList<String> temp = new ArrayList<String>();
            	temp.add(strs[i]);
                map.put(s,temp);
            }
            
        }
        
        for(String key: map.keySet())
        {
            if(map.get(key).size()>1)
                res.addAll(map.get(key));
        }
        
        return res;
    }

}
