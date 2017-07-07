package AM;

import java.util.*;
class MemLuch{
	String person;
	String lunch;
	public MemLuch(String n, String v){
		person = n;
		lunch = v;
	}
}

public class Match_Lunches {
	
	public static void main(String[] args) {
		String[][] lunchMenuPairs = new String[][]{{"Pizza", "Italian"},{"Pizza", "Italian"},{"Curry", "Indian"},{"Masala", "Indian"},{"Noodle", "China"}};
		String[][] teamCuisinePreference = new String[][]{{"Jose", "Italian"},{"John", "Indian"},{"Sarah", "Thai"}, {"May","*"}};
		String[][] res = matchLunches(lunchMenuPairs, teamCuisinePreference);
		printRes(res);
		
		lunchMenuPairs = new String[][]{{"Pizza", "Italian"},{"Curry", "Indian"},{"Masala", "Indian"}};
		teamCuisinePreference = new String[][]{{"Jose", "Italian"},{"John", "Indian"},{"Sarah", "Thai"}, {"May","*"}};
		res = matchLunches(null, teamCuisinePreference);
		printRes(res);
		
	}
	
	private static void printRes(String[][] res) {
		for (String[] personLunch : res){
			System.out.println(personLunch[0] + "->" + personLunch[1]);
		}
		System.out.println("------------");
	}

	public static String[][] matchLunches(String[][] lunchMenuPairs, String[][] teamCuisinePreference){
		//corner case
		if (lunchMenuPairs == null || lunchMenuPairs.length == 0 || 
			teamCuisinePreference == null || teamCuisinePreference.length == 0)
			return new String[][]{};
		
		//intial the map of menu to lunch
		HashMap<String, HashSet<String>> mapMenu = new HashMap<String, HashSet<String>>();
		for (String[] menu : lunchMenuPairs){
			HashSet<String> setLunch = mapMenu.get(menu[1]);
			if (setLunch == null)
				setLunch = new HashSet<String>();
			setLunch.add(menu[0]);
			mapMenu.put(menu[1], setLunch);
		}
		
		//loop member, get result
		List<MemLuch> listRes = new ArrayList<MemLuch>();
		List<MemLuch> nodes = new ArrayList<MemLuch>();
		for (String[] member : teamCuisinePreference){
			nodes.clear();
			String person = member[0];
			String menu = member[1];
			if (menu.equals("*")){//add all menu-lunch to person
				for (String m : mapMenu.keySet()){
					nodes = getMemLunchNode(person, mapMenu.get(m));
					listRes.addAll(nodes);
				}
			}else{//add relative menu-lunch to person
				nodes = getMemLunchNode(person, mapMenu.get(menu));
				listRes.addAll(nodes);
			}
		}
		
		//conver list to String[][]
		String[][] res = new String[listRes.size()][2];
		for(int i = 0; i < listRes.size(); i++){
			res[i][0] = listRes.get(i).person;
			res[i][1] = listRes.get(i).lunch;
		}
			
		return res;
	}

	private static List<MemLuch> getMemLunchNode(String person, HashSet<String> lunches) {
		List<MemLuch> res = new ArrayList<MemLuch>();
		if (lunches == null)
			return res;
		for (String lunch : lunches){
			MemLuch node = new MemLuch(person, lunch);
			res.add(node);
		}
		return res;
	}
}
