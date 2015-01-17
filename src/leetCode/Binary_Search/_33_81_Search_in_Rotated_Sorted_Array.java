package leetCode.Binary_Search;
//very awesome idea using binary search
//take mid and compare mid and start
//if mid>start meanning, in btw is ascending order which is a good segmentation/doesn't contain unsorted order
//check if target is within this range, yes keep doing for this range not then go for the other segmentation(the bad one)
//if mid<start, meanning a bad seg--> contain privot in btw, then use the good seg(the other one: mid to end)
//if target within mid and end, keep searching within this range, else search the bad seg one we just got
//evetually start=mid=end(only one element left) if that's still not what we want, return -1 unfound

//problem 81 is same concept but make diff when start = mid
//since there are dups. if start=mid doesn't mean btwn is a good seg . there could be bigger values in btwn. start=mid are dups 
//we need to loop through btwn see if they are all same. if yes. good seg if not, not good seg then we look at the other seg(good one)


public class _33_81_Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search(new int[]{1,2},2));
		System.out.println(search2(new int[]{1,1,1,3,4,1,1,1,1,1,1,1,1,1,1,1},4));
	}
	//no dups in the sequence probelm 33
    public static int search(int[] A, int target) {
        if(A.length==0)
            return -1;
        
        int start = 0;
        int end = A.length-1;
        
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(A[mid]==target) return mid;
            if(A[start]==target) return start;
            if(A[end]==target) return end;
            if(A[start]<=A[mid])
            {
                if(A[start]<=target && target<=A[mid])
                    end=mid-1;
                else
                    start = mid+1;
            }
            else
            {
                if(A[mid]<=target && target<=A[end])
                    start=mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
    
    //dups allowed in sequence problem 81
    public static boolean search2(int[] A, int target) {
        if(A.length==0)
            return A[0]==target? true:false;
        
        int start = 0;
        int end = A.length-1;
        
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(A[mid]==target) return true;
            if(A[start]==target) return true;
            if(A[end]==target) return true;
            if(A[start]<A[mid])
            {
                if(A[start]<=target && target<=A[mid])
                    end=mid-1;
                else
                    start = mid+1;
            }
            else if(A[start]==A[mid])
            {
            	boolean m=true;
            	for(int i=start+1;i<mid;i++)
            	{
            		if(A[i]!=A[start])
            		{
                        m=false;
                        break;
            		}
            	}
            	if(m==false)
            	{
            		if(A[mid]<=target && target<=A[end])
                        start=mid+1;
                    else
                        end = mid-1;
            	}
            	else
            	{
                    if(A[start]<=target && target<=A[mid])
                        end=mid-1;
                    else
                        start = mid+1;
            	}
            		
            }
            else
            {
                if(A[mid]<=target && target<=A[end])
                    start=mid+1;
                else
                    end = mid-1;
            }
        }
        return false;
    }
	

}
