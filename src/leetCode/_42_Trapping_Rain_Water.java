package leetCode;
//easy but don't make mistake please
//two pointers
//one stay on the left till right is higer than left
//right keep going to right.
//whenver right is higher than it's previous value
//it fills the previous valley (to the left where has same height as the right)and count the difference
//when right=left, move left to right position  and keep going.
public class _42_Trapping_Rain_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[]{8,2,8,9,0,1,7,7,9}));
	}
    public static int trap(int[] A) {
        if(A.length <=2)
            return 0;
        
        int left = 0;
        int right = 0;
        int previousRight = 0;
        int count=0;
        boolean firstTime=true;
        while(right<A.length)
        {	//this is to handle the egde, when left=right, right going up and never down, we need to keep make left=right till right starts going down
        	if(firstTime==true)
        	{
                if(A[right]>=previousRight)
                	left=right;
                 else
                    firstTime=false;
        	}
          //if right starts going backup and right left is apart
        	if(A[right]>previousRight && right-left>1)
        	{
        		if(A[right]<A[left])
        		{
        			int i=right-1;
        			while(A[i]<A[right])
        			{
        				count = count+(A[right]-A[i]);
        				A[i]=A[right];
        				i--;
        			}
        		}
        		else
        		{
        			int i=right-1;
        			while(A[i]<A[left])
        			{
        				count = count+(A[left]-A[i]);
        				A[i]=A[left];
        				i--;
        			}
        			left=right;
        			firstTime=true;
        		}
        	}
			System.out.println("totalCount: "+count+" left is:"+left+" right is: "+right+" left_height: "+A[left]+" right_height: "+A[right]);
        	previousRight=A[right];
        	right++;
        }
        return count;
    }

}
