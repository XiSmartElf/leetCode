package leetCode.String;
import java.util.ArrayList;
import java.util.List;
//freakin long... thats all i can say about this problem... just have to be careful about ALLL TEST CASES...

public class _68_Text_Justification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fullJustify(new String[]{"Here","is","an","example","of","text","justification."},20));
	}
    public static List<String> fullJustify(String[] words, int L) {
        int length = L;
        ArrayList<String> cur_line = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        if(words[0]=="")
        {
            String resNull ="";
            for(int i=0; i<L;i++)
                resNull=resNull+" ";
            res.add(resNull);
            return res;
        }
        for(int i=0; i<words.length; i++)
        {
            //there is room left for current line ex:"this is a bat  "
            if(length-(words[i].length()+1)>0)  
            {
                length=length-(words[i].length()+1); //get remainning available spaces in cur line
                cur_line.add(words[i]); //add the word to the list 
            }
            //just fit in current line   ex:"this is a book" or "this is a bat "
            else if(length-(words[i].length()+1)==-1 ||length-(words[i].length()+1)==0) 
            {
                cur_line.add(words[i]); //add the last word to the list
                //proccess line
                boolean lastLine;
                if(i==words.length-1) lastLine=true;
                else lastLine=false;
                res.add(processLine(cur_line, L, lastLine));
                //start a new line
                length=L; //recover length--next line
                cur_line = new ArrayList<String>();
            }
            //there is no room to fit this one
            else if(length-(words[i].length()+1)<-1)
            {
                //first proccess cur line
                res.add(processLine(cur_line, L, false));
                //start a new line
                length=L; //recover length--next line
                cur_line=new ArrayList<String>();
                //put this one it it
                length=length-(words[i].length()+1);
                cur_line.add(words[i]);
            }
        }
        if(cur_line.size()!=0)
            res.add(processLine(cur_line, L, true));
        return res;
    }
    public static 
    String processLine(ArrayList<String>words, int L, boolean lastLine)
    {
        String lineString="";
        if(words.size()==1)
        {
            String singleWord = words.get(0);
            int len =singleWord.length();
            for(int i=0;i<L-len;i++)
                singleWord = singleWord+" ";
            return singleWord;
        }
        int reminder = L;
        for(String word: words)
            reminder = reminder-word.length();
        if(lastLine==true)
        {
            for(String word:words)
            {
                if(reminder!=0)
                    lineString = lineString+word+" ";
                else
                    lineString = lineString+word;
                reminder--;
            }
            for(int i=0; i<reminder;i++)
                lineString = lineString+" ";
            return lineString;
        }
        //there is extra spaces-->reminder
        int flag = reminder % (words.size()-1);
        int commonSpace = reminder/(words.size()-1);
        int extra = flag>0? 1:0;
        for(int i=0; i<words.size()-1;i++)
        {
            String spaces="";
            for(int count =0; count<(commonSpace+extra);count++)
                 spaces = spaces+" ";
            lineString = lineString +words.get(i)+spaces;
            flag--;
            extra = flag>0? 1:0;
        }
        lineString = lineString +words.get(words.size()-1);
        return lineString;
    }
}
