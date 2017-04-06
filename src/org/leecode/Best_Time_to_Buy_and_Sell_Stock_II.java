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
	//Actually, the straight-forward way of finding next local minimum and next local maximum is not much more complicated, 
	//so, just for the sake of having an alternative I share the code in Java for such case.
	public int maxProfit1(int[] prices) {
		int max = 0, i = 0;
		while(i < prices.length){
			//find next local minimum
			while(i < prices.length - 1 && prices[i + 1] <= prices[i])
				i++;
			int min = prices[i++];
			//find next local maximum
			while(i < prices.length - 1 && prices[i + 1] >= prices[i])
				i++;
			if (i < prices.length)
				max += prices[i++] - min;
			else
				max += 0;
		}
		return max;
	}
}
