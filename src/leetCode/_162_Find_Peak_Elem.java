package leetCode;
//easy use binary search to search the peak.
//left cannot be equal to right otherwise it going to loop forever
//for target problem we can make them equal but for condition problem like this finding peak. don't make them the same.
public class _162_Find_Peak_Elem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPeakElement(new int[]{1,3,2}));
	}
	
    public static int findPeakElement(int[] num) {
    	int left = 0;
    	int right = num.length;
    	if(num.length==1) return 0;
    	
    	while(left<right)
    	{
    		int mid = (left+right)/2;
    		if(num[mid]>num[mid-1] )
    			left = mid;
    		else
    			right = mid-1;
    	}
    	return left;
    }

}
