package leetCode.String;

public class _38_Count_and_Say {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countAndSay(5));
	}
	
    public static String countAndSay(int n) {
        if(n-1==0) return "1";
        String prevS = "11"; //start from after one;
        String res ="";
        char cur_val = 1;
        int cur_count = 1;
        
        for(int start=1; start<n-1;start++)
        {
            cur_val = prevS.charAt(0);
            cur_count = 1;

            for(int i=1; i<prevS.length();i++)
            {
                if(prevS.charAt(i)==prevS.charAt(i-1)) 
                {
                    cur_count=cur_count+1; //cur_val appears one more time.
                    if(i==prevS.length()-1)
                        res = res+Integer.toString(cur_count)+Integer.toString(cur_val-'0');
                }
                else
                {
                    res = res+Integer.toString(cur_count)+Integer.toString(cur_val-'0');
                    cur_count=1; //start count from 1 for the new val
                    cur_val = prevS.charAt(i); //assign it to new val
                    if(i==prevS.length()-1)
                        res = res+Integer.toString(cur_count)+Integer.toString(cur_val-'0');
                }
            }
            prevS = res;res="";
        }
        return prevS;
    }

}
