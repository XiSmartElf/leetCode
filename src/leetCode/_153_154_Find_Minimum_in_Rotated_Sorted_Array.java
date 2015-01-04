package leetCode;
//153:
//this one is easy but tricky
//unlike other binary search to split and look at the left portion first. if it is ascending look at the other one... NO!!
//this case is diff. we HAVE TO look at the right seg first!!!! look at left is find but doesnt work when mid is at the privot 
//consider the following test case. look left would end with 3 as the min.
//we can actually look at left as well: but need to consider when left==right. when this happens, we need to terminate return left as the min
//add this code in the beginning of the while loop si it doesn't "over"loop;


//154:
//this one needs to consider dups. few diff methods all passed OJ but none is a preferred method.


//NOTE:
//This is a famous bug in binary search. if the size of array are too large, equal or larger than the upper bound of int type,
//hi + lo may cause an overflow and become a negative number. It's ok to write (hi + lo) / 2 here, 
//leetcode will not give you a very large array to test.
//But we'd better know this. For a detailed information or history of this bug,
//you could search "binary search bug" on google.
public class _153_154_Find_Minimum_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMin(new int[]{4,5,6,7,1,2,3}));
		System.out.println(findMin2(new int[]{1,1,1,2,3,0,1}));//{1,1,1,1,2,3,1}{2,3,0,1,1,1,1}{2,3,1,1,1,1}
	}
	
	
    public static int findMin(int[] num) {
        int low=0;
        int high = num.length-1;
            
        while (low < high) {
            int mid = (low + high) / 2;//==>BEST TO WRITE LIKE THIS:mid = lo + (hi - lo) / 2 refer to note above. famous bug in binary search
            if (num[mid] <= num[high])
                // the mininum is in the left part
                high = mid;
            else if (num[mid] > num[high])
                // the mininum is in the right part
                low = mid + 1;
        }

        return num[low];
    }
    
    
    public static int findMin2(int[] num) {
        int low=0;
        int high = num.length-1;
            
        while (low < high) {
            int mid = (low + high) / 2;
            if (num[mid] < num[high])
                // the mininum is in the left part
                high = mid;
            else if (num[mid] > num[high])
                // the mininum is in the right part
                low = mid + 1;
            else
            {
            	//when they the same, min can be on either side
            	//the following method is very slow since it go through and check;
//            	boolean m = true;
//            	for(int i=mid+1; i<=high;i++)
//            	{
//            		if(num[i]!=num[i-1])
//            		{
//            			m=false;break;
//            		}
//            	}
//            	if(m==true)
//            		high=mid;		
//            	else
//                    low = mid + 1;
       //*************************     	
            	//the following do by reduce right size by one since we're sure so we just reduce. it's even slower!!!
            	//high--;
          //******************
            	//a good way to handle rather than recursive: but no guratteen to be fast
            	if(num[low]==num[high]) {low++;high--;}
            	else high=mid;
            	
            	
            }
        }

        return num[low];
    }

}
