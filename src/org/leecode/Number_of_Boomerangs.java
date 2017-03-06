package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Boomerangs {
	//首先将所有点到其他所有点的距离的平方作为key保存到map容器中，key相同就累加value，
    //然后计算每个元素的value*(value-1)，并累加到返回结果中，最终就得到符合条件的点序列数
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//map 定义在for外面，每次for之后，清空map。可以提升速度
        for (int i = 0; i < points.length; i++){
            int[] p1 = points[i];
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;
                int[] p2 = points[j];
                int dx = p2[0] - p1[0];
                int dy = p2[1] - p1[1];
                int dis = dx * dx + dy * dy;
                if (map.containsKey(dis))
                    map.put(dis, map.get(dis) + 1);
                else
                    map.put(dis, 1);
            }
            for (int val : map.values()){
                if (val == 1)   continue;
                res += val * (val - 1);
            }
            map.clear();
        }
        return res;
    }
}
