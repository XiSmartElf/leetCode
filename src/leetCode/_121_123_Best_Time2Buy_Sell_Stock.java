package leetCode;
//easy q but need to think carefully! sell stock cann't before buying stock! dates!
////consider go from sell to buy
//idea is to find highest  value for sell set it as high and continue search to the left look for the less value day.


//123
//ie, you must sell the stock before you buy again).
//so do one from the left and do another one from the right. keep recording the higest total val
//such way they don't overlap and the current point alway separte them from left and right, and the current point 
//has the total value. compare total values and find the max and return

public class _121_123_Best_Time2Buy_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new int[]{18,19,20,7,8,5,1,2,8}));
	}
	//121 one transaction only
    public static int maxProfit(int[] prices) {
        int profit = 0, highest_price = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            highest_price = Math.max(highest_price, prices[i]);
            profit = Math.max(profit, highest_price - prices[i]);
        }
        return profit;
    }
    
    //123 two trasactions
    public static int maxProfit1(int[] prices) {
        if(prices.length < 2)
            return 0;
        int len = prices.length;
        int[] profits = new int[len];
        int min = prices[0];
        for(int i=1; i<len; i++){
            int profit = prices[i] - min;
            profits[i] = Math.max(profits[i-1], profit);
            min = Math.min(min, prices[i]);
        }

        int maxProfit = profits[len-1];
        profits[len-1] = 0;
        int max = prices[len-1];
        for(int i=len-2; i>=0; i--){
            int profit = max - prices[i];
            profit = Math.max(profits[i+1], profit);
            max = Math.max(max, prices[i]);
            int totalProfit = profit + profits[i];
            if(totalProfit > maxProfit)
                maxProfit = totalProfit;
            profits[i] = profit;

        }

        return maxProfit;
    }


}
