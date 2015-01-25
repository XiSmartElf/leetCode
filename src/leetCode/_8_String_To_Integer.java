package leetCode;
///unfinished 
public class _8_String_To_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int atoi(String str) {
        str.trim();
        if(str.length()==0) return 0;
        if(str.charAt(0)!='+' && str.charAt(0)!='-' && ((str.charAt(0)-'0')>9 || (str.charAt(0)-'0'<0)))
            return 0;
        int i; 
        boolean positive = true;
        if((str.charAt(0)-'0')<=9 && (str.charAt(0)-'0'>=0)) //if first one is a number
        {
            char c= str.charAt(0);
            if(str.length()==1) return Character.getNumericValue(c);
            i = 0;
        }
        else //it's a sign first one
        {
            if(str.length()>1)
            {
                i=1;
                if(str.charAt(0)!='+') positive = true;
                if(str.charAt(0)!='-') positive = false;
            }
            else return 0;
        }    
            
        int res = 0;
        for(; i<str.length();i++)
        {
            char c = str.charAt(i);
            
            if((c-'0')>9 || (c-'0')<0)
            	return 0;
            else
            {
                if(Math.abs(res)>214748365)
                    return positive==true? 2147483647:-2147483648;
                else
                    res = res *10 + Character.getNumericValue(c) ;
            }
        }
        return positive==true? res:res*-1;
        
    }

}
