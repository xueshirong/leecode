package AM;

import java.util.*;
//From 1point3arch
public class Item_Association {
	public static void main(String[] args) {
		// new String[] {"friend3", "friend4", "friend5"}
		String[] res = findLargestFriendCircle(
				new String[][] { { "friend1", "friend2" },{ "friend2", "friend3" }, { "friend4", "friend5" }, { "friend5", "friend6" }, });
		System.out.print(res);
		res = findLargestFriendCircle(new String[][] { { "friend1", "friend2" }, { "friend3", "friend4" }, { "friend4", "friend5" },});
		System.out.print(res);
	}

	private static String[] findLargestFriendCircle(String[][] edges) {

		Map<String, String> map = new HashMap<>();
		for (String[] pair : edges) {
			map.put(pair[0], pair[0]);
			map.put(pair[1], pair[1]);
		}
		for (String[] pair : edges) {
			String unionKey = null, other = null;
			String key0 = map.get(pair[0]), key1 = map.get(pair[1]);
			if (key0.compareTo(key1) < 0) {
				unionKey = key0;
				other = pair[1];
			} else {
				unionKey = key1;
				other = pair[0];
			}
			map.put(other, unionKey);
		}
		Map<String, Integer> counts = new HashMap<>();
		for (Map.Entry<String, String> ent : map.entrySet()) {
			counts.put(ent.getValue(), counts.getOrDefault(ent.getValue(), 0) + 1);
		}

		int max = -1;
		String maxKey = null;
		for (Map.Entry<String, Integer> ent : counts.entrySet()) {
			if (ent.getValue() > max || (ent.getValue() == max && ent.getKey().compareTo(maxKey) < 0)) {
				max = ent.getValue();
				maxKey = ent.getKey();
			}
		}
		String[] res = new String[max];
		for (Map.Entry<String, String> ent : map.entrySet()) {
			if (ent.getValue().equals(maxKey)) {
				res[--max] = ent.getKey();
			}
		}

		Arrays.sort(res);
		System.out.println(Arrays.toString(res));
		return res;
	}
}
