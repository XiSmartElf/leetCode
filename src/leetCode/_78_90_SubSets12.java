package leetCode;
//easy ones recursive solve problems
//90 only diff is not allow dup so add a global checker to avoid dups.
//the checker doesnt' avoid dup nodes revisited so it might avoid speed. find a good backtracking to avoid revisiting would be a good idea

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_90_SubSets12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsetsWithDup(new int[]{1,1,1,1,2,2,2,2,2,2,2}));
	}
	//78 easy
    public static List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<Integer> dummySet = new  ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(dummySet);
        res.addAll(findSubSet(S,dummySet));
        return res;
    }
    
    public static List<List<Integer>> findSubSet(int[] S, List<Integer>prevSet)
    {
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        for(int i=0; i<S.length;i++)
        {
            List<Integer>set = new ArrayList<Integer>();
            set.addAll(prevSet);
            set.add(S[i]);
            res.add(set);
            if(i!=S.length-1)
                res.addAll(findSubSet(Arrays.copyOfRange(S,i+1,S.length),set));
        }
        return res;
    }

    
    
    //90 subset with no dup
    
    public static List<List<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        List<Integer> dummySet = new  ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(dummySet);
        ArrayList<Integer> input = new ArrayList<Integer>();
        res.addAll(findSubSet2(S,dummySet));
        return res;
    }
    public static List<List<Integer>> checker = new  ArrayList<List<Integer>>();

    public static List<List<Integer>> findSubSet2(int[] S, List<Integer>prevSet)
    {
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        for(int i=0; i<S.length;i++)
        {
            List<Integer>set = new ArrayList<Integer>();
            set.addAll(prevSet);
            set.add(S[i]);
            if(!checker.contains(set))
            {
                res.add(set);
                checker.add(set);
            }
            if(i!=S.length-1)
                res.addAll(findSubSet2(Arrays.copyOfRange(S,i+1,S.length),set));
        }
        return res;
       
    }
}
