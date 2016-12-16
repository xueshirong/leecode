package org.leecode.Common;

import java.util.ArrayList;

public class UndirectedGraphNode {
	//Definition for Undirected graph.
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
  	  label = x; 
  	  neighbors = new ArrayList<UndirectedGraphNode>(); 
    }	      
}
