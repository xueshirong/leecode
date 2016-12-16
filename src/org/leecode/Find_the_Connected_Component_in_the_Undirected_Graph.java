package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_the_Connected_Component_in_the_Undirected_Graph {
	//1. From 1st node of list, search all nodes that can reache, 
	//they are one connected component, add them to new list, and remove from old list.
    //2. Then still from the 1st node of old list(many nodes were already removed), repeat step 1.
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (nodes == null || nodes.size() == 0)
            return res;
        //loop all nodes one by one, remove from list
        while(nodes.size() > 0){
            UndirectedGraphNode head = nodes.get(0);
            //find all nodes from this head, add to new list and remove from old list
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
            List<Integer> path = new ArrayList<Integer>();
            q.add(head);
            set.add(head);
            path.add(head.label);
            nodes.remove(head);
            while (!q.isEmpty()){
                UndirectedGraphNode node = q.poll();
                for (int i = 0; i < node.neighbors.size(); i++){
                    if (set.contains(node.neighbors.get(i)))
                        continue;
                    q.add(node.neighbors.get(i));
                    set.add(node.neighbors.get(i));
                    path.add(node.neighbors.get(i).label);
                    nodes.remove(node.neighbors.get(i));
                }
            }
            Collections.sort(path);//it shows error without sort. wired
            res.add(path);
        }
        return res;
    }
    //----------Solution 2 --------------
    public List<List<Integer>> connectedSet2(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (nodes == null || nodes.size() == 0)
            return res;
        //loop all nodes one by one, remove from list
        while(nodes.size() > 0){
            UndirectedGraphNode head = nodes.get(0);
            List<Integer> path = new ArrayList<Integer>();
            bfs(head, nodes, path);
            res.add(path);
        }
        return res;
    }
    
    //find all nodes from this head, add to new list and remove from old list
    private void bfs(UndirectedGraphNode head, ArrayList<UndirectedGraphNode> nodes, List<Integer> path){
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
          
        q.add(head);
        set.add(head);
        path.add(head.label);
        nodes.remove(head);
        while (!q.isEmpty()){
            UndirectedGraphNode node = q.poll();
            for (int i = 0; i < node.neighbors.size(); i++){
                if (set.contains(node.neighbors.get(i)))
                    continue;
                q.add(node.neighbors.get(i));
                set.add(node.neighbors.get(i));
                path.add(node.neighbors.get(i).label);
                nodes.remove(node.neighbors.get(i));
            }
        }
        Collections.sort(path);//it shows error without sort. wired
    }
}
