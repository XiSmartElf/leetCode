package leetCode;
// easy but tricky
// shift the input to the right one digit each loop so we only read the right first digit by doing x%10
//use previous result *10+ this = current result
//each time compare it with the bigges max value to check if overflows
//Math.abs is needed to ensure negative value is checked for overflow as well
//COMPARE USING 214748364 INSTEAD OF 2147483647!!!
//BECAUSE IT'S NOT OVER YET AND YOU R STILL IN SHIFT POSITION SO NEED TO 2147483647>>1

public class _7_Reverse_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse(-3));
	}
	
    public static int reverse(int x) {
    	

        int result = 0;
        while( x!= 0)
        {
        	if(Math.abs(result)>214748364)// Integer.MAX_VALUE)
        		return 0;
        	
        	result = result*10+ x%10;
        	x/=10;
        }
        return result;
    }

}
