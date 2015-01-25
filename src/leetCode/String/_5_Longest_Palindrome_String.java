package leetCode.String;
//tle!!!
public class _5_Longest_Palindrome_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(longestPalindrome("jhgtrclvzumufurdemsogfkpzcwgyepdwucnxrsubrxadnenhvjyglxnhowncsubvdtftccomjufwhjupcuuvelblcdnuchuppqpcujernplvmombpdttfjowcujvxknzbwmdedjydxvwykbbamfnsyzcozlixdgoliddoejurusnrcdbqkfdxsoxxzlhgyiprujvvwgqlzredkwahexewlnvqcwfyahjpeiucnhsdhnxtgizgpqphunlgikogmsffexaeftzhblpdxrxgsmeascmqngmwbotycbjmwrngemxpfakrwcdndanouyhnnrygvntrhcuxgvpgjafijlrewfhqrguwhdepwlxvrakyqgstoyruyzohlvvdhvqmzdsnbtlwctetwyrhhktkhhobsojiyuydknvtxmjewvssegrtmshxuvzcbrabntjqulxkjazrsgbpqnrsxqflvbvzywzetrmoydodrrhnhdzlajzvnkrcylkfmsdode"));
	}
    public static String longestPalindrome(String s) {
        String globalBest="";
        int bestLength = 0;
        int best_i=0;
        int best_j=0;
        int length = s.length();
        
        for(int i=0; i<length - bestLength;i++)
        {
            for(int j = length-1; j>=i+bestLength;j--)
            {
        		//System.out.println(bestLength+", "+i+", "+j);

                if(isPalindrome(s,i,j))
                {	
                    if((j+1-i)>bestLength)
                    {
                        best_i = i;
                        best_j = j;
                        bestLength = j+1-i;
                    }
                    break;
                }
            }
        }
        globalBest = s.substring(best_i,best_j+1);
        return globalBest;
    }
    
        public static boolean isPalindrome(String s, int start, int tail) {
        
    	while(start<tail)
    	{
    		if(s.charAt(start)!=s.charAt(tail))
    			return false;
    		tail--; start++;
    	}
    	return true;
    	
    	
    }

}
