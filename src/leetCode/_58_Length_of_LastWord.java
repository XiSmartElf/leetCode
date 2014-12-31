package leetCode;

public class _58_Length_of_LastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="a ";
		System.out.println(lengthOfLastWord(s));
				
	}

	
    public static int lengthOfLastWord(String s) {
        String newString = new StringBuilder(s.trim()).reverse().toString();
    	String lastWord = newString.split(" ",2)[0];
    	
    	return lastWord.length();
    	
    }
}
