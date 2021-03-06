package org.leecode;

public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	//From Jiu Zhang
	//思路：始终记录最低价min。每次循环里，都与min比较，并计算profit
	public int maxProfit2(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 0)
            return profit;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            if (prices[i] < min)
                min = prices[i];
            if (prices[i] - min > profit)
                profit = prices[i] - min;
        }
        
        return profit;
    }
}
