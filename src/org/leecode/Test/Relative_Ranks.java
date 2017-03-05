package org.leecode.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Relative_Ranks {
	class Pair {
        int index;
        int rank;
        public Pair(int index, int rank){
            this.index = index;
            this.rank = rank;
        }
    }
    //创建新class pair,用于存储index和rank。将pair对象存入PriorityQueue，降序。然后从队列中逐一拿出
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        if (nums == null || nums.length == 0)
            return res;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(10, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.rank - a.rank;
            }
        });
        for (int i = 0; i < nums.length; i++){
            Pair p = new Pair(i, nums[i]);
            pq.offer(p);
        }
        int i = 0;
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            if (i == 0)
                res[p.index] = "Gold Medal";
            else if (i == 1)
                res[p.index] = "Silver Medal";
            else if (i == 2)
                res[p.index] = "Bronze Medal";
            else
                res[p.index] = String.valueOf(i + 1);
            i++;
        }
        return res;
    }
}
