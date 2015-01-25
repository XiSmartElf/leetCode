package leetCode.Tree;
//diff idea using dfs this time. to get all possible solutions meanning all different tree structures. a list of them
//create new node each time and add collection possibilities of left and right to each new node(a bigger collection)
//then return the new list

import java.util.ArrayList;
import java.util.List;

import leetCode.Sort._148_Sort_List.ListNode;

public class _95_Unique_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(n==0)
        {   
            res.add(null);
            return res;
        }
        res.addAll(bfs(1,n));
        return res;
    }
    public ArrayList<TreeNode> bfs(final int start, int end)
    {
        if(start>end)
            return new ArrayList<TreeNode>(){{add(null);}};
        if(start==end)
            return new ArrayList<TreeNode>(){{add(new TreeNode(start));}};
            
        ArrayList<TreeNode>res= new ArrayList<TreeNode>();

        for(int i=start; i<=end;i++) //it can be anywhere if you select a value
        {
        	//left and right possibilites
            List<TreeNode> leftCase = new ArrayList<TreeNode>();
            List<TreeNode> rightCase = new ArrayList<TreeNode>();
            //add all possible by doing binary dfs
            leftCase.addAll(bfs(start,i-1));
            rightCase.addAll(bfs(i+1,end));
            //for each possibility we combine left and right and add a new node in between, a bigger collection is created
            for(TreeNode left:leftCase)
                for(TreeNode right:rightCase)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);  
                }
        }
        return res;
    }
    
    public class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; left = null; right = null; }
    }
}


