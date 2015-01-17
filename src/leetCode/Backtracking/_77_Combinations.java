package leetCode.Backtracking;
//recursive solution recursive for totoal number of k. return the value. easy but a bit time consuming 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _77_Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4,2));

	}

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> res = new ArrayList<Integer>();
        return recursive(1,n,res,1,k);
              
    }
    
    public static List<List<Integer>> recursive(int range1, int range2, List<Integer> previousNumbers, int layer, int totalLayer)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(int i=range1; i<=range2;i++)
        {
            List<Integer> set = new ArrayList<Integer>();
            int number = i; 
            set.addAll(previousNumbers);
            set.add(i);
            if(layer==totalLayer)
                res.add(set);
            else
                res.addAll(recursive(i+1,range2,set,layer+1, totalLayer));
        }
        
        return res;
            
    }
}
