package leetCode.LinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class A {
	
	public int easyStrings(String a, String b) {
		PriorityQueue<node> ShortPath = new PriorityQueue<node>( a.length()*b.length(), new Comparator<node>(){
	        public int compare(node o1,node o2){
	            if (o1.evaluationVal<o2.evaluationVal)
	                return -1;
	            else if (o1.evaluationVal==o2.evaluationVal)
	                return 0;
	            else 
	                return 1;
	        }
	    });
		
    	int current_cost=0;
		String currentString=a;
		String end = b;
		node currentNode = new node(a, 0,end, new HashSet<String>());
		currentNode.currentPath.add(currentString);
		
    	while(currentString!=end)
    	{			
    		ArrayList<String>childNodes = get_childNodes(currentString);
    		//System.out.println(currentNode.currentPath+Integer.toString(currentNode.evaluationVal)+"");

    		//evaluate each childnodes and put it queue if not in the explored set.
    		for(int i=0; i<childNodes.size();i++)
    		{
    			//a cost of a step is the cost of getting to the childnode plus the heuristic of that childnode
    			if(childNodes.get(i).equals(end))
    			{
    				currentNode.currentPath.add(childNodes.get(i));
    				System.out.println(currentNode.currentPath);
        			return  (currentNode.cost+2)/2; 
    			}
    			else
    			{
        			if(!currentNode.currentPath.contains(childNodes.get(i)))
        				ShortPath.add(new node(childNodes.get(i), current_cost+2, end, currentNode.currentPath));
    			}
    		}
    		//find the minimum path
    		if(ShortPath.isEmpty())
    			break;
    		currentNode=ShortPath.poll();
    		currentString=currentNode.stringVal;
    		current_cost=currentNode.cost;
    	} 
		
		return 0;


    }


	//getting valid childnodes(one char difference) of the currentnode
	public static ArrayList<String> get_childNodes(String s)
	{
		char[] charS = s.toCharArray();
		ArrayList<String> cases = new ArrayList<String>();
		if(s.length() < 1){
			return cases;
		}

		for(int i = 0; i < charS.length - 1; i ++){
			char temp = charS[i];
			charS[i] = charS[i + 1];
			charS[i + 1] = temp;
			cases.add(new String(charS));
			temp = charS[i];
			charS[i] = charS[i + 1];
			charS[i + 1] = temp;
		}
		char temp = charS[charS.length - 1];
		charS[charS.length - 1] = charS[0];
		charS[0] = temp;
		cases.add(new String(charS));
		return cases;
	}
	
	//def of a node
	public static class node
	{
		String stringVal;
		int evaluationVal;
		int cost;
		Set<String> currentPath= new HashSet<String>();
		
		node(String stringVal,int cost, String target, Set<String>currentPath)
		{
			this.stringVal=stringVal;
			this.cost = cost;
			this.evaluationVal=cost + get_Heuristic(stringVal,target);
			this.currentPath.addAll(currentPath);
			this.currentPath.add(stringVal);
		}
		
	    public static int get_Heuristic(String target, String yourString)
	    {
	    	int count = 0;
	    	for(int i =0; i<target.length();i++)
	    	{
	    		if(target.charAt(i)!=yourString.charAt(i))
	    			count++;
	    	}
	    	return count;
	    }	
	}
}