package leetCode;
//http://web.stanford.edu/class/cs124/lec/med.pdf 
//explain the algorithm very well

//Step 1:
//Set n to be the length of word1; Set m to be the length of word2.
//If n = 0, return m and exit.
//If m = 0, return n and exit.
//Construct a matrix containing 0...n rows and 0...m columns.
//
//Step 2:
//Initialize the first row to 0...n.
//Initialize the first column to 0...m.
//
//Step 3:
//Examine each character of word1 (i from 1 to n).
//
//Step 4:
//Examine each character of word2 (j from 1 to m).
//
//Step 5:
//If word1[i] == word2[j], the cost = 0.
//If word1[i] != word2[j], the cost = 1.
//
//Step 6:
//Set cell A [i, j] of the matrix equal to the minimum of:
//a) The cell immediately above plus 1: A[i - 1, j] + 1.     //down is deletion
//b) The cell immediately to the left plus 1: A[i, j - 1] + 1.  //left is insertion
//c) The cell diagonally above and to the left plus the cost: A[i - 1, j - 1] + cost. //subsitution=del+inser
//
//Step 7:
//After the iteration steps (3, 4, 5, 6) are complete, the distance is found in cell A[n, m].


public class _72_Edit_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("abc","bcf"));
	}
	
    public static int minDistance(String word1, String word2) {
    // Step 1
    int n = word1.length(), m = word2.length();
    if (n == 0)  return m;
    if (m == 0)  return n;
    int[][]A =  new int[n + 1][m + 1];

    // Step 2
    for (int i = 0; i <= n; ++i)  A[i][0] = i;
    for (int j = 0; j <= m; ++j)  A[0][j] = j;

    for (int i = 1; i <= n; ++i) {  // Step 3
        char word1_i = word1.charAt(i-1);
        for (int j = 1; j <= m; ++j) {  // Step 4
            char word2_j = word2.charAt(j-1);
            int cost = (word1_i == word2_j) ? 0 : 1;  // Step 5
            A[i][j] = Math.min(Math.min(A[i-1][j]+1, A[i][j-1]+1), A[i-1][j-1]+cost);// Step 6
        }
    }
    return A[n][m];  // Step 7
}

}
