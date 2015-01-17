package leetCode.Divide_And_Conquer;
//first method is very smart//second don't understand //third is the slowest but is the easist
//

import java.util.Arrays;

public class _169_Marjority_Elem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//method 1: BEST ONE WITH O(N);
    public static int majorityElement(int[] num) {
	    int maj =0;
	    int count = 0;
	    int n = num.length;
	    for (int i = 0; i < n; i++){
	        if (count == 0){
	            maj = num[i];
	            count++;
	        }
	        else if (num[i] == maj){
	            count++;
	            if (count > n/2) return maj;
	        }
	        else count--;
	    }
	    return maj;
	}
    
    
    
//method 2:   bit manupluation   //don't understand!!!!!!!!!!!!!!! what is 1L!!!!!!!
    public static int majorityElement2(int[] num) {
        int ret = 0;

        for (int i = 0; i < 32; i++) {

            int ones = 0, zeros = 0;

            for (int j = 0; j < num.length; j++) {
                if ((num[j] & (1L << i)) != 0) {
                    ++ones;
                }
                else
                    ++zeros;
            }

            if (ones > zeros)
                ret |= (1L << i);
        }

        return ret;
	}
  //method 3: sort and find middle  //time exceeds
    public static int majorityElement3(int[] num) {

    	Arrays.sort(num);
    	return num[num.length/2];
    	
    	
	}
    
}
