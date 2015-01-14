package leetCode.String;

import java.util.ArrayList;
import java.util.List;

//set up 3 for loops to find each point(3) for ip address. one is after one by 1 digit and it 
//makes sure there is at least digits behind to ensure a complete segment
//each time evaluate by check each substring

public class _93_Restore_IP_Address {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "255255255255";
		System.out.println(restoreIpAddresses(s));
	}

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        
        for(int i = 1; i < 4 && i< len-2;i++ )
        	for(int j= i+1; j < 4+i && j< len-1;j++)
        		for(int k=j+1; k <4+j && k< len ;k++)
        		{
        			String String1 = s.substring(0, i);
        			String String2 = s.substring(i, j);
        		    String String3 = s.substring(j, k);
        		    String String4 = s.substring(k, len);
        			
        			if(isValid(String1) && isValid(String2) && isValid(String3) && isValid(String4))
        					res.add(String1+"."+String2+"."+String3+"."+String4);
        		}
        		
       return res;
    }
    
    public static boolean isValid(String s)
    {
    	if(s.length()>3 || Integer.parseInt(s)>255 || (s.charAt(0)=='0' && s.length()>1))
    		return false;
    	else
    	return true;
    }

}
