package leetCode;

public class _67_Add_Binary {
// first to make all the same length, then add each from the last digit, make a carry each time. finally check first bit.
	//if it's 0 then add another bit of 1 in front else no.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "00110";
		String b = "011111";
		System.out.println(addBinary(a,b));
	}

    public static String addBinary(String a, String b) {
    	
    	int diff= Math.abs(a.length()-b.length());
    	if(a.length()>b.length())
    		for(int i=0;i<diff;i++)
    			b = "0"+b;
    	if(a.length()<b.length())
    		for(int i=0;i<diff;i++)
    			a = "0"+a;
        char[] m = a.toCharArray();
        char[] n = b.toCharArray();
        int gain = 0;
        String result="";
        
        for(int i=m.length-1; i>=0;i--)
        {	
        	
        	if(Character.getNumericValue(m[i])+Character.getNumericValue(n[i])>1)
        	{
        		System.out.println(result);
        		if(gain==0)
        			result="0"+result;
        		else
        			result="1"+result;
        		gain=1;
        	}
        	else
        	{
        		if(gain==0)
        			result=Integer.toString((Character.getNumericValue(m[i])+Character.getNumericValue(n[i])))+result;
        		else
        		{
        			if(Character.getNumericValue(m[i])+Character.getNumericValue(n[i])+gain>1)
        			{
            			result="0"+result;
            			gain = 1;
        			}
        			else
        			{
            			result=Integer.toString((Character.getNumericValue(m[i])+Character.getNumericValue(n[i])+gain))+result;
            			gain=0;
        			}
        		}
        		
        	}
        	if(i==0 && gain ==1)
        		result="1"+result;
        }
        
    	return result;
    }
}
