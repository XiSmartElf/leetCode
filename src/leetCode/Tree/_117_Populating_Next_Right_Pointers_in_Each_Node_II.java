package leetCode.Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//easy using bfs store and process level by level point the last guy to null


public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

	
    public void connect(TreeLinkNode root) {
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        ArrayList<TreeLinkNode> child = new ArrayList<TreeLinkNode>();
        if(root==null) return;
        q.add(root);
        while(true)
        {
            if(!q.isEmpty())
            {
                TreeLinkNode temp = q.poll();
                if(temp.left!=null) child.add(temp.left);
                if(temp.right!=null)child.add(temp.right);
            }
            else
            {
                if(child.size()==0)
                    break;
                for(int i =0; i<child.size(); i++)
                    child.get(i).next = i+1>=child.size()? null:child.get(i+1);
                q.addAll(child);
                child = new ArrayList<TreeLinkNode>();
            }
        }
    
    }
    
    public class TreeLinkNode {
    	     int val;
    	     TreeLinkNode left, right, next;
    	     TreeLinkNode(int x) { val = x; }
    }
}


