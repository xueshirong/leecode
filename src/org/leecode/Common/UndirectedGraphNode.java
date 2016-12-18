package org.leecode.Common;

import java.util.ArrayList;

public class UndirectedGraphNode {
	//Definition for Undirected graph.
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
  	  label = x; 
  	  neighbors = new ArrayList<UndirectedGraphNode>(); 
    }	      
}
