package leetCode;

import java.util.Arrays;
//iteratively compare, split by period then continue compare the rest if cannot be sorted out


public class _165_Compare_Version_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String version1 = "1.034.3.2";
		String version2 = "1.034.3.1";
		System.out.println(compareVersion( version1,  version2));
	}
	
    public static int compareVersion(String version1, String version2) {
    	
    	int pointBefore_1;
    	String pointAfter_1;
    	int pointBefore_2;
    	String pointAfter_2;
    	//System.out.println(pointBefore_1+", "+pointAfter_1+", "+pointBefore_2 + " ,"+pointAfter_2);
    	
	    pointBefore_1	= Integer.parseInt(version1.split("\\.")[0].toString());
	   	pointAfter_1	= version1.split("\\.",2).length==1? "0":version1.split("\\.",2)[1].toString();
	   	pointBefore_2	= Integer.parseInt(version2.split("\\.")[0].toString());
        pointAfter_2	= version2.split("\\.",2).length==1? "0":version2.split("\\.",2)[1].toString();
        
       // System.out.println(pointBefore_1+", "+pointAfter_1+", "+pointBefore_2 + " ,"+pointAfter_2);
        
    	if(pointBefore_1>pointBefore_2)
    		return 1;
    	else if(pointBefore_1 == pointBefore_2)
    	{	
    		System.out.println(pointBefore_1+", "+pointAfter_1+", "+pointBefore_2 + " ,"+pointAfter_2);
    		if(pointAfter_1 =="0" && pointAfter_2=="0")
    			return 0;
    	    return compareVersion(pointAfter_1,pointAfter_2);
    	}
    	else
    		return -1;
    	
        //System.out.println(pointBefore);
    }

}
