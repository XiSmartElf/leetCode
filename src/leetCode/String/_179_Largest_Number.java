package leetCode.String;
//define a comparator to check the s1+s2 or s2+s1 which has bigger value
//use this for array sort
//then put the value as a string
//if first one is 0 the whole seq is then 0 meanning val is 0
import java.util.Arrays;
import java.util.Comparator;

public class _179_Largest_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2){
            String s1s2 = s1+s2;
            String s2s1 = s2+s1;
            if(s1s2.compareTo(s2s1)>0) return -1;
            else if(s1s2.compareTo(s2s1)<0) return 1;
            else  return 0;
        }
    }
    
    public String largestNumber(int[] num){
        String[] nums = new String[num.length];
        for(int i =0 ;i<num.length;i++){
            nums[i]=String.valueOf(num[i]);
        }
        Comparator<String> comparator = new StringComparator();
        Arrays.sort(nums,comparator);
    
        StringBuilder str = new StringBuilder();
        for(String n:nums){
            str.append(n);
        }
        return str.charAt(0)=='0'?"0":str.toString();
    }

}
