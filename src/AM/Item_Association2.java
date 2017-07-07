package AM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//refer leetcode 323
public class Item_Association2 {
	public static void main(String[] args) {
		List<String> res = countComponents(new String[][] { { "0", "1" }, { "0", "5" }, { "1", "2" }, { "3", "4" }, });
		System.out.println(res);

		res = countComponents(new String[][] { { "0", "1" }, { "1", "2" }, { "3", "4" }, });
		System.out.println(res);

		res = countComponents(new String[][] { { "1", "2" }, { "2", "3" }, { "4", "5" }, { "5", "6" }, });
		System.out.println(res);
	}

	public static List<String> countComponents(String[][] edges) {
		int res = 0;
		// 1. map to save all adjacent information
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String[] edge : edges) {
			map.put(edge[0], new ArrayList<>());
			map.put(edge[1], new ArrayList<>());
		}

		// 2. set connection info to map
		for (String[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		List<String> list = new ArrayList<String>();
		List<String> tmp = new ArrayList<String>();
		Set<String> set = new HashSet<>();// record unique node
		// 3. loop each node to find components
		// for (int i = 0; i < map.size(); i++) {
		for (String key : map.keySet()) {
			if (set.add(key)) {// start node of Connected Components

				tmp.clear();
				tmp.add(key);
				// ----
				helper(key, map, set, tmp);
				res++;
				// ----
				if (tmp.size() > list.size())
					list = new ArrayList(tmp);
			}
		}
		// System.out.println(list);
		return list;
	}

	// add all connected node to Set
	private static void helper(String key, Map<String, List<String>> map, Set<String> set) {
		for (String value : map.get(key)) {// loop each connected node to save
											// to set
			if (set.add(value)) {
				helper(value, map, set);
			}
		}
	}

	// add all connected node to Set
	private static void helper(String key, Map<String, List<String>> map, Set<String> set, List<String> list) {
		for (String val : map.get(key)) {// loop each connected node to save to set
			if (set.add(val)) {
				list.add(val);
				helper(val, map, set, list);
			}
		}
	}
}
