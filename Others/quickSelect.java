package Others;
import java.util.Arrays;

public class quickSelect
{

	public static void main(String[] args)
	{
		int[] C={3,2,1,0,3,2,1,2,2,2,2,5,3,4,7,5,6,4,2,3,4,5,1};
		System.out.println(Arrays.toString(C));
		for(int i=0; i<C.length; i++)
			System.out.print(quickSelect(C, i+1));
		System.out.println();
		Arrays.sort(C);
		System.out.println(Arrays.toString(C));

	}



	public static int quickSelect(int [] arr, int k)
	{
		k = k-1;
		int left=0;
		int right = arr.length-1;
		
		while(left<=right)
		{
			int index =  (left+right)/2;
			int ans = partition(arr, index, left, right);
			if(ans == k)
				return arr[k];
			else if(ans < k)
			{
				left = ans+1;
			}
			else if(ans > k)
			{
				right = ans -1;
			}
		}
		return -1;
	}
	public static void swap(int[]arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] =arr[b];
		arr[b]=temp;
	}

	public static int partition (int[] arr, int index, int left, int right)
	{
		int pivotLoc=-10000;
		int pivot = arr[index];
		for(int i =left; i<=right; i++)
		{
			while(arr[i]>pivot && i<=right)
			{
				swap(arr, i, right);
				right--;
			}

			while(arr[i]<pivot && i>=left)
			{
				swap(arr, i, left);
				left++;
			}
			if(arr[i]==pivot)
				pivotLoc=i;
		}
		return pivotLoc;
	}



}