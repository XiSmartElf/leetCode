package leetCode;

import java.util.Arrays;
// recursive search with O(logN). split hard and find the medium, then narrow down the search range do it again
//need to do this again next time
public class _34_Search_For_A_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]A= new int[]{1,2,3,3,3,3,3,3,3,3,10};
		int target = 3;
		System.out.println(Arrays.toString(searchRange(A,target)));
	}
	public static int[] searchRange(int[] A, int l, int r, int target) {
	    int[] result = new int[] { -1, -1 };

	    while (l <= r) {
	        int mid = (l + r) / 2;

	        if (A[mid] < target) {
	            l = mid + 1;
	        } else if (A[mid] > target) {
	            r = mid - 1;
	        } else {
	            int[] left = searchRange(A, l, mid - 1, target);
	            result[0] = left[0] == -1 ? mid : left[0];

	            int[] right = searchRange(A, mid + 1, r, target);
	            result[1] = right[1] == -1 ? mid : right[1];

	            break;
	        }
	    }

	    return result;
	}

	public static int[] searchRange(int[] A, int target) {
	    return searchRange(A, 0, A.length - 1, target);
	}


}
