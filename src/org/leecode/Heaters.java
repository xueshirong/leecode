package org.leecode;

import java.util.Arrays;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0)
            return 0;
        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for(int house : houses){
            int left = 0;
            int right = heaters.length - 1;
            while (left + 1 < right){//right 就是第一个大于等于house的heater; left 就是第一个小于等于house的heater
                int mid = left + (right - left)/2;
                if (heaters[mid] < house)
                    left =  mid;
                else
                    right = mid;
            }
            //在left, right 中找出距离最近的一个heater位置
            int dis = Math.min(Math.abs(house - heaters[left]), Math.abs(heaters[right] - house));
            res = Math.max(res, dis);
        }
        return res;
    }
}
