package leetCode.Math;
//CharAT-'A' to get distance?!  good idea can verify it later and look into char operation

public class _168_171_ExcelColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.out.println(convertToTitle(270));
	}

	
    public static int titleToNumber(String s) {
        int result = 0;
        for(int i=0;i < s.length();i++)
        {
            result = 26*result + s.charAt(i)-'A'+1;
        }
        return result;
    }
    
    
    public static String convertToTitle(int n) {
    	    String res="";
    	    while(n>0){
    	    	Character m = (char) ('A'+(n-1)%26);
    	        res= m+res;
    	        n=(n-1)/26;
    	    }
    	    return res;
    }
    

}
