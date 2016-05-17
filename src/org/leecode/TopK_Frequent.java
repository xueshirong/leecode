package org.leecode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK_Frequent {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> counterMap = new HashMap<>();
		for (int num : nums) {
			int count = counterMap.getOrDefault(num, 0);
			counterMap.put(num, count + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = 
				new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		
		for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k)
				pq.poll();
		}

		List<Integer> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}
		return res;
	}
	
	public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }else{
                countMap.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
        new PriorityQueue<Map.Entry<Integer, Integer>>((a,b)->a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> en: countMap.entrySet()){
            pq.offer(en);
            if (pq.size() > k)
                pq.poll();
        }
        
        List<Integer> res = new LinkedList<Integer>();
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        
        return res;
    }
}