package leetCode;

import java.util.Arrays;

//took me forever didn't make it work. overthinking of it
//sol is easy./ read the comments
public class _135_Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(candy(new int[]{1,1,1}));
	}
	
	
    public static int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        Arrays.fill(num,1); //fill with all 1 so that each child has one candy at least
        //go from the left to the right and make bigger in right bigger , doesn't consider small and equal case
        for(int i=1; i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
                num[i]=num[i-1]+1;
        }
        //compensate the leftover cases. go from the right to the left
        //make bigger on the left bigger by adding one to the smaller one, compare it with the current val of the bigger one
        //get the max of the two and assign it to the bigger val one.
        for(int i=ratings.length-1; i>=1;i--)
        {
            if(ratings[i-1]>ratings[i])
                num[i-1]=Math.max(num[i]+1,num[i-1]);
        }
        int res = 0;
        for(int i=0; i<num.length ;i++)
            res+=num[i];
            
        return res;
    }

}
