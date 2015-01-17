package leetCode.DP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//short code but tricky to understand
//two loops one i marks the substring right limit. j marks the left
//i increment from 1 to length(not 0 to length-1 bc substring property)
//j checks all the possible word before right limit.
//notice the can[] is very important// 123leetcode cannot be segmented into leet code since it cannot contain any other words
//can[j] basically indicates this is a legal place to start that current word being checked.
//can[0] is for sure as it is the start point.
//if can[j] is not true meanning either there are unrelavant words before this point or overlap
//to be specific, everytime a word is found, mark i as a vaild new start searching position.typically right after a word found.
//so when j comes to that i, it knows this is ok.
//draw a line and will be easy to understood
//last can[length] ==true meanning all words have been found before it


import java.util.Map;
//140 problem
//add backtracking to return all the possibities.
//this one i didn't pass OJ for aaaaaaaaa......b. since it searchs from left to right. implement the other way would pass OJ.. since it avoids long string.
//idea is use hashmap to record all possible strings before this point in the map(point, list(all possible strings))
//and add the new string to it and store it to the new position/point
//finally return the last one.

import java.util.Set;

public class _139_140_Word_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//139 only find it
    public static boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[] can = new boolean[length+1];
        can[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && dict.contains(s.substring(j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[length];
    }
    
    //*******************
    //140 find the possibilities and return them
    public List<String> wordBreak2(String s, Set<String> dict) {
    	Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();//the maps stores positions with all possible strings before that position.
        int length = s.length();
        validMap.put(0, Arrays.asList("")); //initialize with 0 and empty arraylist . same as can[0]==true. this is the starting point
        

        for (int i = 1; i <= length; i++) {
        	List<String>values = new ArrayList<String>();//store all previous possible strings before position i.
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i))) { //if this is a substring we need to check if it's valid and then connect it to the existant previous string stored in the map
                    for(String word:validMap.get(j)) //if this is not a valid left limit, validmap does not have it's record then(empty list). the loop won't be excuted
                    	values.add(word +( word.isEmpty()?"":" ")+s.substring(j,i));         	
                }
            }
            validMap.put(i, values); //add all previous possible strings before position i to the map.
        }
        
        
        return validMap.get(length);
    }

}
