package leetCode.Tree;
//easy one, do bfs and cache child convert them to val arraylist add them to the result zig zag one and another.
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103_ZigZag_Level_Order_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        
        List<TreeNode> thisRow = new ArrayList<TreeNode>();
        Queue<TreeNode> q=  new LinkedList<TreeNode>();
        boolean zigZag = false;
        q.add(root);
        res.add(new ArrayList<Integer>(){{add(root.val);}});

        while(true)
        {
            if(!q.isEmpty())
            {
                TreeNode temp = q.poll();
                if(temp.left!=null) thisRow.add(temp.left);
                if(temp.right!=null) thisRow.add(temp.right);
            }
            else
            {
                if(thisRow.size() == 0)
                    break;
                q.addAll(thisRow);
                
                List<Integer> thisRowVal = new ArrayList<Integer>();
                for(TreeNode node:thisRow)
                    thisRowVal.add(node.val);
                    
                if(zigZag==true)
                {
                    res.add(thisRowVal); 
                    zigZag = false;
                }
                else
                {
                    Collections.reverse(thisRowVal);
                    res.add(thisRowVal);   
                    zigZag = true;
                }
                thisRow = new ArrayList<TreeNode>();
            }
            
        }
        return res;
    }
    
    public class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    }

}
