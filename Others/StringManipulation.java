package Others;

public class StringManipulation
{
	public static String reverseWords(String A) 
	{
		StringBuilder sb = new StringBuilder("");
		String curWord = "";
		A= " "+A;
        boolean firstTime = true;
		for(int i=A.length()-1; i>=0; i--)
		{
			if(A.charAt(i)==' ')
			{
				if(curWord!="")
				{
				    if(firstTime==false)
					    sb.insert(0, curWord+" ");
					else{
                        sb.insert(0, curWord);
                        firstTime = false;
					}
				}
				curWord = "";
			}
			else
			{
				curWord = curWord+Character.toString(A.charAt(i));
			}
		}
		return sb.toString();
    }

    public static String reverseSentence(String A) 
	{
		StringBuilder sb = new StringBuilder("");
		String curWord = "";
		A=A.trim();
		A= " "+A;
		for(int i=A.length()-1; i>=0; i--)
		{
			if(A.charAt(i)==' ')
			{
				if(curWord!="")
				{
				    if(i!=0)
					    sb.append(curWord+" ");
					else
                        sb.append(curWord);
				}
				curWord = "";
			}
			else
			{
				curWord = Character.toString(A.charAt(i))+curWord;
			}
		}
		return sb.toString();
    }

    public static int getAvgWordLength (String sentence)
    {
    	int totalLength = 0;
    	int totalWords = 0;
    	int curWordLen = 0;
    	
    	for(int i =0; i<sentence.length(); i++)
    	{
    		if((sentence.charAt(i)<='Z' && sentence.charAt(i)>='A')||(sentence.charAt(i)<='z' && sentence.charAt(i)>='a')) //if is's part of a word
    		{
    			curWordLen++;
    		}
    		else
    		{
    			if(curWordLen!=0) 
    			{
    				totalLength+=curWordLen;
    				totalWords++;
    				curWordLen=0;
    			}
    		}
    	}
    	if(curWordLen!=0)
    	{
    		totalLength+=curWordLen;
    		totalWords++;
    	}
    	return totalLength/totalWords;
    }

	public static void main(String[] args)
	{
		System.out.println(reverseSentence("hello word!"));
		System.out.println(getAvgWordLength("youyou123897894..;d;"));
		System.out.println(reverseWords("I"));
		
	}


}