package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Six_Degrees {
	/**
	 * @param graph
	 *            a list of Undirected graph node
	 * @param s,
	 *            t two Undirected graph nodes
	 * @return an integer
	 */
	public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
		// corner case
		if (graph == null || graph.size() == 0 || s.equals(t))
			return 0;

		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		// using map to record current node and current level. Note, HashSet can
		// record level
		HashMap<UndirectedGraphNode, Integer> map = new HashMap<UndirectedGraphNode, Integer>();
		q.add(s);
		map.put(s, 0);
		while (!q.isEmpty()) {
			UndirectedGraphNode head = q.poll();
			int level = map.get(head);
			for (int i = 0; i < head.neighbors.size(); i++) {
				UndirectedGraphNode node = head.neighbors.get(i);
				if (map.containsKey(node))
					continue;
				if (node.equals(t)) {
					return level + 1;
				}
				q.add(node);
				map.put(node, level + 1);
			}
		}
		return -1;
	}
}

// Definition for Undirected graph.
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
