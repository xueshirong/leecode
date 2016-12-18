package org.leecode.Common;

import java.util.ArrayList;

public class DirectedGraphNode {
	//Definition for Undirected graph.
	public int label;
	public ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
  	  label = x; 
  	  neighbors = new ArrayList<DirectedGraphNode>(); 
    }	      
}
