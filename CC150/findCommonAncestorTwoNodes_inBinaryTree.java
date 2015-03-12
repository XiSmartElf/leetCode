package CC150;

public class findCommonAncestorTwoNodes_inBinaryTree {

    public static class Node
    {
        int val;
        Node left;
        Node right;
        public Node(int value)
        {
            this.val = value;
        }
    }

    public static Node findCommonNode(Node root, Node firstNode, Node secondNode)
    {
        if(root==null || secondNode == null || firstNode == null)
            return null;
         return dfs(root, firstNode, secondNode);   
           
    }

    public static Node dfs(Node node, Node firstNode, Node secondNode)
    {
        if(node ==null)
            return null;
        if(node == firstNode || node == secondNode)
            return node;
        
        Node left = dfs(node.left, firstNode, secondNode);
        Node right = dfs(node.right, firstNode, secondNode);
        
        if(left!=null && right!=null)
            return node;

        return left==null? right:left;
            
    }

    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left=node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;
        System.out.println(findCommonNode(node1, node8, node15).val);       
    }
}