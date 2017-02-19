package org.leecode;

import java.awt.Point;
import java.util.HashMap;

public class Max_Points_on_a_Line {
	public int maxPoints1(Point[] points) {
        if(points.length <= 1) return points.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; i++){
            //过当前点的直线组成的哈希表，斜率为key
            HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
            int vertical = 0, same = 1, currMax = 0;
            for(int j = i + 1; j < points.length; j++){
                // 统计相同的点
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same++;
                    continue;
                }
                // 统计斜率为无穷的点，他们都在一条直线上
                if(points[i].x == points[j].x){
                    vertical++;
                    continue;
                }
                // 计算连线的斜率
                double slope = ((double)points[i].y - (double)points[j].y) / ((double)points[i].x - (double)points[j].x);
                // 修正负0
                if(slope * slope == 0) slope = 0;
                lines.put(slope, lines.containsKey(slope) ? lines.get(slope) + 1 : 1);
                currMax = Math.max(currMax, lines.get(slope)); 
            }
            // 经过该点的直线上最多的点数，我们在无穷斜率和正常斜率中选较大的，还要加上相同的点数
            currMax = Math.max(vertical, currMax) + same;
            max = Math.max(currMax, max);
        }
        return max;
    }
	//.............
	public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int max = 0;
        for(int i=0;i<points.length-1;i++){
            HashMap<Double, Integer> pointsOnLine = new HashMap<>();
            int samePoint = 0, localMax = 0;
            for(int j=i+1;j<points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x == 0 && y== 0) {
                    samePoint++;
                    continue;
                }
                double ratio = findRatio(x,y);
                if(!pointsOnLine.containsKey(ratio))
                    pointsOnLine.put(ratio, 1);
                else pointsOnLine.put(ratio, pointsOnLine.get(ratio)+1);
                localMax = Math.max(localMax, pointsOnLine.get(ratio));
            }
            max = Math.max(max, localMax + samePoint);
        }
        return max+1;
    }
    private Double findRatio(int x, int y){
        if(y == 0) return Double.MAX_VALUE;
        else return (double)x/(double) y + 0.0;
    }
}