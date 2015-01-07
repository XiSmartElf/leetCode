package leetCode;
//use dp... but hard to understand
public class _132_Palindrome_Partitioning_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int minCut(String s) {
        int n = s.length();
        int[] cut =  new int[n+1];  // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) 
            cut[i] = i-1;
            
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j)==s.charAt(i+j) ; j++) // odd length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j]);

            for (int j = 1; i-j+1 >= 0 && i+j < n && s.charAt(i-j+1) == s.charAt(i+j); j++) // even length palindrome
                cut[i+j+1] = Math.min(cut[i+j+1],1+cut[i-j+1]);
        }
        return cut[n];
    }

}
