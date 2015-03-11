public class Node
{
    int val;
    Node parent;
    Node left;
    Node right;
    public Node(int value)
    {
        this.val = value;
    }
}

public Node findNext(Node node)
{
    if(node == null) return null;
    if(node.right!=null)
    {
        node = node.right;
        while(node.left!=null)
            node = node.left;
        return node;
    }
    else
    {
        while(node.parent!=null)
        {
            if(node.parent.left!=node)
               node = node.parent;
            else
               return node.parent;
            }
        }
        return null; 
    }
}