package leetCode;
//use DP instead of greedy. easy one but DP great use.
//each position look ahead see where you can reach the most by using previous info and current max jump info
//previous can go say m. then at i it can go m-1, because at i we have max jump n. we see m and n which is bigger
//pick the bigger one as the farest position we can go then we move to next position do the same thing
//if this val becomes 0, that means we have no more step far we can reach and we can only stay the same location
//that's a failure before reaching the last index


//45 count the min steps. so we dynamcially changing the range we want to search.
//basically when take a step. you either do 1 or 2... A[i]. which one shall you choose?
//it depends on the future max place it can reach. we don't know which we will choose, but we expand the range
//to the max range we can reach by taking on of the 1..A[i]. step++. but we don't know which we take.
//the in the new range (after previousRange, maxPlace). we don't same search for each of them.
//which one shall you step on and go? extend the range again by checking the max place we can reach out of these pos int the range
//evenually we search a space that's bigger than the range but when we at i=A.length-1. we output the current step to reach this range



public class _55_45_Jump_Game_I_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
	}
	
    public static boolean canJump(int[] A) {
        if( A.length== 1)
            return true;
        if(A[0]==0)
            return false;
        int HowManyMoreStepsCanReachFromHere=A[0];
        for(int i=1;i<A.length-1;i++)
        {
            HowManyMoreStepsCanReachFromHere = Math.max(HowManyMoreStepsCanReachFromHere-1, A[i]);
            if(HowManyMoreStepsCanReachFromHere==0) //cannot go foward anymoe// and it's not at the last index
                return false;
        }
        return true;
    }
    
    
    //45
    public static int jump(int[] A) {
        if( A.length== 1)
            return 0;
        if(A[0]==0)
            return -1;
        int steps=1;
        if(A[0]>=A.length-1)
            return steps;
            
        int currentMaxPos = A[0];
        int maxPos = A[0];
        for(int i=1; i<=maxPos; i++)
        {
            currentMaxPos = Math.max(i+A[i],currentMaxPos);
            
            if(i==(A.length-1))
                return steps;
                
            if(i==maxPos)
            {
                maxPos=currentMaxPos;
                steps++;
            }
        }
        return steps;
    }

}
