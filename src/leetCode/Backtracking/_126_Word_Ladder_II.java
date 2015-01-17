package leetCode.Backtracking;
//I used A* but I cannot believe I got TLE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class _126_Word_Ladder_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> dict = new HashSet<String>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
		String start ="qa";
		String end = "sq";
		final long startTime = System.currentTimeMillis();

		System.out.println(findLadders(start, end, dict));
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime) );
		
	}

    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	PriorityQueue<node> ShortPath = new PriorityQueue<node>(dict.size()* start.length(), new Comparator<node>(){
            @Override
            public int compare(node o1,node o2){
                if (o1.evaluationVal<o2.evaluationVal)
                    return -1;
                else if (o1.evaluationVal==o2.evaluationVal)
                    return 0;
                else 
                    return 1;
            }
        });
    	dict.add(end);
    	int current_cost=0;
		String currentString=start;
		node currentNode = new node(start, 0,end, new ArrayList<String>());
		List<List<String>> res = new  ArrayList<List<String>>();
		int globalBest = 0;
		boolean firstTime=true;
    	while(true)
    	{			
    		ArrayList<String>childNodes = get_childNodes(currentString,dict);
    		//System.out.println(currentNode.currentPath+Integer.toString(currentNode.evaluationVal)+"");
    		//evaluate each childnodes and put it queue if not in the explored set.
		    if(childNodes.contains(end))
		    {
		        currentNode.currentPath.add(end);
		        if(firstTime)
    			{
    				globalBest = currentNode.cost; 
    				firstTime=false;
    			}
    			if(currentNode.cost>globalBest)
    				break;
    			res.add(currentNode.currentPath);
		    }
			else
			{
			    for(int i=0; i<childNodes.size();i++)
		        {
        			if(!currentNode.currentPath.contains(childNodes.get(i)))
        				ShortPath.add(new node(childNodes.get(i), current_cost+1, end, currentNode.currentPath));
		        }
			}
		    
    		//find the minimum path
    		if(ShortPath.isEmpty())
    			break;
    		currentNode=ShortPath.poll();
    		currentString=currentNode.stringVal;
    		current_cost=currentNode.cost;
    	} 	
    	
    	return res;
    }
    
    
    //getting valid childnodes(one char difference) of the currentnode
    public static ArrayList<String>get_childNodes(String yourString, Set<String> dict)
    {
    	ArrayList<String> childNodes = new ArrayList<String>();
    	for(String ref:dict)
    	{
    		int count = 0;
    		for(int i=0;i<yourString.length();i++)
    			if(yourString.charAt(i)!=ref.charAt(i))
    				count++;
    		if(count<=1)
    			childNodes.add(ref);   		
    	}
    	return childNodes;
    }
    
    //def of a node
    public static class node
    {
    	String stringVal;
    	int evaluationVal;
    	int cost;
    	ArrayList<String> currentPath= new ArrayList<String>();
    	node(String stringVal,int cost, String target, ArrayList<String>currentPath)
    	{
    		this.stringVal=stringVal;
    		this.cost = cost;
    		this.evaluationVal=cost + get_Heuristic(stringVal,target);
    		this.currentPath.addAll(currentPath);
    		this.currentPath.add(stringVal);
    	}
    	
        public  int get_Heuristic(String target, String yourString)
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
