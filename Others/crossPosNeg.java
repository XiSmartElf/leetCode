package Others;
import java.util.Arrays;
public class crossPosNeg
{

	public static void main(String args[]){
	
		int[] A= new int[]{-1,-7,-1,-9,1};
		cross(A);
		System.out.println(Arrays.toString(A));
	}

	public static void cross(int[] A)
	{
		int left = 0;
		int right = A.length-1;
		//partition using quick sort technique
		while(true)
		{
			while(A[left]<0 && left< A.length)
				left++;
			while(A[right]>0 && right>=0)
				right--;
			if(left<right && left<A.length && right>=0)
				swap(A, left, right);
			else
				break;
		}
		int firstPos = 0;
		for(int i=0; i<A.length; i++)
		{
			if(A[i]>0){
				firstPos = i;
				break;
			}
		}
		boolean pos = false;
		for(int i=0; i<A.length; i++)
		{
			if(A[i]<0 && pos==true){
				swap(A, firstPos, i);
				firstPos++;
				if(firstPos>=A.length)
					break;
			}
			pos = !pos;
		}

	}
	public static void swap(int[] A, int a, int b)
	{
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}

