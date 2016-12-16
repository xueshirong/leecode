package org.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Clone_Graph {
	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //corner case
        if (node == null)
            return null;
        
        //find all nodes
        List<UndirectedGraphNode> list = findallnodes(node);
        //copy all node to new list?
        List<UndirectedGraphNode> newlist = copytonewlist(list);
        //copy all edges(neighbors)
        copyedges(list, newlist);
        
        return newlist.get(0);
    }
    private List<UndirectedGraphNode> findallnodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        q.add(node);
        set.add(node);
        list.add(node);
        while (!q.isEmpty()){
            UndirectedGraphNode head = q.poll();
            for (int i = 0; i < head.neighbors.size(); i++){
                UndirectedGraphNode temp = head.neighbors.get(i);
                if (set.contains(temp))
                    continue;
                q.add(temp);
                set.add(temp);
                list.add(temp);
            }
        }
        return list;
    }
    
    private List<UndirectedGraphNode> copytonewlist(List<UndirectedGraphNode> list){
        List<UndirectedGraphNode> res = new ArrayList<UndirectedGraphNode>();
        for (int i = 0; i < list.size(); i++){
            res.add(new UndirectedGraphNode(list.get(i).label));
        }
        return res;
    }
    
    private void copyedges(List<UndirectedGraphNode> list, List<UndirectedGraphNode> newlist){
        for (int i = 0; i < list.size(); i++){
            UndirectedGraphNode node = list.get(i);
            for (int j = 0; j < node.neighbors.size(); j++){
                UndirectedGraphNode neig = node.neighbors.get(j);
                newlist.get(i).neighbors.add(neig);
            }
        }
    }
}
