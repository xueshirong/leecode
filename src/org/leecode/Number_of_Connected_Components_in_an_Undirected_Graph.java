package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Number_of_Connected_Components_in_an_Undirected_Graph {
	public int countComponents(int n, int[][] edges) {
		//corner case
        if (n <= 1)
            return n;
        int res = 0;
        //1. map to save all adjacent information
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {//initial map
            map.put(i, new ArrayList<>());
        }
        //2. set connection info to map
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> set = new HashSet<>();//record unique node
        //3. loop each node to find components
        for (int i = 0; i < n; i++) {
            if (set.add(i)) {//start node of Connected Components
            	helper(i, map, set);
                res++;
            }
        }
        return res;
    }
	
	//add all connected node to Set
    private void helper(int node, Map<Integer, List<Integer>> map, Set<Integer> set) {
        for (int j : map.get(node)) {//loop each connected node to save to set
            if (set.add(j)){
            	helper(j, map, set);
            }
        }
    }
}
