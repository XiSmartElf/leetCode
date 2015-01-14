package leetCode.Backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//easy easy.. list is used to dynamically remove items for recursive instead of array.


//47 abit tricky since we need to not consider dups(subtrees that are dups) such that we can prune these nodes and save time
//by doing this. each loop at record visited node with same value to avoid visit the nodes with same value later

public class _46_47_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permute(new int[]{1,0}));
	}
	
    public static List<List<Integer>> permute(int[] S) {
        //Arrays.sort(S);
        List<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> input = new ArrayList<Integer>();
        for(int i=0; i<S.length;i++)
            input.add(S[i]);
        return findP(input,res);
    }

    public static List<List<Integer>> findP(ArrayList<Integer> S, List<Integer>prevSet)
    {
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        ArrayList<Integer> visited = new ArrayList<Integer>();

        for(int i=0; i<S.size();i++)
        {
            if(!visited.contains(S.get(i)))
            {
                List<Integer>set = new ArrayList<Integer>();
                set.addAll(prevSet);
                set.add(S.get(i));
                if(S.size()==1)
                    res.add(set);
                else
                {	
                	ArrayList<Integer> s = (ArrayList<Integer>) S.clone();
                	s.remove(i);
                    res.addAll(findP(s,set));
                }
                visited.add(S.get(i));
            }
        }
        return res;
    }

}
