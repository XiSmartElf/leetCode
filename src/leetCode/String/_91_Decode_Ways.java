package leetCode.String;


//hard to understand their solutions!!! 

public class _91_Decode_Ways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "121289371298749283745983100";
		System.out.println(numDecodings(s));
	}
	
	   public static int numDecodings(String s) {
	        int n = s.length();
	        if (n == 0) return 0;

	        int[] memo = new int[n+1];
	        memo[n]  = 1;
	        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

	        for (int i = n - 2; i >= 0; i--)
	            if (s.charAt(i) == '0') continue;
	            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

	        return memo[0];
	    }
	}
	
	
	
	
	/////old method which exceeds time bc using recursive!!
//    public static int numDecodings(String s) {
//        int singleNO = 0;
//        int doubleNO = 0;
//
//   		if(s.length() == 1)
//   			return 1;
//   		else if(s.length()==0)
//			return 0;
//   		else
//   		{	//when length>=2
//	    	singleNO = numDecodings(s.substring(1));
//	    	
//	    	if(Integer.parseInt(s.substring(0,2)) <= 26 && s.length()>2)
//	    		doubleNO = numDecodings(s.substring(2));
//	    	else if(Integer.parseInt(s.substring(0,2)) <= 26 && s.length()==2)
//	    		doubleNO = 1;
//	    	//System.out.println(Integer.toString(singleNO)+", "+Integer.toString(doubleNO));
//	    	return singleNO+doubleNO;
//   		}
//    }

