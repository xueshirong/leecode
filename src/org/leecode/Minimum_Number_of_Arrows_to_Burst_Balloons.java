package org.leecode;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
	//排序后，比如第1个气球能向右延伸到第2个气球；那么下一个循环从第3个气球开始。
    //思路：首先自己定义一个比较函数，将输入的pair数组先按照pair的first升序排列，若pair的first相等，则按照pair的second升序排列；
    //首先将排列后的数组的第一个元素的second保存在right，遍历排序后的数组，若数组元素的first小于等于right，
    //则表示该元素的某些范围在right之内，可以被一枪射中，此时将right更新为该元素的second和right中较小的一个；
    //若数组元素的first大于right，则该气球不能与前面的气球一起射中，此时更新right为当前元素的second，并使射击次数result加1。
    public int findMinArrowShots(int[][] points) {
        //corner case
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        int res = 1;
        int xmax = points[0][1];
        
        for (int i = 1; i < points.length; i++){
            int[] cur = points[i];
            if (cur[0] <= xmax){
                xmax = Math.min(xmax, cur[1]);
            }else{
                res++;
                xmax = cur[1];
            }
        }
        return res;
    }
}
