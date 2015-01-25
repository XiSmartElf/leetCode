package leetCode.String;
//simply question but be careful of the " ";

public class _151_Reverse_Words_In_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String reverseWords(String s) {
        s=s.trim();  
        String res="";
        String cur_word="";
        s = " "+s; //this will help you add the last cur word to it.
        
        for(int i =s.length()-1; i>=0; i--)
        {
            if(s.charAt(i)!=' ')
                cur_word =  Character.toString(s.charAt(i)) + cur_word;
            else
            {
                if(cur_word!="")
                {
                    if(res=="")
                        res=res+cur_word;
                    else
                        res= res+" "+cur_word;
                }
                cur_word = "";
            }
        }
        return res;
    }

}
