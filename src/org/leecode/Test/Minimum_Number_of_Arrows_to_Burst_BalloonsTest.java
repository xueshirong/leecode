package org.leecode.Test;

import org.junit.Test;
import org.leecode.Minimum_Number_of_Arrows_to_Burst_Balloons;

public class Minimum_Number_of_Arrows_to_Burst_BalloonsTest {
	Minimum_Number_of_Arrows_to_Burst_Balloons p = new Minimum_Number_of_Arrows_to_Burst_Balloons();
	@Test
	public void testFindMinArrowShots() {
		int a = 7;
		System.out.println(a%7);
		System.out.println(a%1);
		System.out.println(a%2);
		
		int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
		p.findMinArrowShots(points);
	}

}
