package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.leecode.Common.DirectedGraphNode;

public class Topological_Sorting {
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        //corner case
        if (graph == null)
            return null;
        //set input degree
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode nei : node.neighbors){
                if (map.containsKey(nei))
                    map.put(nei, map.get(nei) + 1);
                else
                    map.put(nei, 1);
            }
        }
        
        //find head node whose input degree is 0
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph){
            if (!map.containsKey(node)){//if the node is not in the map, the node is the head
                q.add(node);
                res.add(node);//do not break, maybe there are multiple heads
            }
        }
        
        //bfs get one order
        while (!q.isEmpty()){
            DirectedGraphNode head = q.poll();
            for (DirectedGraphNode nei : head.neighbors){
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0){
                    q.add(nei);
                    res.add(nei);
                }
            }
        }
    
        return res;
    }
}
