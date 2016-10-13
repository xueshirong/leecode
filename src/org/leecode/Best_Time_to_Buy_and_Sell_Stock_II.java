package org.leecode;

public class Best_Time_to_Buy_and_Sell_Stock_II {
	public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i <  prices.length; i++){
            if(prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
	//From Jiu Zhang
	public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++){
            int dif = prices[i+1] -  prices[i];  
            if (dif > 0)
                max += dif;
        }
        return max;
    }
}
