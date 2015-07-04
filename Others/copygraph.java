public class Node 
{
	int val;
	ArrayList<Node> nodes;
	public Node(int val)
	{
		this.val = val;
	}
}


public Node copy(Node root)
{
	if(root == null) return  null;	
	HashMap<Integer, Node> map = new HashMap<Integer, Node>()
	Queue<Node> queue = new LinkedList<Node>();
	Set<Integer> visited = HashSet<Integer>();
	Node start = null;
	queue.push(root);
	while(!queue.isEmpty())
	{
		Node temp = queue.poll();
		if(!visited.contains(temp.val))
		{
			Node newNode = new Node(temp.val);
			ArrayList<Node> newNeigbors = new ArrayList<Node>;
			for(Node neigbor: temp.nodes)
			{
				queue.add(neigbor);
				Node node;
				if(map.contains(neigbor.val))
					node = map.get(neigbor.val);
				else
				{
					node = new Node(neigbor.val);
					map.put(neigbor.val, node);
				}
				newNeigbors.add(node);
			}
			newNode.nodes = newNeigbors;
			visited.add(temp.val);
		}
	}
	return map.get(root.val);
}




public Node coy(Node root)
{
	HashMap<Node, Node> map = new HashMap<Node, Node>()
	Queue<Node> queue = new LinkedList<Node>();

	queue.push(root);
	while(!queue.isEmpty())
	{
		Node temp = queue.poll();
		if(!map.contains(temp))
		{
			node newNode = new Node(temp.val);
			map.put(temp,newNode);
			for(Node neighbor: temp.nodes)
				queue.add(neighbor);
		}
	}
	
	for(Node node:map.keySet())
	{
		ArrayList<Node> newNeigbors = new ArrayList<Node>;

		for(Node neigbor: node.nodes)
			newNeigbors.add(map.get(neigbor));
		
		map.get(node).nodes = newNeigbors;
	}

	return map.get(root);
}