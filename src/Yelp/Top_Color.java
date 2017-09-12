package Yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return the color that occurs most frequently. In case of a tie, return the most frequent colors soted alphabetically.
 * Example 1:
 * Input:
 * [
 * 	['red', 'red', 'green',]
 * 	['black', 'blue', 'black',]
 * 	['red', 'yellow', 'yellow',]
 * ]
 * Output: ['red']
 * Example 2:
 * Input:
 * [
 * 	['red', 'green', 'green',]
 * 	['black', 'blue', 'black',]
 * 	['red', 'yellow', 'yellow',]
 * ]
 * Output: ['black', 'green', 'red', 'yellow']
 * 
 * @author Xue
 *
 */
public class Top_Color {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		List<List<String>> colors = new ArrayList<>();
		List<String> color1 = new ArrayList<>();
		List<String> color2 = new ArrayList<>();
		List<String> color3 = new ArrayList<>();
		color1.add("red");
		color1.add("black");
		color1.add("green");
		color2.add("white");
		color2.add("red");
		color2.add("black");
		color3.add("black");
		color3.add("red");
		colors.add(color1);
		colors.add(color2);
		colors.add(color3);
		System.out.println(topColor(colors));
	}
	
	private static List<String> topColor(List<List<String>> colors){
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for(int i = 0; i < colors.size(); i ++){
			List<String> color = colors.get(i);
			for(int j = 0; j < color.size(); j ++){
				String cur = color.get(j);
				Integer count = map.get(cur);
				if(count == null){
					map.put(cur, 1);
					max = Math.max(max, 1);
				}else{
					map.put(cur, count + 1);
					max = Math.max(max, count + 1);
				}
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue() == max){
				result.add(entry.getKey());
			}
		}
		Collections.sort(result, new Comparator<String>(){
			@Override
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		return result;
	}
}
