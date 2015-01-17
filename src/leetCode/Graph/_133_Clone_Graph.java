package leetCode.Graph;
//a easy one using hashtable to store all the clone nodes. to avoid dups. we store there and fetch them using keys (labels)
//create neighors for each node. if not exsit in the hashtable we create new if yes, get it and add it to the neigbors of the cur node.
//keep doing it with a explored set. eveually all nodes will have right neigbors.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class _133_Clone_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if(node==null) return node;	        
	     List<UndirectedGraphNode>explored = new ArrayList<UndirectedGraphNode>();
	     Stack<UndirectedGraphNode> frontier = new Stack<UndirectedGraphNode>();
	     frontier.push(node);
	     HashMap<Integer, UndirectedGraphNode>map =new HashMap<Integer, UndirectedGraphNode>();
	     map.put(node.label, new UndirectedGraphNode(node.label));
	
	     while(!frontier.isEmpty())
	     {
	         UndirectedGraphNode cur_node = frontier.pop();
	         
	         if(!explored.contains(cur_node))
	         {
	             UndirectedGraphNode clone_node = map.get(cur_node.label);
	             List<UndirectedGraphNode>cloneNeighbors = new ArrayList<UndirectedGraphNode>();
	             for(UndirectedGraphNode this_node: cur_node.neighbors)
	             {
	                UndirectedGraphNode neighbor_node = map.containsKey(this_node.label)? map.get(this_node.label):new UndirectedGraphNode(this_node.label);
	                cloneNeighbors.add(neighbor_node);
	                frontier.push(this_node);
	                map.put(neighbor_node.label,neighbor_node);
	             }
	             clone_node.neighbors.addAll(cloneNeighbors);
	         }
	         explored.add(cur_node);
	
	     }
	    return map.get(node.label); 
    }
    
    
    class UndirectedGraphNode {
    	     int label;
    	     List<UndirectedGraphNode> neighbors;
    	     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    	 };

}
