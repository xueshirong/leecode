package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Best_Time_to_Buy_and_Sell_Stock;

public class Best_Time_to_Buy_and_Sell_StockTest {
	Best_Time_to_Buy_and_Sell_Stock bt = new Best_Time_to_Buy_and_Sell_Stock();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaxProfit() {
		int[] prices = new int[]{0, 6, -3, 7};
		bt.maxProfit(prices);
	}

}
