package leetCode.String;
//dups?!!
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _76_Minimum_Window_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("bbaa","aba"));
	}
	
    public static String minWindow(String S, String T) {
        if(S.length()<T.length() || S.length()==0 || T.length()==0) return "";
        if(S.length()==T.length())
        {
            boolean what = true;
            for(int i=0; i<S.length(); i++)
               if(S.charAt(i)!=T.charAt(i))
                    what=false;
            if(what==true)
                return S;
        }

        
        HashMap<Character,Integer>map=new HashMap<Character, Integer>();
        char[] charsTemp = T.toCharArray();
        ArrayList<Character> chars= new ArrayList<Character>();
        for(char toAdd: charsTemp)
        	chars.add(toAdd);
    
        int left=0;
        int right=0;
        String globalBest ="";
        int minLength=S.length();
        //run to the first occurance of one of the char
        for(int i=0; i<S.length();i++)
        {
            if(chars.contains(S.charAt(i)))
            {
                left=right=i;
                right++;
                map.put(S.charAt(i),i);
                break;
            }
        }
        if(map.size()==0) //nothing is found
            return "";
        //begin search the rest 
        boolean found=true;
        for(char target:chars)
            if(!map.keySet().contains(target))
            {
                found = false;  break;
            }
        if(found==true)
            return String.valueOf(S.charAt(left));
            
        for(;right<S.length(); right++)
        {
            if(chars.contains(S.charAt(right)))
            {
                if(S.charAt(right)!=S.charAt(left))
                {
                    map.put(S.charAt(right),right);
                }
                else if(S.charAt(right)==S.charAt(left))
                {
                    map.put(S.charAt(right),right);
                    int min=S.length();
                    for(char key: map.keySet())
                        min = Math.min(map.get(key),min);
                    left=min;
                    if(found==true)
                    {//record new solution
                    	int temp = minLength;
                        minLength = (right-left+1)<minLength? (right-left+1):minLength;
                        globalBest = (right-left+1)<temp? S.substring(left,right+1):globalBest;
                    }
                }
                
                if(found == false)//all found
                {
                    found=true;
                    for(char target:chars)
                        if(!map.keySet().contains(target))
                        {
                            found = false;  break;
                        }
                    if(found==true)
                    {//record frist solution
                        minLength= right-left+1;
                        globalBest = S.substring(left, right+1);
                    }
                }
            	System.out.println(left+", "+right+","+found+", globalBest: "+globalBest+", len:"+minLength);
            }
        }
        return globalBest;
    }

}
