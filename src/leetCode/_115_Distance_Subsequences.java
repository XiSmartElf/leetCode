package leetCode;
//.....similar to edit distance

public class _115_Distance_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("abbc","abc"));
	}

	public static int numDistinct(String S, String T) {
	    int m = T.length();
	    int n = S.length();
	    if (m > n) return 0;    // impossible for subsequence
	    int[][] path =  new int[m+1][n+1];
	    for (int k = 0; k <= n; k++) path[0][k] = 1;    // initialization

	    for (int j = 1; j <= n; j++) {
	        for (int i = 1; i <= m; i++) {
	            path[i][j] = path[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? path[i-1][j-1] : 0);
	        }
	    }
	    //for(int i=0;i<path.length;i++)
	    	//for(int j=0;i<path[0].length;j++)
	    		//sSystem.out.println(path[i][j]);
	    return path[m][n];
	}
}
