package leetCode.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class _30_Substring_With_Concatenating_All_Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubstring("",new String[]{"foo","bar"}));
	}

    public static List<Integer> findSubstring(String S, String[] L) {
        if(S == null || L == null) return new ArrayList<Integer>();
        if(L.length == 0) return new ArrayList<Integer>();
        int len = L[0].length();
        if(len==0) return new ArrayList<Integer>();

        ArrayList<String> dict = new ArrayList<String>(Arrays.asList(L));
        List<Integer> res = new ArrayList<Integer>();

        for(int i = len-1, j= i -(len-1); i< S.length() ; i++, j++)
        {
            if(dict.contains(S.substring(j,i+1)))
            {
                ArrayList<String> tempDict = new ArrayList<String>(dict);
                for(int m=j, n=i; n<S.length(); m+=len,n+=len)
                {
                    if(tempDict.contains(S.substring(m,n+1)))
                    {
                        tempDict.remove(S.substring(m,n+1));
                        if(tempDict.size() == 0) 
                            res.add(j);
                    }
                    else
                        break;
                }
            }
        }
        return res;
    }
}
