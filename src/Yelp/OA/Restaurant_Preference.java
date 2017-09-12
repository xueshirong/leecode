package Yelp.OA;

import java.util.*;

/**
 * D and H want to find a lunch spot and both of them have a list of favorite place ordered by decresing preference.
 * They agree that they will select the restaurant with the least combined rank in the 2 list. Example:
 * Input:
 * 	restaurants_1: ['EI Farolito', 'Japa Curry', 'Eatsa']
 * 	restaurants_2: ['Japa Curry', 'Eatsa', 'Ayola', 'Working Girls']
 * Output: 'Japa Curry'. Because it has the least combined rank 3.
 * The restaurant should be in both the lists to be selected.
 * The input provided will not have 2 restaurants with the same rank. So you don't have to factor the in.
 * They will eat a 'Yelpwich' if they can't reach a consensus.
 * @author Xue
 *
 */
public class Restaurant_Preference {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list1.addAll(Arrays.asList("ab", "barr", "bar", "foo" ,"bar"));
		list2.addAll(Arrays.asList("bar", "foo"));
		System.out.println(minIndexSum(list1, list2));
		list1.clear();
		list2.clear();
		list1.addAll(Arrays.asList("ab", "do"));
		list2.addAll(Arrays.asList("bar", "foo"));
		System.out.println(minIndexSum(list1, list2));
	}
	public static String minIndexSum(List<String> list1, List<String> list2){
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < list1.size(); i ++){
			String cur = list1.get(i);
			Integer index = map.get(cur);
			if(index == null){
				map.put(cur, i);
			}
		}
		int min = Integer.MAX_VALUE;
		int minStringIndex = -1;
		for(int i = 0; i < list2.size(); i ++){
			String cur = list2.get(i);
			Integer index = map.get(cur);
			if(index != null){
				if(index + i < min){
					min = index + i;
					minStringIndex = index; 
				}
			}
		}
		return minStringIndex == -1 ? "Yelpwich" : list1.get(minStringIndex);
	}

}
