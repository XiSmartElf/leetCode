package leetCode.Backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//easy easy.. list is used to dynamically remove items for recursive instead of array.


//47 abit tricky since we need to not consider dups(subtrees that are dups) such that we can prune these nodes and save time
//by doing this. each loop at record visited node with same value to avoid visit the nodes with same value later

public class _46_47_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permuteUnique(new int[]{-1,-1,3,-1}));
	}
	
    public static List<List<Integer>> permuteUnique(int[] S) {
        if(S.length==0) return res;
        helper(new ArrayList<Integer>(), S, new HashSet<Integer>());
        return res;
    }
    
    public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public static void helper(List<Integer>preSet, int[] num, HashSet<Integer>indices)
    {
        for(int i=0; i<num.length; i++)
        {
            if(indices.contains(i))
                continue;
            List<Integer> set = new ArrayList<Integer>(preSet);
            HashSet<Integer> newIndices = new HashSet<Integer>(indices);
            newIndices.add(i);
            set.add(num[i]);
            
            if(set.size()<num.length)
                helper(set, num, newIndices);
            else if(set.size()==num.length)
                res.add(set);
        }
    }

}
