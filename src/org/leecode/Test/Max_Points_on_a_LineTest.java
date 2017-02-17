package org.leecode.Test;

import java.awt.Point;

import org.junit.Test;
import org.leecode.Max_Points_on_a_Line;

public class Max_Points_on_a_LineTest {
	Max_Points_on_a_Line p = new Max_Points_on_a_Line();
	@Test
	public void testMaxPoints() {
		
		Point[] points = new Point[3];
		points[0] = new Point(0,0);
		points[1] = new Point(94911151,94911150);
		points[2] = new Point(94911152,94911151);
		p.maxPoints(points);
	}

}
